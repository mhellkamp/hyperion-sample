package com.dottydingo.hyperion.northwind.service.translator;

import com.dottydingo.hyperion.core.translation.DefaultAuditingTranslator;
import com.dottydingo.hyperion.northwind.api.Region;
import com.dottydingo.hyperion.northwind.service.model.PersistentRegion;

/**
 */
public class RegionTranslator extends DefaultAuditingTranslator<Region,PersistentRegion>
{

    public RegionTranslator()
    {
        super(Region.class, PersistentRegion.class);
    }

}
