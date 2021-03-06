package com.dottydingo.hyperion.northwind.service.model;


import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 */
@Entity
@Table(name = "regions")
@DynamicUpdate
@AttributeOverrides(
        {@AttributeOverride(name = "id",column = @Column(name = "region_id"))}
)
public class PersistentRegion extends BaseNorthwindPersistentObject
{
    @Column(name = "region_name", unique = true,length = 15)
    private String regionName;


    public String getRegionName()
    {
        return regionName;
    }

    public void setRegionName(String regionName)
    {
        this.regionName = regionName;
    }
}
