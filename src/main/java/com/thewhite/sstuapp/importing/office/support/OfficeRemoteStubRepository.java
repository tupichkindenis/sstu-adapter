package com.thewhite.sstuapp.importing.office.support;

import com.thewhite.sstuapp.importing.office.OfficeEntity;
import com.thewhite.sstuapp.importing.office.OfficeEntityReduced;
import com.thewhite.sstuapp.importing.office.OfficeRemoteRepository;

import java.io.Serializable;

/**
 * Stub.
 */
@SuppressWarnings("unused")
public class OfficeRemoteStubRepository implements OfficeRemoteRepository<OfficeEntity, Long>  {
    @Override
    public Iterable<OfficeEntityReduced> findAllReducedProjection() {
        return null;
    }

    @Override
    public OfficeEntity findOne(Long aLong) {
        return null;
    }

    @Override
    public Iterable<OfficeEntity> findAll() {
        return null;
    }
}
