package com.dottydingo.hyperion.northwind.service.persistence;

import com.dottydingo.hyperion.northwind.service.model.PersistentRegion;
import org.springframework.stereotype.Component;

/**
 */
@Component
public class RegionLoader extends AbstractLoader<PersistentRegion,Long>
{
    @Override
    protected Class<PersistentRegion> getEntityClass()
    {
        return PersistentRegion.class;
    }

    @Override
    protected Class<Long> getIdClass()
    {
        return Long.class;
    }
}
