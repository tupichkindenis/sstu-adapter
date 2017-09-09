package com.thewhite.sstuapp.importing.support;

import java.io.Serializable;

/**
 * Interface of remote repositories.
 */
@SuppressWarnings("unused")
public interface RemoteRepository<T, ID extends Serializable> {

    /**
     * Retrieves an remote entity by its id.
     *
     * @param id id must not be {@literal null}.
     * @return IllegalArgumentException if {@code id} is {@literal null}
     */
    T findOne(ID id);

    /**
     * Return all instances of type.
     *
     * @return all entities
     */
    Iterable<T> findAll();

}
