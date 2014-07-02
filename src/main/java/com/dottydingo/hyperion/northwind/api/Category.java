package com.dottydingo.hyperion.northwind.api;

import com.dottydingo.hyperion.api.BaseAuditableApiObject;
import com.dottydingo.hyperion.api.Endpoint;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

/**
 */
@JsonPropertyOrder({"id","categoryName","description","imageUrl","created","createdBy","modified","modifiedBy"})
@Endpoint("Category")
public class Category extends BaseAuditableApiObject<Long>
{
    private String categoryName;
    private String description;
    private String imageUrl;
    private List<String> things;

    public String getCategoryName()
    {
        return categoryName;
    }

    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }

    public List<String> getThings()
    {
        return things;
    }

    public void setThings(List<String> things)
    {
        this.things = things;
    }
}
