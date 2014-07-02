package com.dottydingo.hyperion.northwind.service;

import com.dottydingo.hyperion.api.BaseApiObject;
import com.dottydingo.hyperion.core.endpoint.HttpMethod;
import com.dottydingo.hyperion.core.persistence.PersistenceContext;
import com.dottydingo.hyperion.core.persistence.event.EntityChangeEvent;
import com.dottydingo.hyperion.core.persistence.event.EntityChangeListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 */
public class LoggingChangeEventListener implements EntityChangeListener<BaseApiObject<Long>>
{
    private Logger logger = LoggerFactory.getLogger(LoggingChangeEventListener.class);

    @Override
    public void processEntityChange(EntityChangeEvent<BaseApiObject<Long>> event)
    {
        Long id;
        PersistenceContext persistenceContext = event.getPersistenceContext();
        if(persistenceContext.getHttpMethod() == HttpMethod.POST)
            id = event.getUpdatedItem().getId();
        else
            id = event.getOriginalItem().getId();

        logger.info("{} on {} id: {}. Changed: {}",persistenceContext.getHttpMethod(),persistenceContext.getEntity(),id,event.getUpdatedFields());
    }
}
