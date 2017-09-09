package com.thewhite.sstuapp.importing;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;

/**
 * Loader service.
 */
@Service
public class LoaderService {

    private final ExecutorService executorService;
    private final CounterService countersService;

    private static final Log logger = LogFactory.getLog(LoaderService.class);

    @Autowired
    public LoaderService(ExecutorService executorService, CounterService countersService){
        this.executorService = executorService;
        this.countersService = countersService;
    }

    /**
     *
     * @param loader
     * @param <T>
     */
    public <T> void load(final Loader<T> loader){
        logger.info("Loading " + loader.counterName());
        for (final T loadable : loader.loadableItems()) {
            executorService.submit(() -> {
                try {
                    loader.loadItem(loadable);
                    countersService.increment("load." + loader.counterName() + ".processed");
                } catch (Exception e) {
                    String message =
                            String.format("Unable to load an entry of '%s' with id: '%s' -> (%s, %s)",
                                    loader.counterName(),
                                    loader.getId(loadable),
                                    e.getClass().getName(),
                                    e.getMessage());

                    logger.warn(message);
                    countersService.increment("load." + loader.counterName() + ".errors.count");
                }
            });
        }
        countersService.increment("load." + loader.counterName() + ".refresh.count");
    }
}
