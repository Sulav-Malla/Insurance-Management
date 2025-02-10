package com.ims.dao.impl;

import com.ims.dao.AdminInsuranceDAO;
import com.ims.model.Category;
import com.ims.model.Customer;
import com.ims.model.Policy;
import com.ims.model.SubCategory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AdminInsuranceDAOImpl implements AdminInsuranceDAO {

	private Scanner sc = new Scanner(System.in);
	private static List<Policy> polList = new ArrayList<>();
	private static List<Category> categories = new ArrayList<>();
	private static List<SubCategory> subCategories = new ArrayList<>();
	List<Customer> usrList = UserDAOImpl.getUsrList();

	// just random initial data
	static {
		Category category1 = new Category("Health Insurance");
		Category category2 = new Category("Life Insurance");

		SubCategory subCategory1 = new SubCategory("Individual Health");
		SubCategory subCategory2 = new SubCategory("Family Health");
		SubCategory subCategory3 = new SubCategory("Whole Life");
		SubCategory subCategory4 = new SubCategory("Term Life");

		subCategories.add(subCategory1);
		subCategories.add(subCategory2);
		subCategories.add(subCategory3);
		subCategories.add(subCategory4);

		Policy policy1 = new Policy("Basic Health Plan", category1, subCategory1, "A basic health insurance plan",
				500.00, 10000.00, 1, "Open");
		Policy policy2 = new Policy("Premium Health Plan", category1, subCategory2,
				"A premium family health insurance plan", 1000.00, 30000.00, 2, "Open");
		Policy policy3 = new Policy("Whole Life Plan", category2, subCategory3, "A whole life insurance plan", 1200.00,
				50000.00, 20, "Open");
		Policy policy4 = new Policy("Term Life Plan", category2, subCategory4, "A term life insurance plan", 800.00,
				25000.00, 10, "Open");

		subCategory1.addPolicy(policy1);
		subCategory2.addPolicy(policy2);
		subCategory3.addPolicy(policy3);
		subCategory4.addPolicy(policy4);

		category1.addSubCategory(subCategory1);
		category1.addSubCategory(subCategory2);
		category2.addSubCategory(subCategory3);
		category2.addSubCategory(subCategory4);

		categories.add(category1);
		categories.add(category2);

		polList.add(policy1);
		polList.add(policy2);
		polList.add(policy3);
		polList.add(policy4);
	}

	// getters to help view
	public static List<Policy> getPolList() {
		return polList;
	}

	public static List<Category> getCategories() {
		return categories;
	}

	public static List<SubCategory> getSubCategories() {
		return subCategories;
	}

	// adds policy
	@Override
	public void addPolicy() {

		int choice = 1;
		try {
			while (choice == 1) {
				String pName = getValidString("Enter the policy name: ");
				String pDescription = getValidString("Enter the policy description: ");
				double pPremium = getValidDouble("Enter the policy premium: ");
				double pCoverage = getValidDouble("Enter the policy coverage: ");
				int pTerm = getValidNumber("Enter the policy term: ");
				String status = getValidString("Enter the policy status: ");

				String categoryName = getValidString("Enter the category name to add the policy to: ");
				Category category = findCategory(categoryName);

				String subCategoryName = getValidString("Enter the subcategory name to add the policy to: ");
				SubCategory subCategory = findSubCategory(subCategoryName, category);

				if (category != null && subCategory != null) {
					Policy newPolicy = new Policy(pName, category, subCategory, pDescription, pPremium, pCoverage,
							pTerm, status);
					subCategory.addPolicy(newPolicy);
					polList.add(newPolicy);
					System.out.println("Policy added successfully under category: " + category.getName()
							+ " -> subcategory: " + subCategory.getName());
					System.out.println("New Policy: \n" + newPolicy.toString());
					choice = getValidNumber("Do you want to add another record? 1) Yes  2) No (Choose 1 or 2):",
							"^[12]$");

				} else {
					System.out.println("The category/sub-category doesn't exist!");
					choice = getValidNumber("Do you want to try again? 1) Yes  2) No (Choose 1 or 2):", "^[12]$");
				}

			}
		} catch (Exception e) {
			System.out.println("Something Went Wrong! -> " + e.getMessage());
		}
	}

	// updates specific elements of policy
	@Override
	public void updatePolicy(int policyId) {

		if (!polList.isEmpty()) {
			boolean policyFound = false; // policy finding tracker
			for (Policy pol : polList) {
				int id = pol.getPolicyId();

				// Check if policyId matches
				if (id == policyId) {
					policyFound = true; // policy found

					System.out.println("============================================");
					System.out.println("          What Do You Want To Update?        ");
					System.out.println("               1)Name             ");
					System.out.println("               2)Description                 ");
					System.out.println("               3)Premium              ");
					System.out.println("               4)Coverage              ");
					System.out.println("               5)Term              ");
					System.out.println("               6)Exit              ");
					System.out.println("============================================");

					System.out.println("Enter the choice");
					int choice = sc.nextInt();

					sc.nextLine();

					switch (choice) {

					case 1:
						System.out.print("Enter new name: ");
						pol.setPolicyName(sc.nextLine());
						break;
					case 2:
						System.out.print("Enter new description: ");
						pol.setDescription(sc.nextLine());
						break;
					case 3:
						System.out.print("Enter new premium: ");
						pol.setPremiumAmount(sc.nextDouble());
						sc.nextLine();
						break;
					case 4:
						System.out.print("Enter new coverage: ");
						pol.setCoverageAmount(sc.nextDouble());
						sc.nextLine();
						break;
					case 5:
						System.out.print("Enter new term period: ");
						pol.setPolicyTerm(sc.nextInt());
						sc.nextLine();
						break;
					case 6:
						// Exit choice
						System.out.println("Exiting update process.");
						return;
					default:
						System.out.println("Please choose between 1 and 6");
					} // end of switch
				} // end of if
			} // end of for loop

			if (!policyFound) {
				System.out.println("Policy with ID " + policyId + " not found.");
			}
		} // end of outer if

	}

	@Override
	public void deletePolicy(int policyId) {
		polList.removeIf(policy -> policy.getPolicyId() == policyId);

	}

	// allows addition of category, with initial empty sub list
	@Override
	public void addCategory() {

		int choice = 1;
		try {
			while (choice == 1) {

				String categoryName = getValidString("Enter the category name: ");
				Category newCat = getNewCategory(categoryName);
				if (newCat != null) {
					categories.add(newCat);
					choice = getValidNumber("Do you want to add another category? 1) Yes  2) No (Choose 1 or 2):",
							"^[12]$");
				} else {
					System.out.println("The category already exists!");
					choice = getValidNumber("Do you want to try again? 1) Yes  2) No (Choose 1 or 2):", "^[12]$");
				}

			}
		} catch (Exception e) {
			System.out.println("Something Went Wrong! -> " + e.getMessage());
		}
	}

	// helper function to check category exists already or not
	private Category getNewCategory(String categoryName) {
		for (Category category : categories) {
			if (category.getName().equals(categoryName)) {
				return null;
			}
		}
		Category newCategory = new Category(categoryName);
		return newCategory;
	}

	@Override
	public void removeCategory(int categoryId) {
		categories.removeIf(category -> category.getCategoryID() == categoryId);
	}

	@Override
	public void updateCategory(int categoryId) {
		if (!categories.isEmpty()) {
			boolean categoryFound = false;
			for (Category category : categories) {
				if (category.getCategoryID() == categoryId) {
					categoryFound = true;
					System.out.println("============================================");
					System.out.println("          What Do You Want To Update?        ");
					System.out.println("               1) Name             ");
					System.out.println("               2) SubCategories             ");
					System.out.println("               3) Exit              ");
					System.out.println("============================================");

					System.out.println("Enter the choice");
					int choice = sc.nextInt();

					sc.nextLine();

					switch (choice) {
					case 1:
						System.out.print("Enter new name: ");
						category.setName(sc.nextLine());
						break;

					case 2:
						System.out.print("Enter subcategory ID: ");
						updateSubCategory(sc.nextInt());
						sc.nextLine();
						break;
					case 3:
						// Exit choice
						System.out.println("Exiting update process.");
						return;
					default:
						System.out.println("Please choose between 1 and 4");
					} // end of switch
				} // end of if
			} // end of for

			if (!categoryFound) {
				System.out.println("Category with ID " + categoryId + " not found.");
			}
		} // end of outer if
	}

	// allows adding sub categories
	@Override
	public void addSubCategory() {

		int choice = 1;
		try {
			while (choice == 1) {

				String subName = getValidString("Enter the sub category name: ");
				String categoryName = getValidString("Enter the category the sub category belongs to: ");
				SubCategory newSub = getNewSubCategory(subName, categoryName);
				if (newSub != null) {
					subCategories.add(newSub);
					choice = getValidNumber("Do you want to add another sub category? 1) Yes  2) No (Choose 1 or 2):",
							"^[12]$");
				} else {
					System.out.println("The subcategory already exists -- OR -- Invalid category name");
					choice = getValidNumber("Do you want to try again? 1) Yes  2) No (Choose 1 or 2):", "^[12]$");
				}

			}
		} catch (Exception e) {
			System.out.println("Something Went Wrong! -> " + e.getMessage());
		}
	}

	// helper method to check sub category already exists or not
	private SubCategory getNewSubCategory(String subName, String categoryName) {

		for (Category category : categories) {
			if (category.getName().equals(categoryName)) {
				for (SubCategory subCat : category.getSubCategories()) {
					if (subCat.getName().equals(subName)) {
						return null;
					}
				}
				SubCategory newSubCat = new SubCategory(subName);
				category.addSubCategory(newSubCat);
				return newSubCat;
			}
		}
		return null;

	}

	@Override
	public void removeSubCategory(int subCategoryId) {
		subCategories.removeIf(subCat -> subCat.getSubID() == subCategoryId);
	}

	@Override
	public void updateSubCategory(int subCategoryId) {
		if (!subCategories.isEmpty()) {
			boolean subCatFound = false;
			for (SubCategory subCat : subCategories) {
				if (subCat.getSubID() == subCategoryId) {
					subCatFound = true;
					System.out.println("============================================");
					System.out.println("          What Do You Want To Update?        ");
					System.out.println("               1) Name             ");
					System.out.println("               2) Policy             ");
					System.out.println("               3) Exit              ");
					System.out.println("============================================");

					System.out.println("Enter the choice");
					int choice = sc.nextInt();

					sc.nextLine();

					switch (choice) {
					case 1:
						System.out.print("Enter new name: ");
						subCat.setName(sc.nextLine());
						break;
					case 2:
						System.out.print("Enter policy ID: ");
						updatePolicy(sc.nextInt());
						sc.nextLine();
						break;
					case 3:
						// Exit choice
						System.out.println("Exiting update process.");
						return;
					default:
						System.out.println("Please choose between 1 and 3");

					} // end of switch
				} // end of if
			} // end of for

			if (!subCatFound) {
				System.out.println("Subcategory with ID " + subCategoryId + " not found.");
			}
		} // end of outer if
	}

	// helps manage user who have pending policy application
	@Override
	public void managePolicyRequest() {
		if (usrList.isEmpty()) {
			System.out.println("There are no users!");

		}
		for (Customer usr : usrList) {
			if (!usr.getAppliedPolicies().isEmpty()) {
				System.out.println(usr.getUserName() + " Applied Policy: ");
				Iterator<Policy> iterator = usr.getAppliedPolicies().iterator(); 
				while (iterator.hasNext()) { // deletes policy from user list if the admin accepts or rejects
					Policy pol = iterator.next();
					System.out.println(pol.toString());
					System.out.println();
					pol.toString();
					System.out.println("				What do you plan to do?			");
					System.out.println("					1) Accept  ");
					System.out.println("					2) Reject  ");
					System.out.println("					3) Next Policy  ");
					System.out.println("					4) Back  ");
					int choice = sc.nextInt();
					switch (choice) {
					case 1:
						pol.setStatus("Active");
						List<Policy> newPolList = usr.getMyPolicies();
						newPolList.add(pol);
						usr.setMyPolicies(newPolList);
						iterator.remove();
						break;
					case 2:
						pol.setStatus("Rejected");
						iterator.remove();
						break;
					case 3:
						continue;
					case 4:
						return;
					default:
						System.out.println("Please choose a valid option!");
					} // end of switch
				} // end of while
			} // end of if
		} // end of outer for

	}

	// helper to find category when adding policy
	private Category findCategory(String categoryName) {
		for (Category category : categories) {
			if (category.getName().equals(categoryName)) {
				return category;
			}
		}
		return null;
	}

	// helper to find sub category when adding policy
	private SubCategory findSubCategory(String subCategoryName, Category category) {
		if (category != null) {
			for (SubCategory subcat : category.getSubCategories()) {
				if (subcat.getName().equals(subCategoryName)) {
					return subcat;
				}
			}
		}
		return null;
	}

	// input checkers
	private int getValidNumber(String message) {
		return getValidNumber(message, "^[1-9]\\d*$");
	}

	private int getValidNumber(String message, String pattern) {
		while (true) {
			System.out.println(message);
			String input = sc.nextLine().trim();
			if (input.matches(pattern)) {
				return Integer.parseInt(input);
			}
			System.out.println("Invalid input! Please try again.");
		}
	}

	private double getValidDouble(String message) {
		return getValidNumber(message, "^[1-9]\\d*(\\.\\d+)?$");
	}

	private String getValidString(String message) {
		while (true) {
			try {
				System.out.println(message);
				String input = sc.nextLine().trim();
				if (input.matches("^[a-zA-Z ]+$")) {
					return input;
				}
				System.out.println("Invalid input! Only alphabets and spaces are allowed.");
			} catch (Exception e) {
				System.out.println("An error occurred while reading input. Please try again.");
			}
		}
	}

}
