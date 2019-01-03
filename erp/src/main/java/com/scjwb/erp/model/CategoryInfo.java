package com.scjwb.erp.model;

import java.util.List;

public class CategoryInfo {
    private Integer id;

    private String categoryName;

    private String parentId;

    private List<CategoryInfo> children;

    public List<CategoryInfo> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryInfo> children) {
        this.children = children;
    }

    public CategoryInfo(Integer id, String categoryName, String parentId) {
        this.id = id;
        this.categoryName = categoryName;
        this.parentId = parentId;
    }

    public CategoryInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }
}