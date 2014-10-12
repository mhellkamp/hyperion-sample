package com.dottydingo.hyperion.northwind.service.persistence;

import com.dottydingo.hyperion.northwind.service.model.PersistentRegion;
import com.dottydingo.hyperion.northwind.service.model.PersistentTerritory;
import org.springframework.stereotype.Component;

/**
 */
@Component
public class TerritoryLoader extends AbstractLoader<PersistentTerritory,Long>
{
    @Override
    protected Class<PersistentTerritory> getEntityClass()
    {
        return PersistentTerritory.class;
    }

    @Override
    protected Class<Long> getIdClass()
    {
        return Long.class;
    }
}
