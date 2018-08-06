package com.project.polling.models.kaskus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KaskusListButton {
	private String recipient;
	private KaskusBody body;

	public KaskusListButton(String recipient, KaskusBody body) {
		super();
		this.recipient = recipient;
		this.body = body;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public KaskusBody getBody() {
		return body;
	}

	public void setBody(KaskusBody body) {
		this.body = body;
	}

}
