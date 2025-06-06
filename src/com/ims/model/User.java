package com.ims.model;

public class User {
	private static int idCounter = 1;
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String userName;
	private String passWord;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public User() {
		super();
	}

	public User(String firstName, String lastName, String email, String userName, String passWord) {
		super();
		this.id = idCounter++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		return "User ID: " + id + "\n" + "First Name: " + firstName + "\n" + "Last Name: " + lastName + "\n" + "\n"
				+ "Email: " + email + "\n" + "User Name: " + userName + "\n";
	}

}
