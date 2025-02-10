package com.ims.dao;

import com.ims.model.Customer;

public interface UserDAO {
	void registerAdmin();
	void registerCustomer();
	boolean verifyUnameAndPwd(String username, String pass);
	String forgotPassword(String email, String role);
	Customer getCustomer(String uname, String pass);
	
}
