package com.dottydingo.hyperion.northwind.service.translator;

import com.dottydingo.hyperion.core.translation.DefaultAuditingTranslator;
import com.dottydingo.hyperion.northwind.api.Territory;
import com.dottydingo.hyperion.northwind.service.model.PersistentTerritory;

/**
 */
public class TerritoryTranslator extends DefaultAuditingTranslator<Territory,PersistentTerritory>
{

    public TerritoryTranslator()
    {
        super(Territory.class, PersistentTerritory.class);
    }

}
