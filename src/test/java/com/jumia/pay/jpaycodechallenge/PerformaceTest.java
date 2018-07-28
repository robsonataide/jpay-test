package com.jumia.pay.jpaycodechallenge;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PerformaceTest {
	
	@LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
	
	@Test
    public void lessThanTwoSeconds() throws Exception {
        long startCall = Calendar.getInstance().getTimeInMillis();
		this.restTemplate.getForObject("http://localhost:" + port + "/card-scheme/verify/5342123453", String.class);
		long diff = Calendar.getInstance().getTimeInMillis() - startCall;
		
		//tolerated 2 seconds
		long tolerated = 2 * 1000;
		
		assertThat(diff).isLessThan(tolerated);
	}
}
