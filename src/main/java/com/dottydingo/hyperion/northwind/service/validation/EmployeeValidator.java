package com.dottydingo.hyperion.northwind.service.validation;

import com.dottydingo.hyperion.core.persistence.PersistenceContext;
import com.dottydingo.hyperion.core.validation.DefaultValidator;
import com.dottydingo.hyperion.core.validation.ValidationErrorContext;
import com.dottydingo.hyperion.northwind.api.Employee;
import com.dottydingo.hyperion.northwind.service.model.PersistentEmployee;
import com.dottydingo.hyperion.northwind.service.persistence.TerritoryLoader;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 */
public class EmployeeValidator extends DefaultValidator<Employee,PersistentEmployee>
{

    private static final String VALIDATION_NOT_FOUND_IDS = "VALIDATION_NOT_FOUND_IDS";
    @Autowired
    private TerritoryLoader territoryLoader;

    @Override
    protected void validateCreate(Employee clientObject, ValidationErrorContext errorContext, PersistenceContext persistenceContext)
    {
        super.validateCreate(clientObject, errorContext, persistenceContext);

        validateRequired(errorContext,"firstName",clientObject.getFirstName());
        validateLength(errorContext,"firstName",clientObject.getFirstName(),64);

        if(clientObject.getTerritoryIds() != null && clientObject.getTerritoryIds().size() > 0)
        {
            Set<Long> unique = new HashSet<>(clientObject.getTerritoryIds());
            List<Long> found = territoryLoader.exists(unique);
            if(unique.size() != found.size())
            {
                unique.removeAll(found);
                errorContext.addValidationError(VALIDATION_NOT_FOUND_IDS,"territoryIds","Territory", StringUtils.join(unique,","));
            }
        }

    }
}
