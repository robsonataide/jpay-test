package com.jumia.pay.jpaycodechallenge.response;

import com.jumia.pay.jpaycodechallenge.model.CardScheme;

public class CardSchemeResponse {

	private boolean success;
	private CardScheme payload;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public CardScheme getPayload() {
		return payload;
	}

	public void setPayload(CardScheme payload) {
		this.payload = payload;
	}

}
