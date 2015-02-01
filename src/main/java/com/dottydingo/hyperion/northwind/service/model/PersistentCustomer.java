package com.dottydingo.hyperion.northwind.service.model;

import com.dottydingo.hyperion.northwind.api.CustomerCreditRatingType;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 */
@Entity
@Table(name = "customers")
@DynamicUpdate
@AttributeOverrides(
        {@AttributeOverride(name = "id",column = @Column(name = "customer_id"))}
)
public class PersistentCustomer extends BaseNorthwindPersistentObject
{
    @Column(name = "company_name", length = 40)
    private String companyName;

    @Column(name = "contact_name", length = 30)
    private String contactName;

    @Column(name = "contact_title", length = 30)
    private String contactTitle;

    @Column(name = "address", length = 60)
    private String address;

    @Column(name = "city", length = 30)
    private String city;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "region_id")
    private PersistentRegion region;

    @Column(name = "postal_code", length = 10)
    private String postalCode;

    @Column(name = "country", length = 15)
    private String country;

    @Column(name = "phone", length = 24)
    private String phone;

    @Column(name = "fax", length = 24)
    private String fax;

    @Column(name = "credit_rating", length = 50)
    @Enumerated(EnumType.STRING)
    private CustomerCreditRatingType creditRating = CustomerCreditRatingType.NONE;

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

    public PersistentRegion getRegion()
    {
        return region;
    }

    public void setRegion(PersistentRegion region)
    {
        this.region = region;
    }

    public String getPostalCode()
    {
        return postalCode;
    }

    public void setPostalCode(String postalCode)
    {
        this.postalCode = postalCode;
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

    public CustomerCreditRatingType getCreditRating()
    {
        return creditRating;
    }

    public void setCreditRating(CustomerCreditRatingType creditRating)
    {
        this.creditRating = creditRating;
    }
}
