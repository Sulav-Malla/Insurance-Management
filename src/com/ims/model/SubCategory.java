package com.ims.model;

import java.util.ArrayList;
import java.util.List;

public class SubCategory {
    private String name;
    private int subID;
    private List<Policy> policies;

    public SubCategory(String name, int subID) {
        this.name = name;
        this.subID = subID;
        this.policies = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
