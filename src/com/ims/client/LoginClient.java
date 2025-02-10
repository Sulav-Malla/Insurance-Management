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
			System.out.println("               1) Login             ");
			System.out.println("               2) Register                     ");
			System.out.println("               3) ForgotPassword              ");
			System.out.println("               4) Exit              ");
			System.out.println("============================================");

			System.out.println("Enter the choice");
			int choice = sc.nextInt();

			switch (choice) {

			case 1:
				System.out.println("enter User Name");
				String uname = sc.next();
				System.out.println("enter Password ");
				String pass = sc.next();
				if (uname.equals("superadmin") && pass.equals("pass")) {
					UserMenu.adminMenu();
				} else {
					boolean isAdmin = daoImpl.verifyUnameAndPwd(uname, pass);
					if (isAdmin) {
						UserMenu.adminMenu();
						System.out.println("Valid Admin!");
					} else {
						Customer customerUsr = daoImpl.getCustomer(uname, pass);
						if (customerUsr != null) {
							System.out.println("Valid Customer!");

							UserMenu.userMenu(customerUsr);

						} else {
							System.out.println("Make sure you entered your credentials correctly!");
						}
					}
				}

				break;
			case 2:
				while (true) {
					System.out.println("Register as 1) Admin 2) Customer 3) Exit (Choose 1-3)");
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
