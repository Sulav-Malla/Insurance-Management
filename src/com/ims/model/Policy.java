package com.ims.model;

public class Policy {
	private static int policyIDCounter = 1;
    private int policyId;
    private String policyName;
    private Category category;
    private SubCategory subCategory;
    private String description;
    private double premiumAmount;
    private double coverageAmount;
    private int policyTerm;
    private String status;

    public Policy( String policyName, Category category, SubCategory subCategory,
                  String description, double premiumAmount, double coverageAmount, 
                  int policyTerm, String status) {
        this.policyId = policyIDCounter++;
        this.policyName = policyName;
        this.category = category;
        this.subCategory = subCategory;
        this.description = description;
        this.premiumAmount = premiumAmount;
        this.coverageAmount = coverageAmount;
        this.policyTerm = policyTerm;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Policy ID: " + policyId + "\n" +
               "Policy Name: " + policyName + "\n" +
               "Category: " + category.getName() + "\n" +
               "SubCategory: " + subCategory.getName() + "\n" +
               "Description: " + description + "\n" +
               "Premium Amount: " + premiumAmount + "\n" +
               "Coverage Amount: " + coverageAmount + "\n" +
               "Policy Term: " + policyTerm + "\n" +
               "Status: " + status;
    }

    public int getPolicyId() {
        return policyId;
    }

    public void setPolicyId(int policyId) {
        this.policyId = policyId;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(double premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    public double getCoverageAmount() {
        return coverageAmount;
    }

    public void setCoverageAmount(double coverageAmount) {
        this.coverageAmount = coverageAmount;
    }

    public int getPolicyTerm() {
        return policyTerm;
    }

    public void setPolicyTerm(int policyTerm) {
        this.policyTerm = policyTerm;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
