package com.dottydingo.hyperion.northwind.service.translator;

import com.dottydingo.hyperion.core.translation.DefaultAuditingTranslator;
import com.dottydingo.hyperion.core.translation.FieldMapper;
import com.dottydingo.hyperion.northwind.api.Customer;
import com.dottydingo.hyperion.northwind.service.model.PersistentCustomer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class CustomerTranslator extends DefaultAuditingTranslator<Customer,PersistentCustomer>
{
    @Autowired
    private RegionIdFieldMapper regionIdFieldMapper;

    public CustomerTranslator()
    {
        super(Customer.class, PersistentCustomer.class);
    }

    @Override
    protected List<FieldMapper> getCustomFieldMappers()
    {
        List<FieldMapper> fieldMappers = new ArrayList<>();
        fieldMappers.addAll(super.getCustomFieldMappers());
        fieldMappers.add(regionIdFieldMapper);
        return fieldMappers;
    }
}
