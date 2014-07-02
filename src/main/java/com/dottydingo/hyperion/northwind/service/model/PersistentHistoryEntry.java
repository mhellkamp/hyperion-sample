package com.dottydingo.hyperion.northwind.service.model;

import com.dottydingo.hyperion.jpa.model.DefaultPersistentHistoryEntry;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 */
@Entity
@Table(name="entity_history")
@Access(AccessType.PROPERTY)
public class PersistentHistoryEntry extends DefaultPersistentHistoryEntry<Long>
{
}
