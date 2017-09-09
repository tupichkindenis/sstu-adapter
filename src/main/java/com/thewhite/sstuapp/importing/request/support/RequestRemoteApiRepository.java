package com.thewhite.sstuapp.importing.request.support;

import com.thewhite.sstuapp.importing.office.OfficeEntity;
import com.thewhite.sstuapp.importing.office.OfficeEntityReduced;
import com.thewhite.sstuapp.importing.request.RequestEntity;
import com.thewhite.sstuapp.importing.request.RequestEntityReduced;
import com.thewhite.sstuapp.importing.request.RequestRemoteRepository;
import com.thewhite.sstuapp.importing.support.HttpEntityBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by tupichkindenis on 30.08.17.
 */
@Service
@SuppressWarnings("unused")
public class RequestRemoteApiRepository implements RequestRemoteRepository<RequestEntity,Long> {

    @Value("${remote.api.requests.find-one}")
    private String FIND_ONE_URI;

    @Value("${remote.api.requests.find-all}")
    private String FIND_ALL_URI;

    @Value("${remote.api.requests.find-all-reduced}")
    private String FIND_ALL_REDUCED_URI;

    private final RestTemplate restTemplate;

    @Autowired
    public RequestRemoteApiRepository(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public RequestEntity findOne(Long id) {
        HttpEntityBuilder<Void> httpEntityBuilder = new HttpEntityBuilder<>();
        ResponseEntity<RequestEntity> responseEntity = restTemplate.exchange(
                FIND_ONE_URI + "/" + id,
                HttpMethod.GET,
                httpEntityBuilder.build(),
                new ParameterizedTypeReference<RequestEntity>() {});

        return responseEntity.getBody();
    }

    @Override
    public Iterable<RequestEntity> findAll() {
        HttpEntityBuilder<Void> httpEntityBuilder = new HttpEntityBuilder<>();
        ResponseEntity<List<RequestEntity>> responseEntity = restTemplate.exchange(
                FIND_ALL_URI,
                HttpMethod.GET,
                httpEntityBuilder.build(),
                new ParameterizedTypeReference<List<RequestEntity>>() {});

        return responseEntity.getBody();
    }

    @Override
    public Iterable<RequestEntityReduced> findAllReducedProjection() {
        HttpEntityBuilder<Void> httpEntityBuilder = new HttpEntityBuilder<>();
        ResponseEntity<List<RequestEntityReduced>> responseEntity = restTemplate.exchange(
                FIND_ALL_REDUCED_URI,
                HttpMethod.GET,
                httpEntityBuilder.build(),
                new ParameterizedTypeReference<List<RequestEntityReduced>>() {});
        return responseEntity.getBody();
    }
}
