package com.dottydingo.hyperion.northwind.service.translator;

import com.dottydingo.hyperion.api.ApiObject;
import com.dottydingo.hyperion.api.exception.ValidationException;
import com.dottydingo.hyperion.northwind.service.model.PersistentCustomer;
import com.dottydingo.hyperion.northwind.service.model.PersistentRegion;
import com.dottydingo.hyperion.core.persistence.PersistenceContext;
import com.dottydingo.hyperion.core.persistence.dao.Dao;
import com.dottydingo.hyperion.core.translation.FieldMapper;
import com.dottydingo.hyperion.core.translation.ObjectWrapper;

/**
 */
public class RegionIdFieldMapper implements FieldMapper<ApiObject,PersistentCustomer>
{
    private Dao<PersistentRegion,Long,?,?> regionDao;

    public void setRegionDao(Dao<PersistentRegion, Long,?,?> regionDao)
    {
        this.regionDao = regionDao;
    }

    @Override
    public String getClientFieldName()
    {
        return "regionId";
    }

    @Override
    public void convertToClient(ObjectWrapper<PersistentCustomer> persistentObjectWrapper, ObjectWrapper<ApiObject> clientObjectWrapper, PersistenceContext context)
    {
        PersistentCustomer persistentCustomer = persistentObjectWrapper.getWrappedObject();

        clientObjectWrapper.setValue("regionId",persistentCustomer.getRegion().getId());
    }

    @Override
    public boolean convertToPersistent(ObjectWrapper<ApiObject> clientObjectWrapper, ObjectWrapper<PersistentCustomer> persistentObjectWrapper, PersistenceContext context)
    {
        boolean dirty = false;
        Long regionId = (Long) clientObjectWrapper.getValue("regionId");
        PersistentCustomer persistentCustomer = persistentObjectWrapper.getWrappedObject();

        if(regionId != null)
        {
            PersistentRegion region = regionDao.find(PersistentRegion.class,regionId);
            if(region == null)
                throw new ValidationException(String.format("Could not find Region for id=%d",regionId));

            if(persistentCustomer.getRegion()== null || !region.getId().equals(persistentCustomer.getRegion().getId()))
                dirty = true;
            persistentCustomer.setRegion(region);

        }
        return dirty;
    }
}
