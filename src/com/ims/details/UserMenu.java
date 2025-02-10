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
			System.out.println("               1)  VIEW Users            ");
			System.out.println("               2)  VIEW Category         ");
			System.out.println("               3)  VIEW SubCategory      ");
			System.out.println("               4)  VIEW Policy           ");
			System.out.println("               5)  ADD Category          ");
			System.out.println("               6)  UPDATE Category       ");
			System.out.println("               7)  DELETE Category       ");
			System.out.println("               8)  ADD Subcategory       ");
			System.out.println("               9)  UPDATE Subcategory    ");
			System.out.println("               10) DELETE Subcategory    ");
			System.out.println("               11) ADD Policy            ");
			System.out.println("               12) UPDATE Policy         ");
			System.out.println("               13) DELETE Policy         ");
			System.out.println("               14) MANAGE User Policy    ");
			System.out.println("               15) Log Out                 ");
			System.out.println("============================================");
			System.out.println("Enter the choice: ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				if (UserDAOImpl.getUsrList() != null) {
					for (Customer usr : UserDAOImpl.getUsrList()) {
						System.out.println(usr.toString());
						System.out.println();

					}
				} else {
					System.out.println("No Users Registered!");
					System.out.println();

				}
				break;
			case 2:
				for (Category category : AdminInsuranceDAOImpl.getCategories()) {
					System.out.println(category.toString());
					System.out.println();
				}
				break;
			case 3:
				for (SubCategory subCat : AdminInsuranceDAOImpl.getSubCategories()) {
					System.out.println(subCat.toString());
					System.out.println();

				}
				break;
			case 4:
				for (Policy pol : AdminInsuranceDAOImpl.getPolList()) {
					System.out.println(pol.toString());
					System.out.println();

				}
				break;
			case 5:
				adminDAO.addCategory();
				break;
			case 6:
				System.out.println("Enter Category ID to update: ");
				int catId = sc.nextInt();
				adminDAO.updateCategory(catId);
				break;
			case 7:
				System.out.println("Enter Category ID to delete: ");
				int delCatId = sc.nextInt();
				adminDAO.removeCategory(delCatId);
				break;
			case 8:
				adminDAO.addSubCategory();
				break;
			case 9:
				System.out.println("Enter Subcategory ID to update: ");
				int subCatId = sc.nextInt();
				adminDAO.updateSubCategory(subCatId);
				break;
			case 10:
				System.out.println("Enter Subcategory ID to delete: ");
				int delSubCatId = sc.nextInt();
				adminDAO.removeSubCategory(delSubCatId);
				break;
			case 11:
				adminDAO.addPolicy();
				break;
			case 12:
				System.out.println("Enter Policy ID to update: ");
				int policyId = sc.nextInt();
				adminDAO.updatePolicy(policyId);
				break;
			case 13:
				System.out.println("Enter Policy ID to delete: ");
				int delPolicyId = sc.nextInt();
				adminDAO.deletePolicy(delPolicyId);
				break;
			case 14:
				adminDAO.managePolicyRequest();
				break;
			case 15:
				return;
			default:
				System.out.println("Invalid choice! Please choose a valid option.");
			} // end of switch
		} // end of while
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
