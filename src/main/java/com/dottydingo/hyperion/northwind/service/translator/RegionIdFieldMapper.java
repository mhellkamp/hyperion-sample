package com.dottydingo.hyperion.northwind.service.translator;

import com.dottydingo.hyperion.exception.ValidationException;
import com.dottydingo.hyperion.northwind.api.Customer;
import com.dottydingo.hyperion.northwind.service.model.PersistentCustomer;
import com.dottydingo.hyperion.northwind.service.model.PersistentRegion;
import com.dottydingo.hyperion.service.context.RequestContext;
import com.dottydingo.hyperion.service.persistence.dao.Dao;
import com.dottydingo.hyperion.service.translation.FieldMapper;
import com.dottydingo.hyperion.service.translation.ObjectWrapper;

/**
 */
public class RegionIdFieldMapper implements FieldMapper<Customer,PersistentCustomer>
{
    private Dao<PersistentRegion,Long> regionDao;

    public void setRegionDao(Dao<PersistentRegion, Long> regionDao)
    {
        this.regionDao = regionDao;
    }

    @Override
    public String getClientFieldName()
    {
        return "regionId";
    }

    @Override
    public void convertToClient(ObjectWrapper<PersistentCustomer> persistentObjectWrapper, ObjectWrapper<Customer> clientObjectWrapper, RequestContext context)
    {
        Customer customer = clientObjectWrapper.getWrappedObject();
        PersistentCustomer persistentCustomer = persistentObjectWrapper.getWrappedObject();

        customer.setRegionId(persistentCustomer.getRegion().getId());
    }

    @Override
    public void convertToPersistent(ObjectWrapper<Customer> clientObjectWrapper, ObjectWrapper<PersistentCustomer> persistentObjectWrapper, RequestContext context)
    {
        Customer customer = clientObjectWrapper.getWrappedObject();
        PersistentCustomer persistentCustomer = persistentObjectWrapper.getWrappedObject();

        if(customer.getRegionId() != null)
        {
            PersistentRegion region = regionDao.find(PersistentRegion.class,customer.getRegionId());
            if(region == null)
                throw new ValidationException(String.format("Could not find Region for id=%d",customer.getRegionId()));

            persistentCustomer.setRegion(region);
        }
    }
}
