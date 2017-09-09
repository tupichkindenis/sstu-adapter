package com.thewhite.sstuapp.importing;

import com.thewhite.sstuapp.importing.request.RequestLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Scheduler.
 */
@Component
public class LoadScheduler {

    private static final long ONE_MINUTE = 1000 * 60;
    private static final long ONE_HOUR   = ONE_MINUTE * 60;
    private static final long ONE_DAY    = ONE_HOUR * 24;

    @Autowired
    private RequestLoader requestLoader;

    @Autowired
    private LoaderService loaderService;

//    @Scheduled(fixedDelay = ONE_MINUTE, initialDelayString = "${search.indexer.delay:0}")
//    public void loadRequests(){ loaderService.load(requestLoader); }


}
