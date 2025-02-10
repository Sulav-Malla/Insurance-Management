package com.ims.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ims.dao.UserDAO;
import com.ims.model.Customer;
import com.ims.model.User;

public class UserDAOImpl implements UserDAO {
	Scanner sc = new Scanner(System.in);

	private static List<Customer> usrList = new ArrayList<>();
	private static List<User> adminList = new ArrayList<>();
	public static List<Customer> getUsrList() {
		return usrList;
	}

	public static List<User> getAdminList() {
		return adminList;
	}

	
	@Override
	public void registerAdmin() {
		
		System.out.println("Enter First Name:");
		String fname = sc.next();
		System.out.println("Enter Last Name:");
		String lname = sc.next();
		System.out.println("Enter Email:");
		String email = sc.next();
		System.out.println("Enter User Name:");
		String uname = sc.next();
		System.out.println("Enter Password:");
		String pass = sc.next();
		User usr = new User(fname, lname, email, uname, pass);
		adminList.add(usr);
		System.out.println("Registration Successful");
	}
	
	@Override
	public void registerCustomer() {
		System.out.println("Enter First Name:");
		String fname = sc.next();
		System.out.println("Enter Last Name:");
		String lname = sc.next();
		System.out.println("Enter Email:");
		String email = sc.next();
		System.out.println("Enter User Name:");
		String uname = sc.next();
		System.out.println("Enter Password:");
		String pass = sc.next();
		Customer usr = new Customer(fname, lname, email, uname, pass);
		usrList.add(usr);
		System.out.println("Registration Successful");
		
	}

	@Override
	public boolean verifyUnameAndPwd(String username, String pass) {
		if (!adminList.isEmpty()) {
			for (User u : adminList) {
				if (u.getUserName().equals(username) && u.getPassWord().equals(pass))
					return true;
			}
		} // end of if
		return false;
	}
	

	@Override
	public String forgotPassword(String email, String role) {
		if(role.equals("admin")){ 
			if (!adminList.isEmpty()) {
				for (User u : adminList) {
					if (u.getEmail().equals(email))
						return u.getPassWord();
				}
			} // end of if
			return "";
		}
		else { // for customers
			if (!usrList.isEmpty()) {
				for (Customer u : usrList) {
					if (u.getEmail().equals(email))
						return u.getPassWord();
				}
			} // end of if
			return "";
		}
		
	}

	@Override
	public Customer getCustomer(String uname, String pass) {
		if (!usrList.isEmpty()) {
			for (Customer u : usrList) {
				if (u.getUserName().equals(uname) && u.getPassWord().equals(pass))
					return u;
			}
		} // end of if
		return null;
	}



}
