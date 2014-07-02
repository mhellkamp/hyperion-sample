package com.dottydingo.hyperion.northwind.service.translator;

import com.dottydingo.hyperion.core.translation.DefaultAuditingTranslator;
import com.dottydingo.hyperion.northwind.api.Category;
import com.dottydingo.hyperion.northwind.service.model.PersistentCategory;

/**
 */
public class CategoryTranslator extends DefaultAuditingTranslator<Category,PersistentCategory>
{
    public CategoryTranslator()
    {
        super(Category.class, PersistentCategory.class);
    }
}
