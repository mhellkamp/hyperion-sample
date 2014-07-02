package com.dottydingo.hyperion.northwind.service.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 */
@Entity
@Table(name = "customer_type")
@DynamicUpdate
@AttributeOverrides(
        {@AttributeOverride(name = "id",column = @Column(name = "customer_type_id"))}
)
public class PersistentCustomerType extends BaseNorthwindPersistentObject
{
    private String description;

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
