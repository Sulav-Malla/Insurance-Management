package com.ims.dao;

public interface UserDAO {
	void addRegister();
	boolean verifyUnameAndPwd(String email, String pass);
	String forgotPassword(String email);
}
