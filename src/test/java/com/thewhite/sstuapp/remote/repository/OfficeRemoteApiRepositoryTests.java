package com.thewhite.sstuapp.remote.repository;

import com.thewhite.sstuapp.importing.office.OfficeEntity;
import com.thewhite.sstuapp.importing.office.OfficeEntityReduced;
import com.thewhite.sstuapp.importing.office.support.OfficeRemoteApiRepository;
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
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.client.ExpectedCount.times;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

/**
 * Created by tupichkindenis on 30.08.17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OfficeRemoteApiRepositoryTests {

    @Autowired
    private OfficeRemoteApiRepository officeRemoteRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${remote.api.offices.find-one}")
    private String FIND_ONE_URI;

    @Value("${remote.api.offices.find-all}")
    private String FIND_ALL_URI;

    @Value("${remote.api.offices.find-all-reduced}")
    private String FIND_ALL_REDUCED_URI;

    private MockRestServiceServer mockRestServiceServer;

    @Before
    public void setUp(){
        mockRestServiceServer = MockRestServiceServer.bindTo(restTemplate).build();
    }

    @Test
    public void testItShouldRetrieveTheCollectionOfAllOffices_Success() throws IOException {

        byte[] responseBody = readAllBytes(get("src", "test", "resources", "mock", "responses", "remote.server.response.offices.findAll.200.xml"));

        DefaultResponseCreator responseCreator = withStatus(HttpStatus.OK)
                .body(responseBody)
                .contentType(MediaType.APPLICATION_XML);

        mockRestServiceServer
                .expect(times(1), requestTo(FIND_ALL_URI))
                .andExpect(method(HttpMethod.GET))
                .andRespond(responseCreator);

        Iterable<OfficeEntity> identifiers = officeRemoteRepository.findAll();

        assertThat(((Collection<?>)identifiers), hasSize(2));

        Iterator<OfficeEntity> iterator = identifiers.iterator();

        OfficeEntity firstElement  = iterator.next();
        assertThat(firstElement.getId(), is(19679L) );
        assertThat(firstElement.getDepartmentId(), is(UUID.fromString("a5608515-543c-4835-b6e3-8beec23f71e6")));
        assertThat(firstElement.getName(), is("Комитет по труду и занятости населения Правительства Хабаровского края"));

        OfficeEntity secondElement = iterator.next();
        assertThat(secondElement.getId(), is(14313L) );
        assertThat(secondElement.getDepartmentId(), is(UUID.fromString("5c0546fc-45e3-4df3-89e0-0d0523a9ca79")));
        assertThat(secondElement.getName(), is("Комитет государственного заказа"));
    }


    @Test
    public void testItShouldRetrieveCollectionOfOfficeEntitiesReducesProjection_Success() throws IOException {

        byte[] responseBody = readAllBytes(get("src", "test", "resources", "mock", "responses", "remote.server.response.offices.findAllReducedProjection.200.xml"));

        DefaultResponseCreator responseCreator = withStatus(HttpStatus.OK)
                .body(responseBody)
                .contentType(MediaType.APPLICATION_XML);

        mockRestServiceServer
                .expect(times(1), requestTo(FIND_ALL_REDUCED_URI))
                .andExpect(method(HttpMethod.GET))
                .andRespond(responseCreator);

        Iterable<OfficeEntityReduced> identifiers = officeRemoteRepository.findAllReducedProjection();

        assertThat(((Collection<?>)identifiers), hasSize(3));

        Iterator<OfficeEntityReduced> iterator = identifiers.iterator();

        OfficeEntityReduced firstElement  = iterator.next();
        OfficeEntityReduced secondElement = iterator.next();
        OfficeEntityReduced thirdElement = iterator.next();

        assertThat(firstElement.getId(), is(19679L) );
        assertThat(secondElement.getId(), is(14313L) );
        assertThat(thirdElement.getId(), is(12345L) );

    }

    @Test
    public void testItShouldRetrieveOnlyOneOffice_Success() throws IOException {

        byte[] responseBody = readAllBytes(get("src", "test", "resources", "mock", "responses", "remote.server.response.offices.findOne.19679.200.xml"));

        DefaultResponseCreator responseCreator = withStatus(HttpStatus.OK)
                .body(responseBody)
                .contentType(MediaType.APPLICATION_XML);

        mockRestServiceServer
                .expect(times(1), requestTo(FIND_ONE_URI + "/19679"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(responseCreator);

        OfficeEntity entity = officeRemoteRepository.findOne(19679L);

        assertThat(entity.getId(), is(19679L) );
        assertThat(entity.getDepartmentId(), is(UUID.fromString("a5608515-543c-4835-b6e3-8beec23f71e6")) );
        assertThat(entity.getName(), is("Комитет по труду и занятости населения Правительства Хабаровского края"));
    }

}
