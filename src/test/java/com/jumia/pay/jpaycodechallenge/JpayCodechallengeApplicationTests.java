package com.jumia.pay.jpaycodechallenge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jumia.pay.jpaycodechallenge.controllers.CardSchemeController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpayCodechallengeApplicationTests {

	@Autowired
	private CardSchemeController controller;

	@Test
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
