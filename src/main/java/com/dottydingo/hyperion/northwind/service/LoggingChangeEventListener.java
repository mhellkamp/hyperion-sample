package com.dottydingo.hyperion.northwind.service;

import com.dottydingo.hyperion.api.BaseApiObject;
import com.dottydingo.hyperion.core.endpoint.HttpMethod;
import com.dottydingo.hyperion.core.persistence.EntityChangeEvent;
import com.dottydingo.hyperion.core.persistence.EntityChangeListener;
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
        if(event.getHttpMethod() == HttpMethod.POST)
            id = event.getUpdatedItem().getId();
        else
            id = event.getOriginalItem().getId();

        logger.info("{} on {} id: {}. Changed: {}",event.getHttpMethod(),event.getEndpointName(),id,event.getUpdatedFields());
    }
}
