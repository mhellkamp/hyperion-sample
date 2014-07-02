package com.dottydingo.hyperion.northwind.validation;

import com.dottydingo.hyperion.northwind.api.Category;
import com.dottydingo.hyperion.northwind.service.model.PersistentCategory;
import com.dottydingo.hyperion.core.persistence.PersistenceContext;
import com.dottydingo.hyperion.core.validation.DefaultValidator;
import com.dottydingo.hyperion.core.validation.ValidationErrorContext;

/**
 */
public class CategoryValidator extends DefaultValidator<Category,PersistentCategory>
{
    @Override
    protected void validateCreate(Category clientObject, ValidationErrorContext errorContext, PersistenceContext persistenceContext)
    {
        super.validateCreate(clientObject, errorContext, persistenceContext);

        validateRequired(errorContext,"categoryName",clientObject.getCategoryName());
        validateLength(errorContext,"categoryName",clientObject.getCategoryName(),255);

        validateRequired(errorContext,"imageUrl",clientObject.getImageUrl());
        validateLength(errorContext,"imageUrl",clientObject.getCategoryName(),1024);

        if("error".equals(clientObject.getCategoryName()))
            errorContext.addValidationError("TEST_ERROR","categoryName");
    }
}
