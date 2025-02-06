package com.ims.model;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private int categoryID;
    private List<SubCategory> subCategories;

    public Category(String name, int categoryID) {
        this.name = name;
        this.categoryID = categoryID;
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
