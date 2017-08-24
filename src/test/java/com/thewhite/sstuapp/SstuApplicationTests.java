package com.thewhite.sstuapp;

import com.thewhite.sstuapp.export.SstuClient;
import com.thewhite.sstuapp.export.SstuErrorDecoder;
import com.thewhite.sstuapp.export.dto.SstuRequest;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SstuApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void feign(){
//		SstuClient sstuClient = Feign.builder()
//				.client(new OkHttpClient())
//				.encoder(new GsonEncoder())
//				.decoder(new GsonDecoder())
//				.errorDecoder(new SstuErrorDecoder())
//				.logger(new Slf4jLogger(SstuClient.class))
//				.logLevel(Logger.Level.FULL)
//				.target(SstuClient.class, "https://jsonplaceholder.typicode.com/posts");
//
//		SstuRequest request = new SstuRequest();
//
//		sstuClient.upload(request);
	}

}
