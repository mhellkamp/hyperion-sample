package com.dottydingo.hyperion.northwind.service.translator;

import com.dottydingo.hyperion.core.translation.DefaultAuditingTranslator;
import com.dottydingo.hyperion.core.translation.DefaultFieldMapper;
import com.dottydingo.hyperion.core.translation.FieldMapper;
import com.dottydingo.hyperion.northwind.api.Employee;
import com.dottydingo.hyperion.northwind.service.model.PersistentEmployee;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class EmployeeTranslator extends DefaultAuditingTranslator<Employee,PersistentEmployee>
{

    public EmployeeTranslator()
    {
        super(Employee.class, PersistentEmployee.class);
    }

    @Override
    protected List<FieldMapper> getCustomFieldMappers()
    {
        ArrayList<FieldMapper> fieldMappers = new ArrayList<>();
        fieldMappers.addAll(fieldMappers);
        fieldMappers.add(new DefaultFieldMapper("territoryIds","territoryIds",new LazyCollectionValueConverter()));
        return fieldMappers;
    }
}
