package com.ims.dao.impl;

import com.ims.dao.InsuranceDAO;
import com.ims.model.Category;
import com.ims.model.Policy;
import com.ims.model.SubCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsuranceDAOImpl implements InsuranceDAO {

	private Scanner sc = new Scanner(System.in);
	static List<Policy> polList = new ArrayList<>();
	static List<Category> categories = new ArrayList<>();

	@Override
	public void addPolicy() {
		int choice = 1;
		try {
			while (choice == 1) {
				int pid = getValidNumber("Enter the policy ID: ");
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
					Policy newPolicy = new Policy(pid, pName, category, subCategory, pDescription, pPremium, pCoverage,
							pTerm, status);
					subCategory.addPolicy(newPolicy);

					System.out.println("Policy added successfully under category: " + category.getName()
							+ " -> subcategory: " + subCategory.getName());
					System.out.println("New Policy: \n" + newPolicy.toString());

					choice = getValidNumber("Do you want to add another record? 1) Yes  2) No (Choose 1 or 2):",
							"^[12]$");
				}
				else {
					System.out.println("The category/sub-category doesn't exist!");
				}

			}
		} catch (Exception e) {
			System.out.println("Something Went Wrong! -> " + e.getMessage());
		}
	}

	@Override
	public Policy getPolicyById(int policyId) {
		for (Policy policy : polList) {
			if (policy.getPolicyId() == policyId) {
				return policy;
			}
		}
		return null;
	}

	@Override
	public List<Policy> getAllPolicies() {
		return polList;
	}

	@Override
	public void updatePolicy(Policy policy) {
	}

	@Override
	public void deletePolicy(int policyId) {
		polList.removeIf(policy -> policy.getPolicyId() == policyId);
	}

	private Category findCategory(String categoryName) {
		return null;
	}

	private SubCategory findSubCategory(String subCategoryName, Category category) {
		return null;
	}

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

	@Override
	public void addCategory(Category category) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeCategory(int categoryId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addSubCategory(SubCategory subCategory, int categoryId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeSubCategory(int subCategoryId, int categoryId) {
		// TODO Auto-generated method stub

	}
}
