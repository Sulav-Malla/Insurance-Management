package com.ims.dao.impl;

import java.util.Scanner;

import com.ims.dao.UserDAO;
import com.ims.model.User;

public class UserDAOImpl implements UserDAO {
	Scanner sc = new Scanner(System.in);

	User usr = null;

	@Override
	public void addRegister() {
		System.out.println("Enter User Id:");
		int id = sc.nextInt();
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
		usr = new User(id, fname, lname, email, uname, pass);
		System.out.println("Registration Successful");

	}

	@Override
	public boolean verifyUnameAndPwd(String email, String pass) {
		if (usr != null) {

			if (usr.getEmail().equals(email) && usr.getPassWord().equals(pass)) {
				return true;

			}
		}
		return false;
	}

	@Override
	public String forgotPassword(String email) {
		if (usr != null) {
			if (usr.getEmail().equals(email)) {
				return usr.getPassWord();
			}
		}
		return null;
	}

}
