package com.dottydingo.hyperion.northwind.service.model;


import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 */
@Entity
@Table(name = "territories")
@DynamicUpdate
@AttributeOverrides(
        {@AttributeOverride(name = "id",column = @Column(name = "territory_id"))}
)
public class PersistentTerritory extends BaseNorthwindPersistentObject
{
    @Column(name = "territory_name", unique = true,length = 64)
    private String territoryName;

    @Column(name = "region_id")
    private Long regionId;

    public String getTerritoryName()
    {
        return territoryName;
    }

    public void setTerritoryName(String territoryName)
    {
        this.territoryName = territoryName;
    }

    public Long getRegionId()
    {
        return regionId;
    }

    public void setRegionId(Long regionId)
    {
        this.regionId = regionId;
    }
}
