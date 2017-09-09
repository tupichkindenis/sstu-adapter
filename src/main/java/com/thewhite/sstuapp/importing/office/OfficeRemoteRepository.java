package com.thewhite.sstuapp.importing.office;
import com.thewhite.sstuapp.importing.support.RemoteRepository;
import java.io.Serializable;

/**
 * Interface to retrieves Offices
 */
@SuppressWarnings("unused")
public interface OfficeRemoteRepository<T, ID extends Serializable> extends RemoteRepository<T,ID> {
    Iterable<OfficeEntityReduced> findAllReducedProjection();
}
