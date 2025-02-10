package com.ims.dao.impl;

import com.ims.dao.InsuranceViewDAO;
import com.ims.model.Category;
import com.ims.model.Policy;
import com.ims.model.SubCategory;
import java.util.List;

public class InsuranceViewDAOImpl implements InsuranceViewDAO {

    List<Policy> polList = AdminInsuranceDAOImpl.getPolList();
    List<Category> categories = AdminInsuranceDAOImpl.getCategories();
    List<SubCategory> subCategories = AdminInsuranceDAOImpl.getSubCategories();

    // viewer functions for all possible category, sub category and policies
    @Override
    public Policy getPolicyById(int policyId) {
        for (Policy policy : polList) {
            if (policy.getPolicyId() == policyId) {
                return policy;
            }
        }
        return null;
    }

    @Override
    public List<Policy> getAllPolicies() {
        return polList;
    }

    @Override
    public Category getCategoryById(int categoryId) {
        for (Category category : categories) {
            if (category.getCategoryID() == categoryId) {
                return category;
            }
        }
        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public SubCategory getSubCategoryById(int subCategoryId) {
        for (SubCategory subCat : subCategories) {
            if (subCat.getSubID() == subCategoryId) {
                return subCat;
            }
        }
        return null;
    }

    @Override
    public List<SubCategory> getAllSubCategories() {
        return subCategories;
    }
    
   
}
