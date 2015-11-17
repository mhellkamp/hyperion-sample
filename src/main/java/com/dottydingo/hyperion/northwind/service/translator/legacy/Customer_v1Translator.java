package com.dottydingo.hyperion.northwind.service.translator.legacy;

import com.dottydingo.hyperion.core.translation.DefaultAuditingTranslator;
import com.dottydingo.hyperion.core.translation.DefaultFieldMapper;
import com.dottydingo.hyperion.core.translation.FieldMapper;
import com.dottydingo.hyperion.northwind.api.legacy.Customer_v1;
import com.dottydingo.hyperion.northwind.service.model.PersistentCustomer;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class Customer_v1Translator extends DefaultAuditingTranslator<Customer_v1,PersistentCustomer>
{

    public Customer_v1Translator()
    {
        super(Customer_v1.class, PersistentCustomer.class);
    }

    @Override
    protected List<FieldMapper> getCustomFieldMappers()
    {
        List<FieldMapper> fieldMappers = new ArrayList<>();
        fieldMappers.addAll(super.getCustomFieldMappers());
        fieldMappers.add(new DefaultFieldMapper("zipCode","postalCode",null));
        return fieldMappers;
    }
}
