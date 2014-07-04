package com.dottydingo.hyperion.northwind.api;

import com.dottydingo.hyperion.api.BaseAuditableApiObject;
import com.dottydingo.hyperion.api.Endpoint;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

/**
 */
@JsonPropertyOrder({"id","regionName","created","createdBy","modified","modifiedBy"})
@Endpoint("Region")
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
