package com.dottydingo.hyperion.northwind.validation;

import com.dottydingo.hyperion.exception.HyperionException;
import com.dottydingo.hyperion.northwind.api.Category;
import com.dottydingo.hyperion.northwind.service.model.PersistentCategory;
import com.dottydingo.hyperion.service.persistence.PersistenceContext;
import com.dottydingo.hyperion.service.validation.DefaultValidator;
import com.dottydingo.hyperion.service.validation.ValidationErrorContext;

/**
 */
public class CategoryValidator extends DefaultValidator<Category,PersistentCategory>
{
    @Override
    protected void validateCreate(Category clientObject, ValidationErrorContext errorContext, PersistenceContext persistenceContext)
    {
        super.validateCreate(clientObject, errorContext, persistenceContext);
        if("error".equals(clientObject.getCategoryName()))
            throw new HyperionException(401,"Nope");
    }
}
