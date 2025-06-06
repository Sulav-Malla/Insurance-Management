package com.ims.client;

import java.util.Scanner;

import com.ims.dao.impl.UserDAOImpl;
import com.ims.details.UserMenu;
import com.ims.model.Customer;

public class LoginClient {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		UserDAOImpl daoImpl = new UserDAOImpl();

		while (true) {
			System.out.println("============================================");
			System.out.println("               1) Login              ");
			System.out.println("               2) Register                     ");
			System.out.println("               3) ForgotPassword              ");
			System.out.println("               4) Exit              ");
			System.out.println("============================================");

			System.out.println("Enter the choice");
			int choice = sc.nextInt();

			switch (choice) {

			case 1:
				int loginChoice = 0;

				while (true) {
					System.out.println("Choose login type:");
					System.out.println("1. Admin");
					System.out.println("2. Customer");
					System.out.println("3. Back");

					if (sc.hasNextInt()) {
						loginChoice = sc.nextInt();

						if (loginChoice == 1) { // Admin login process

							System.out.println("Enter Admin Username:");
							String adminName = sc.next();
							System.out.println("Enter Admin Password:");
							String adminPass = sc.next();

							if (adminName.equals("superadmin") && adminPass.equals("pass")) {
								System.out.println("Valid Admin!");
								UserMenu.adminMenu();
							} else {
								boolean isAdmin = daoImpl.verifyUnameAndPwd(adminName, adminPass);
								if (isAdmin) {
									System.out.println("Valid Admin!");
									UserMenu.adminMenu();
								} else {
									System.out.println("Invalid Admin credentials!");
								}
							}
							break;
						} // end of Admin if

						else if (loginChoice == 2) { // customer login

							System.out.println("Enter Customer Username:");
							String custName = sc.next();
							System.out.println("Enter Customer Password:");
							String custPass = sc.next();

							Customer customerUsr = daoImpl.getCustomer(custName, custPass);
							if (customerUsr != null) {
								System.out.println("Valid Customer!");
								UserMenu.userMenu(customerUsr);
							} else {
								System.out.println("Make sure you entered your credentials correctly!");
							}
							break;
						} // end of customer if

						else if (loginChoice == 3) {
							// Go back to the previous menu
							System.out.println("Going back to the main menu...");
							break;
						} else {
							System.out.println(
									"Invalid choice! Please choose 1 for Admin, 2 for Customer, or 3 to go back.");
						}
					} // end of if(hasNextInt)

					else {
						System.out.println("Invalid input! Please enter a number (1, 2, or 3).");
						sc.next();
					}
				} // end of while
				break;

			case 2:
				while (true) {
					System.out.println("Register as 1) Admin 2) Customer 3) Exit (Choose 1-3)");
					if (sc.hasNextInt()) {
						int regChoice = sc.nextInt();
						if (regChoice == 1) {
							System.out.println("Enter access code: ");
							int usrCode = sc.nextInt();
							int accessCode = 1234;
							if (usrCode == accessCode) {
								daoImpl.registerAdmin();
								break;
							} else {
								System.out.println("Invalid access code. Please try again.");
							}
						} else if (regChoice == 2) {
							daoImpl.registerCustomer();
							break;
						} else if (regChoice == 3) {
							System.out.println("Exiting registration...");
							break;
						} else {
							System.out.println("Invalid choice! Please choose between 1, 2, or 3.");
						}
					} // end of if(hasNextInt)
					else {
						System.out.println("Invalid input! Please enter a number (1, 2, or 3).");
						sc.next();
					}
				}
				break;

			case 3:
				while (true) {
					System.out.println("1) Admin  2) Customer 3) Back");
					int forgotChoice = sc.nextInt();
					System.out.println("enter Email");
					String email = sc.next();
					if (forgotChoice == 1) {
						String password = daoImpl.forgotPassword(email, "admin");
						if (!password.isEmpty()) {
							System.out.println("Your Password : " + password);
						} else {
							System.out.println("Email does not Exist");
						}
						break;
					} else if (forgotChoice == 2) {
						String password = daoImpl.forgotPassword(email, "customer");
						if (!password.isEmpty()) {
							System.out.println("Your Password : " + password);
						} else {
							System.out.println("Email does not Exist");
						}
						break;
					} else if (forgotChoice == 3) {
						System.out.println("Exiting registration...");
						break;
					} else {
						System.out.println("Invalid choice! Please choose between 1, 2, or 3.");
					}
				}
				break;
			case 4:
				System.out.println("Thanks for using the App!");
				System.exit(0);
				sc.close();

			default:
				System.out.println("Choose between 1 and 4!");

			}// end choice

		} // end of while

	}
}
