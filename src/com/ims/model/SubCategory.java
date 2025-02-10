package com.ims.model;

import java.util.ArrayList;
import java.util.List;

public class SubCategory {
	private static int subIDCounter = 1;
	private String name;
	private int subID;
	private List<Policy> policies;

	public SubCategory(String name) {
		this.name = name;
		this.subID = subIDCounter++;
		this.policies = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Policies Available: [ ");
		int index = policies.size();
		for (int i = 0; i < index; i++) {
			if (i < index - 1) {
				String name = policies.get(i).getPolicyName();
				sb.append(name + ", ");
			} else { // to avoid extra comma
				String name = policies.get(i).getPolicyName();
				sb.append(name);
			}

		}
		sb.append(" ]");
		return "Subcategory ID: " + subID + "\n" + "Subcategory Name: " + name + "\n" + sb;
	}

	public int getSubID() {
		return subID;
	}

	public void setSubID(int subID) {
		this.subID = subID;
	}

	public List<Policy> getPolicies() {
		return policies;
	}

	public void addPolicy(Policy policy) {
		this.policies.add(policy);
	}

	public void removePolicy(Policy policy) {
		this.policies.remove(policy);
	}
}
