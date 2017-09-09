package com.thewhite.sstuapp.remote.repository;

import com.thewhite.sstuapp.importing.request.RequestEntity;
import com.thewhite.sstuapp.importing.request.RequestRemoteRepository;
import com.thewhite.sstuapp.importing.request.support.RequestRemoteApiRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.response.DefaultResponseCreator;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.client.ExpectedCount.times;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

/**
 * Created by tupichkindenis on 30.08.17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RequestRemoteApiRepositoryTests{

    @Autowired
    private RequestRemoteApiRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${remote.api.requests.find-one}")
    private String FIND_ONE_URI;

    @Value("${remote.api.requests.find-all}")
    private String FIND_ALL_URI;

    @Value("${remote.api.requests.find-all-reduced}")
    private String FIND_ALL_REDUCED_URI;

    private MockRestServiceServer mockRestServiceServer;

    @Before
    public void setUp(){
        mockRestServiceServer = MockRestServiceServer.bindTo(restTemplate).build();
    }


    @Test
    public void testItShouldRetrieveOnlyOneRequestById_Success() throws IOException {

//        byte[] responseBody = readAllBytes(get("src", "test", "resources", "mock", "responses", "remote.server.response.requests.findOne.105945115.200.xml"));
//
//        DefaultResponseCreator responseCreator = withStatus(HttpStatus.OK)
//                .body(responseBody)
//                .contentType(MediaType.APPLICATION_XML);
//
//        mockRestServiceServer
//                .expect(times(1), requestTo(FIND_ONE_URI + "/" + String.valueOf(105945115L)))
//                .andExpect(method(HttpMethod.GET))
//                .andRespond(responseCreator);
//
//        RequestEntity requestEntity = repository.findOne(105945115L);
//
//        assertThat(requestEntity.getId(), is(105945115L) );
//        assertThat(requestEntity.getName(), is("Тенякова Галина Леонидовна"));
    }


}
