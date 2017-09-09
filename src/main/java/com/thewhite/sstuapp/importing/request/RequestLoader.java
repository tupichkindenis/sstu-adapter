package com.thewhite.sstuapp.importing.request;


import com.thewhite.sstuapp.importing.Loader;
import com.thewhite.sstuapp.importing.office.OfficeRemoteRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


/**
 * Loader service for requests.
 */
@Service
@SuppressWarnings("unused")
public class RequestLoader implements Loader<RequestEntity> {

    private static final Log logger = LogFactory.getLog(RequestLoader.class);

    @Autowired
    private OfficeRemoteRepository officeRemoteRepository;

    @Autowired
    private RequestRemoteRepository requestRemoteRepository;

    /**
     * Gets collection of requests ready to load from EDM system.
     * @return
     */
    @Override
        public Iterable<RequestEntity> loadableItems() {

        ArrayList<RequestEntity> result = new ArrayList<>();

//        officeRemoteRepository
//                .findAllReducedProjection().forEach( officeIdentifier -> requestRemoteRepository
//                        .findByOfficeId(officeIdentifier).forEach( requestIdentifier -> result.add(requestIdentifier)));

        return result;
    }

    /**
     * Load request.
     * @param loadable
     */
    @Override
    public void loadItem(RequestEntity loadable) {
        // todo Load request from EDM
        // todo Validate request
        // todo Map Request to Request
        // todo load Questions
        //
    }

    @Override
    public String counterName() { return "requests"; }

    @Override
    public String getId(RequestEntity loadable) { return Long.toString(loadable.getId()); }
}
