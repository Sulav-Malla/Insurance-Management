package com.ims.model;

import java.util.ArrayList;
import java.util.List;

public class Category {
	private static int categoryIDCounter = 1;
	private String name;
	private int categoryID;
	private List<SubCategory> subCategories;

	public Category(String name) {
		this.name = name;
		this.categoryID = categoryIDCounter++;
		this.subCategories = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCategoryID() {
		return categoryID;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Subcategories Available: [ ");
		int index = subCategories.size();
		for (int i = 0; i < index; i++) {
			if (i < index - 1) {
				String name = subCategories.get(i).getName();
				sb.append(name + ", ");
			} else { // to avoid extra comma
				String name = subCategories.get(i).getName();
				sb.append(name);
			}

		}
		sb.append(" ]");
		return "Category ID: " + categoryID + "\n" + "Category Name: " + name + "\n" + sb;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public List<SubCategory> getSubCategories() {
		return subCategories;
	}

	public void addSubCategory(SubCategory subCategory) {
		this.subCategories.add(subCategory);
	}

	public void removeSubCategory(SubCategory subCategory) {
		this.subCategories.remove(subCategory);
	}
}
