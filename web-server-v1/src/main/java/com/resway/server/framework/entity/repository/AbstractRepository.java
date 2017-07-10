/*
 * Copyright (©) Residential Way, 2016 - 2017, All rights reserved. The
 * intellectual and technical concepts contained herein are proprietary to
 * Residential Way and its suppliers and may be covered by U.S. and Foreign
 * Patents, patents in process, and are protected by trade secret or copyright
 * law. Unauthorized copying of this file, via any medium is strictly
 * prohibited. Proprietary and confidential.
 */
package com.resway.server.framework.entity.repository;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;

import com.resway.server.framework.entity.domain.AbstractDomainKey;
import com.resway.server.framework.entity.domain.AbstractDomainObject;

/**
 * Abstract Repository is responsible to perform all CRUD operations with the
 * database. Repositories are strictly to be accessed from within the Service
 * layer and can be accessed only by a Domain Object of the type
 * {@link AbstractDomainObject}
 *
 * @since 1.0.0
 * @author Kevin
 *
 * @param <T>
 *            Domain Object of the type {@link AbstractDomainObject}
 *
 * @param <K>
 *            Domain Object Key of the type {@link AbstractDomainKey}
 */
@Transactional
public abstract class AbstractRepository<T extends AbstractDomainObject, K extends AbstractDomainKey> {
	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;
	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(AbstractRepository.class.getName());

	/**
	 * Fetches the object from persistence storage of given id.
	 *
	 * @param entityClass
	 *            The classType of the Entity which needs to be read.
	 * @param key
	 *            The key extending {@link AbstractDomainKey}for which data
	 *            needs to be read from the repository.
	 * @return object of type {@link AbstractDomainObject} that needs to be
	 *         read.
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public T read(Class<T> entityClass, K key) throws Exception {
		final Session session = entityManager.unwrap(Session.class);
		//		session.getTransaction().begin();
		final AbstractDomainObject entity = entityManager.find(entityClass, key);
		//		session.getTransaction().commit();
		//		session.close();
		LOGGER.fine("/nEntity READ successful/n");
		return (T) entity;
	};

	/**
	 * Persist the given object at persistence storage.
	 *
	 * @param object
	 *            The object extending {@link AbstractDomainObject} which needs
	 *            to be inserted.
	 * @return object of type {@link AbstractDomainObject} with the newly
	 *         generated id.
	 * @throws Exception
	 *             If unable to insert data.
	 */
	public T create(T object) throws Exception {
		final Session session = entityManager.unwrap(Session.class);
		//		session.getTransaction().begin();
		final AbstractDomainKey key = (AbstractDomainKey) session.save(object);
		session.flush();
		//		session.getTransaction().commit();
		//		session.close();
		LOGGER.fine("Entity CREATED successfully.");
		return object;
	};

	/**
	 * Update the object at persistence storage.
	 *
	 * @param object
	 *            The object extending {@link AbstractDomainObject} which needs
	 *            to be updated.
	 * @throws Exception
	 *             If unable to update data.
	 */
	public void update(T object) throws Exception {
		final Session session = entityManager.unwrap(Session.class);
		//		session.getTransaction().begin();
		session.update(object);
		//		session.getTransaction().commit();
		//		session.close();
		LOGGER.fine("Entity UPDATED successfully.");
	};

	/**
	 * Removes the object from persistence storage.
	 *
	 * @param entity
	 *            The object extending {@link AbstractDomainObject} which needs
	 *            to be deleted, provided the {@link AbstractDomainKey} is not
	 *            null or empty.
	 * @throws java.lang.Exception
	 *             If unable to delete data.
	 */
	public void delete(T entity) throws Exception {
		final Session session = entityManager.unwrap(Session.class);
		//		session.getTransaction().begin();
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
		//		session.getTransaction().commit();
		//		session.close();
		LOGGER.fine("Entity DELETED successfully.");
	};
}
