package com.thewhite.sstuapp.importing.office.support;

import com.thewhite.sstuapp.importing.LoaderService;
import com.thewhite.sstuapp.importing.office.OfficeEntity;
import com.thewhite.sstuapp.importing.office.OfficeEntityReduced;
import com.thewhite.sstuapp.importing.office.OfficeRemoteRepository;
import com.thewhite.sstuapp.importing.support.HttpEntityBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Repository.
 *
 */
@Service("OfficeRemoteApiRepository")
@SuppressWarnings("unused")
public class OfficeRemoteApiRepository implements OfficeRemoteRepository<OfficeEntity, Long> {

    private static final Log logger = LogFactory.getLog(LoaderService.class);

    @Value("${remote.api.offices.find-one}")
    private String FIND_ONE_URI;

    @Value("${remote.api.offices.find-all}")
    private String FIND_ALL_URI;

    @Value("${remote.api.offices.find-all-reduced}")
    private String FIND_ALL_REDUCED_URI;

    private final RestTemplate restTemplate;

    /**
     *
     * @param restTemplate
     */
    @Autowired
    public OfficeRemoteApiRepository(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    /**
     * Retrieves an remote Office by its id.
     *
     * @param id id must not be {@literal null}.
     * @return IllegalArgumentException if {@code id} is {@literal null}
     */
    @Override
    public OfficeEntity findOne(Long id) {
        HttpEntityBuilder<Void> httpEntityBuilder = new HttpEntityBuilder<>();
        ResponseEntity<OfficeEntity> responseEntity = restTemplate.exchange(
                FIND_ONE_URI + "/" + id,
                HttpMethod.GET,
                httpEntityBuilder.build(),
                new ParameterizedTypeReference<OfficeEntity>() {});

        return responseEntity.getBody();
    }

    /**
     * Retrieves all Offices.
     *
     * @return all Offices
     */
    @Override
    public Iterable<OfficeEntity> findAll() {
        HttpEntityBuilder<Void> httpEntityBuilder = new HttpEntityBuilder<>();
        ResponseEntity<List<OfficeEntity>> responseEntity = restTemplate.exchange(
                FIND_ALL_URI,
                HttpMethod.GET,
                httpEntityBuilder.build(),
                new ParameterizedTypeReference<List<OfficeEntity>>() {});

        return responseEntity.getBody();
    }

    /**
     * Retrieves all Offices in its reduced projection.
     *
     * @return all Offices in reduces projection
     */
    @Override
    public Iterable<OfficeEntityReduced> findAllReducedProjection() {
        HttpEntityBuilder<Void> httpEntityBuilder = new HttpEntityBuilder<>();
        ResponseEntity<List<OfficeEntityReduced>> responseEntity = restTemplate.exchange(
                FIND_ALL_REDUCED_URI,
                HttpMethod.GET,
                httpEntityBuilder.build(),
                new ParameterizedTypeReference<List<OfficeEntityReduced>>() {});
        return responseEntity.getBody();
    }
}
