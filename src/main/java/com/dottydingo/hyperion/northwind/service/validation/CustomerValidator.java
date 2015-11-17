package com.dottydingo.hyperion.northwind.service.validation;

import com.dottydingo.hyperion.core.persistence.PersistenceContext;
import com.dottydingo.hyperion.core.validation.DefaultValidator;
import com.dottydingo.hyperion.core.validation.ValidationErrorContext;
import com.dottydingo.hyperion.northwind.api.Customer;
import com.dottydingo.hyperion.northwind.service.model.PersistentCustomer;
import com.dottydingo.hyperion.northwind.service.persistence.RegionLoader;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 */
public class CustomerValidator extends DefaultValidator<Customer,PersistentCustomer>
{
    private static final String VALIDATION_NOT_FOUND = "VALIDATION_NOT_FOUND";
    @Autowired
    private RegionLoader regionLoader;

    @Override
    protected void validateCreate(Customer clientObject, ValidationErrorContext errorContext, PersistenceContext persistenceContext)
    {
        super.validateCreate(clientObject, errorContext, persistenceContext);
        validateRequired(errorContext,"regionId",clientObject.getRegionId());
    }

    @Override
    protected void validateCreateConflict(Customer clientObject, ValidationErrorContext errorContext, PersistenceContext persistenceContext)
    {
        if(clientObject.getRegionId() != null && !regionLoader.exists(clientObject.getRegionId()))
            errorContext.addValidationError(VALIDATION_NOT_FOUND,"regionId","Region",clientObject.getRegionId());
    }

    @Override
    protected void validateUpdateConflict(Customer clientObject, PersistentCustomer persistentObject, ValidationErrorContext errorContext, PersistenceContext persistenceContext)
    {
        if(valueChanged(clientObject.getRegionId(),persistentObject.getRegionId()) && !regionLoader.exists(clientObject.getRegionId()))
            errorContext.addValidationError(VALIDATION_NOT_FOUND,"regionId","Region",clientObject.getRegionId());
    }
}
