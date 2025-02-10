package com.ims.dao;


public interface AdminInsuranceDAO {
    void addPolicy();
    void updatePolicy(int policyId);
    void deletePolicy(int policyId);
    void addCategory();
    void removeCategory(int categoryId);
    void updateCategory(int categoryId);
    void addSubCategory();
    void removeSubCategory(int subCategoryId);
    void updateSubCategory(int subCategoryId);
    void managePolicyRequest();
}
