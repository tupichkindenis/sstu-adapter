package com.thewhite.sstuapp.importing.request;

import com.thewhite.sstuapp.importing.support.RemoteRepository;

import java.io.Serializable;

/**
 * Remote request repository.
 */
@SuppressWarnings("unused")
public interface RequestRemoteRepository<T, ID extends Serializable> extends RemoteRepository<T,ID> {
    Iterable<RequestEntityReduced> findAllReducedProjection();
}
