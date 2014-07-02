package com.dottydingo.hyperion.northwind.api.legacy;

import com.dottydingo.hyperion.api.BaseAuditableApiObject;
import com.dottydingo.hyperion.api.Endpoint;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 */
@JsonPropertyOrder({"id","companyName","contactName","contactTitle","address","city","regionId","zipCode","country",
        "phone","fax","created","createdBy","modified","modifiedBy"})
@Endpoint(value = "Customer",version = 1)
public class Customer_v1 extends BaseAuditableApiObject<Long>
{
    private String companyName;
    private String contactName;
    private String contactTitle;
    private String address;
    private String city;
    private Long regionId;
    private String zipCode;
    private String country;
    private String phone;
    private String fax;

    public String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public String getContactName()
    {
        return contactName;
    }

    public void setContactName(String contactName)
    {
        this.contactName = contactName;
    }

    public String getContactTitle()
    {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle)
    {
        this.contactTitle = contactTitle;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public Long getRegionId()
    {
        return regionId;
    }

    public void setRegionId(Long regionId)
    {
        this.regionId = regionId;
    }

    public String getZipCode()
    {
        return zipCode;
    }

    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getFax()
    {
        return fax;
    }

    public void setFax(String fax)
    {
        this.fax = fax;
    }
}
