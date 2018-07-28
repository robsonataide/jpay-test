package com.jumia.pay.jpaycodechallenge.controllers;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jumia.pay.jpaycodechallenge.model.CardScheme;
import com.jumia.pay.jpaycodechallenge.response.CardSchemeResponse;

@RestController
@RequestMapping("/card-scheme")
public class CardSchemeController {

	private static final Logger log = LoggerFactory.getLogger(CardSchemeController.class);
	
	@GetMapping("/verify/{cardNumber}")
	public CardSchemeResponse verify(@PathVariable("cardNumber") String cardNumber) {


		StringBuffer urlStrBuffer = new StringBuffer("https://lookup.binlist.net/");
		urlStrBuffer.append(cardNumber);

		
		CardScheme cardScheme;
		CardSchemeResponse response = new CardSchemeResponse();
		
		RestTemplate restTemplate = new RestTemplate();
		//resolve performace with HTTPS
		restTemplate.setRequestFactory(new org.springframework.http.client.SimpleClientHttpRequestFactory());

		try {
			cardScheme = restTemplate.getForObject(urlStrBuffer.toString(), CardScheme.class);
			response.setSuccess(Objects.nonNull(cardScheme));
			if (response.isSuccess())
				response.setPayload(cardScheme);
		} catch (Exception e) {
			log.error( String.format("Error when call binlist API for card %s", cardNumber), e);
		}

		return response;
	}
}
