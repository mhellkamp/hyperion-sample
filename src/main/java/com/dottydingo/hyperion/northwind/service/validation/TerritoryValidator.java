package com.dottydingo.hyperion.northwind.service.validation;

import com.dottydingo.hyperion.core.persistence.PersistenceContext;
import com.dottydingo.hyperion.core.validation.DefaultValidator;
import com.dottydingo.hyperion.core.validation.ValidationErrorContext;
import com.dottydingo.hyperion.northwind.api.Territory;
import com.dottydingo.hyperion.northwind.service.model.PersistentTerritory;
import com.dottydingo.hyperion.northwind.service.persistence.RegionLoader;
import org.springframework.beans.factory.annotation.Autowired;

/**
 */
public class TerritoryValidator extends DefaultValidator<Territory,PersistentTerritory>
{
    private static final String VALIDATION_NOT_FOUND = "VALIDATION_NOT_FOUND";
    @Autowired
    private RegionLoader regionLoader;

    @Override
    protected void validateCreate(Territory clientObject, ValidationErrorContext errorContext, PersistenceContext persistenceContext)
    {
        super.validateCreate(clientObject, errorContext, persistenceContext);

        validateRequired(errorContext,"territoryName",clientObject.getTerritoryName());
        validateLength(errorContext,"territoryName",clientObject.getTerritoryName(),64);

        validateRequired(errorContext,"regionId",clientObject.getRegionId());
        if(clientObject.getRegionId() != null && !regionLoader.exists(clientObject.getRegionId()))
            errorContext.addValidationError(VALIDATION_NOT_FOUND,"regionId","Region",clientObject.getRegionId());

    }
}
