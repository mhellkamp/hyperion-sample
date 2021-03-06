package com.dottydingo.hyperion.northwind.service.model;



import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.IndexColumn;

import javax.persistence.*;
import java.util.List;

/**
 */
@Entity
@Table(name = "categories")
@DynamicUpdate
@AttributeOverrides(
        {@AttributeOverride(name = "id",column = @Column(name = "category_id"))}
)
public class PersistentCategory extends BaseNorthwindPersistentObject
{
    @Column(name = "category_name", unique = true,length = 15)
    private String categoryName;

    @Column(name = "description")
    @Lob
    private String description;

    @Column(name = "image_url", length = 1024)
    private String imageUrl;

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

}
