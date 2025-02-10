package com.ims.dao;

import com.ims.model.Category;
import com.ims.model.Policy;
import com.ims.model.SubCategory;
import java.util.List;

public interface InsuranceViewDAO {
    Policy getPolicyById(int policyId);
    List<Policy> getAllPolicies();
    Category getCategoryById(int categoryId);
    List<Category> getAllCategories();
    SubCategory getSubCategoryById(int subCategoryId);
    List<SubCategory> getAllSubCategories();
}
