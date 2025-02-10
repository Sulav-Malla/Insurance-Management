package com.ims.dao.impl;

import java.util.List;
import java.util.Scanner;

import com.ims.dao.CustomerInsuranceDAO;
import com.ims.model.Category;
import com.ims.model.Customer;
import com.ims.model.Policy;
import com.ims.model.SubCategory;

public class CustomerInsuranceDAOImpl implements CustomerInsuranceDAO {
	Scanner sc = new Scanner(System.in);
	List<Category> categories = AdminInsuranceDAOImpl.getCategories();
	List<SubCategory> subCategories = AdminInsuranceDAOImpl.getSubCategories();
	List<Policy> polList = AdminInsuranceDAOImpl.getPolList();

	// displays all active and applied to policies per user
	@Override
	public void viewMyPolicies(Customer usr) {
		if (!usr.getMyPolicies().isEmpty()) {
			System.out.println("Your active policies:");
			System.out.println();

			for (Policy pol : usr.getMyPolicies()) {
				System.out.println(pol.toString());
			}
			System.out.println();
		} else {
			System.out.println("No Active Policies!");
		}
		if (!usr.getAppliedPolicies().isEmpty()) {
			System.out.println("Your pending policies:");
			System.out.println();

			for (Policy pol : usr.getAppliedPolicies()) {
				System.out.println(pol.toString());
			}
		} else {
			System.out.println("You haven't applied to anything!");

		}
	}

	// allows applying to policy
	@Override
	public void applyForPolicy(Customer usr) {

		System.out.println("Type the category you would like to apply to: ");
		Category category = findCategory(sc.nextLine());
		if (category != null) {
			System.out.println("Type the sub category you would like to apply to: ");
			SubCategory subCat = findSubCategory(sc.nextLine());
			if (subCat != null) {
				System.out.println("Type the policy you would like to apply to: ");
				Policy policy = findPolicy(sc.nextLine());
				if (policy != null) {
					usr.addApplyPolicy(policy);
				}
			}
		}

	}
	
	// helper functions to make sure user applies to stuff that exists

	// find policy
	private Policy findPolicy(String name) {

		for (Policy pol : polList) {
			if (pol.getPolicyName().equals(name)) {
				return pol;
			}
		}
		return null;
	}

	// finds sub category
	private SubCategory findSubCategory(String name) {
		for (SubCategory subCat : subCategories) {
			if (subCat.getName().equals(name)) {
				return subCat;
			}
		}
		return null;
	}

	// finds category
	private Category findCategory(String name) {
		for (Category category : categories) {
			if (category.getName().equals(name)) {
				return category;
			}
		}
		return null;
	}

}
