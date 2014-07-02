package com.dottydingo.hyperion.northwind.service;

import com.dottydingo.hyperion.northwind.api.Category;
import com.dottydingo.hyperion.core.persistence.CreateKeyProcessor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 */
public class CategoryCreateKeyProcessor implements CreateKeyProcessor<Category, Long>
{
    @PersistenceContext
    private EntityManager em;

    @Override
    public Long lookup(Category item, com.dottydingo.hyperion.core.persistence.PersistenceContext persistenceContext)
    {
        if(item.getCategoryName() == null)
            return null;

        TypedQuery<Long> query =
                em.createQuery("select id from PersistentCategory where categoryName=:categoryName", Long.class);
        query.setParameter("categoryName",item.getCategoryName());

        List<Long> resultList = query.getResultList();
        if(resultList.size() == 1)
            return  resultList.get(0);
        return null;
    }
}
