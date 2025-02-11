package com.ims.details;

import java.util.Scanner;
import com.ims.dao.impl.AdminInsuranceDAOImpl;
import com.ims.dao.impl.CustomerInsuranceDAOImpl;
import com.ims.dao.impl.UserDAOImpl;
import com.ims.model.Category;
import com.ims.model.Customer;
import com.ims.model.Policy;
import com.ims.model.SubCategory;

public class UserMenu {
	 private static Scanner sc = new Scanner(System.in);
	 public static void adminMenu() {
		    AdminInsuranceDAOImpl adminDAO = new AdminInsuranceDAOImpl();
		    
		    while (true) {
		        System.out.println("============================================");
		        System.out.println("               1) Manage Users            ");
		        System.out.println("               2) Manage Categories       ");
		        System.out.println("               3) Manage Subcategories    ");
		        System.out.println("               4) Manage Policies         ");
		        System.out.println("               5) Log Out                 ");
		        System.out.println("============================================");
		        System.out.println("Enter your choice: ");
		        
		        int mainChoice = sc.nextInt();
		        
		        switch (mainChoice) {
		            case 1:
		                manageUsers();
		                break;
		            case 2:
		                manageCategories(adminDAO);
		                break;
		            case 3:
		                manageSubcategories(adminDAO);
		                break;
		            case 4:
		                managePolicies(adminDAO);
		                break;
		            case 5:
		                return;
		            default:
		                System.out.println("Invalid choice! Please choose a valid option.");
		        }
		    }
		}

		// Method to manage users
		private static void manageUsers() {
		    System.out.println("============ User Management ============");
		    System.out.println("               1) View Users");
		    System.out.println("               2) Back to Main Menu");
		    System.out.println("=========================================");
		    
		    int choice = sc.nextInt();
		    
		    if (choice == 1) {
		        if (!UserDAOImpl.getUsrList().isEmpty()) {
		            for (Customer usr : UserDAOImpl.getUsrList()) {
		                System.out.println(usr.toString());
		                System.out.println();
		            }
		        } else {
		            System.out.println("No Users Registered!");
		        }
		    }
		}

		// Method to manage categories
		private static void manageCategories(AdminInsuranceDAOImpl adminDAO) {
		    while (true) {
		        System.out.println("============ Category Management ============");
		        System.out.println("               1) View Categories");
		        System.out.println("               2) Add Category");
		        System.out.println("               3) Update Category");
		        System.out.println("               4) Delete Category");
		        System.out.println("               5) Back to Main Menu");
		        System.out.println("=============================================");
		        
		        int choice = sc.nextInt();
		        
		        switch (choice) {
		            case 1:
		                for (Category category : AdminInsuranceDAOImpl.getCategories()) {
		                    System.out.println(category.toString());
		                    System.out.println();
		                }
		                break;
		            case 2:
		                adminDAO.addCategory();
		                break;
		            case 3:
		                System.out.println("Enter Category ID to update: ");
		                int catId = sc.nextInt();
		                adminDAO.updateCategory(catId);
		                break;
		            case 4:
		                System.out.println("Enter Category ID to delete: ");
		                int delCatId = sc.nextInt();
		                adminDAO.removeCategory(delCatId);
		                break;
		            case 5:
		                return;
		            default:
		                System.out.println("Invalid choice! Please choose a valid option.");
		        }
		    }
		}

		// Method to manage subcategories
		private static void manageSubcategories(AdminInsuranceDAOImpl adminDAO) {
		    while (true) {
		        System.out.println("============ Subcategory Management ============");
		        System.out.println("               1) View Subcategories");
		        System.out.println("               2) Add Subcategory");
		        System.out.println("               3) Update Subcategory");
		        System.out.println("               4) Delete Subcategory");
		        System.out.println("               5) Back to Main Menu");
		        System.out.println("================================================");
		        
		        int choice = sc.nextInt();
		        
		        switch (choice) {
		            case 1:
		                for (SubCategory subCat : AdminInsuranceDAOImpl.getSubCategories()) {
		                    System.out.println(subCat.toString());
		                    System.out.println();
		                }
		                break;
		            case 2:
		                adminDAO.addSubCategory();
		                break;
		            case 3:
		                System.out.println("Enter Subcategory ID to update: ");
		                int subCatId = sc.nextInt();
		                adminDAO.updateSubCategory(subCatId);
		                break;
		            case 4:
		                System.out.println("Enter Subcategory ID to delete: ");
		                int delSubCatId = sc.nextInt();
		                adminDAO.removeSubCategory(delSubCatId);
		                break;
		            case 5:
		                return;
		            default:
		                System.out.println("Invalid choice! Please choose a valid option.");
		        }
		    }
		}

		// Method to manage policies
		private static void managePolicies(AdminInsuranceDAOImpl adminDAO) {
		    while (true) {
		        System.out.println("============ Policy Management ============");
		        System.out.println("               1) View Policies");
		        System.out.println("               2) Add Policy");
		        System.out.println("               3) Update Policy");
		        System.out.println("               4) Delete Policy");
		        System.out.println("               5) Manage User Policies");
		        System.out.println("               6) Back to Main Menu");
		        System.out.println("===========================================");
		        
		        int choice = sc.nextInt();
		        
		        switch (choice) {
		            case 1:
		                for (Policy pol : AdminInsuranceDAOImpl.getPolList()) {
		                    System.out.println(pol.toString());
		                    System.out.println();
		                }
		                break;
		            case 2:
		                adminDAO.addPolicy();
		                break;
		            case 3:
		                System.out.println("Enter Policy ID to update: ");
		                int policyId = sc.nextInt();
		                adminDAO.updatePolicy(policyId);
		                break;
		            case 4:
		                System.out.println("Enter Policy ID to delete: ");
		                int delPolicyId = sc.nextInt();
		                adminDAO.deletePolicy(delPolicyId);
		                break;
		            case 5:
		                adminDAO.managePolicyRequest();
		                break;
		            case 6:
		                return;
		            default:
		                System.out.println("Invalid choice! Please choose a valid option.");
		        }
		    }
		}


	public static void userMenu(Customer usr) {
		
		CustomerInsuranceDAOImpl usrDAO = new CustomerInsuranceDAOImpl();

		while (true) {
			System.out.println("============================================");
			System.out.println("               1) VIEW Category          ");
			System.out.println("               2) VIEW Subcategory       ");
			System.out.println("               3) VIEW All Policy        ");
			System.out.println("               4) VIEW MY Policy         ");
			System.out.println("               5) APPLY for Policy       ");
			System.out.println("               6) Log Out                   ");
			System.out.println("============================================");
			System.out.println("Enter the choice: ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				for (Category category : AdminInsuranceDAOImpl.getCategories()) {
					System.out.println(category.toString());
					System.out.println();

				}
				break;
			case 2:
				for (SubCategory subCat : AdminInsuranceDAOImpl.getSubCategories()) {
					System.out.println(subCat.toString());
					System.out.println();

				}
				break;
			case 3:
				for (Policy pol : AdminInsuranceDAOImpl.getPolList()) {
					System.out.println(pol.toString());
					System.out.println();

				}
				break;
			case 4:
				usrDAO.viewMyPolicies(usr);
				break;
			case 5:
				usrDAO.applyForPolicy(usr);
				break;
			case 6:
				return;
			default:
				System.out.println("Invalid choice! Please choose a valid option.");
			} // end of switch
		} // end of while
	}
}
