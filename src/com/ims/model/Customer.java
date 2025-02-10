package com.ims.model;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
	private List<Policy> myPolicies;
	private List<Policy> appliedPolicies;

	public List<Policy> getMyPolicies() {
		return myPolicies;
	}

	public void setMyPolicies(List<Policy> myPolicies) {
		this.myPolicies = myPolicies;
	}

	public List<Policy> getAppliedPolicies() {
		return appliedPolicies;
	}

	public void setAppliedPolicies(List<Policy> appliedPolicies) {
		this.appliedPolicies = appliedPolicies;
	}

	public Customer() {
		super();
		myPolicies = new ArrayList<>();
		appliedPolicies = new ArrayList<>();
	}

	// helps add policy
	public void addApplyPolicy(Policy policy) {

		appliedPolicies.add(policy);
		System.out.println(policy.getPolicyName() + " has been applied to!");

	}

	// remove all rejected policies
	public void removeRejectedPolicy() {
		for (Policy pol : appliedPolicies) {
			if (pol.getStatus().equals("Rejected")) {
				appliedPolicies.remove(pol);
			}
		}
	}

	public Customer(String firstName, String lastName, String email, String userName, String passWord) {
		super(firstName, lastName, email, userName, passWord);
		myPolicies = new ArrayList<>();
		appliedPolicies = new ArrayList<>();

	}

	@Override
	public String toString() {
		return super.toString() + "\nTotal Active Policy: " + myPolicies.size() + "\n" + "Pending Policies: "
				+ appliedPolicies.size();
	}

}
