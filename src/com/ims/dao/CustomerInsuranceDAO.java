package com.ims.dao;

import com.ims.model.Customer;

public interface CustomerInsuranceDAO {
    void viewMyPolicies(Customer usr);
    void applyForPolicy(Customer usr);
}
