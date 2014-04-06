package com.dottydingo.hyperion.northwind.api;

import com.dottydingo.hyperion.api.BaseAuditableApiObject;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 */
@JsonPropertyOrder({"id","regionName","created","createdBy","modified","modifiedBy"})
public class Region extends BaseAuditableApiObject<Long>
{
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
