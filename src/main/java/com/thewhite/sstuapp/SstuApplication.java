package com.thewhite.sstuapp;


import com.thewhite.sstuapp.importing.office.support.OfficeRemoteApiRepository;
import com.thewhite.sstuapp.importing.office.OfficeRemoteRepository;
import com.thewhite.sstuapp.importing.request.support.RequestRemoteApiRepository;
import com.thewhite.sstuapp.importing.request.RequestRemoteRepository;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@EnableScheduling
@SpringBootApplication
public class SstuApplication {

	public static void main(String[] args) {
		SpringApplication.run(SstuApplication.class, args);
	}


	@Bean
	public TaskScheduler scheduler() {
		ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
		scheduler.setPoolSize(10);
		return scheduler;
	}

	@Bean
	public ExecutorService executorService() {
		return Executors.newFixedThreadPool(10);
	}

	@Bean
	public OfficeRemoteRepository officeRemoteRepository(){ return new OfficeRemoteApiRepository(restTemplate()); }

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate(getClientHttpRequestFactory());
	}


	private ClientHttpRequestFactory getClientHttpRequestFactory() {
		int timeout = 5000;
		RequestConfig config = RequestConfig.custom()
				.setConnectTimeout(timeout)
				.setConnectionRequestTimeout(timeout)
				.setSocketTimeout(timeout)
				.build();
		CloseableHttpClient client = HttpClientBuilder
				.create()
				.setDefaultRequestConfig(config)
				.build();
		return new HttpComponentsClientHttpRequestFactory(client);
	}

}
