package com.dottydingo.hyperion.northwind.api;

import com.dottydingo.hyperion.api.BaseAuditableApiObject;
import com.dottydingo.hyperion.api.Endpoint;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 */
@JsonPropertyOrder({"id","territoryName","regionId","created","createdBy","modified","modifiedBy"})
@Endpoint("Territory")
public class Territory extends BaseAuditableApiObject<Long>
{
    private String territoryName;
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
