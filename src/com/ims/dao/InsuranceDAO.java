package com.ims.dao;

import java.util.List;

import com.ims.model.Category;
import com.ims.model.Policy;
import com.ims.model.SubCategory;

public interface InsuranceDAO {
	void addPolicy();

	Policy getPolicyById(int policyId);

	List<Policy> getAllPolicies();

	void updatePolicy(Policy policy);

	void deletePolicy(int policyId);

	void addCategory(Category category);

	void removeCategory(int categoryId);

	void addSubCategory(SubCategory subCategory, int categoryId);

	void removeSubCategory(int subCategoryId, int categoryId);
}
