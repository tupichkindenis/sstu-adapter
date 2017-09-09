package com.thewhite.sstuapp.service;

import com.thewhite.sstuapp.domain.Request;

import java.util.UUID;

/**
 * Request service interface.
 */
public interface RequestService {

    /**
     * Creates new Request.
     * @return
     */
    Request create();

    /**
     * Gets Request by provided uuid.
     */
    Request get(final UUID uuid);

    /**
     * Gets Request by provided external system id.
     */
    Request getByExternalId(final long externalId);

}
