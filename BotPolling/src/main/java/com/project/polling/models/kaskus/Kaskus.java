package com.project.polling.models.kaskus;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Kaskus {
	private String from;
	private String fromPlain;
	private String to;
	private String stanza;
	private String body;
	private String timeStamp;
	private String messageId;
	private String client;
	@JsonProperty("secure-message")
	private KaskusSecureMessage secure_message;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getFromPlain() {
		return fromPlain;
	}

	public void setFromPlain(String fromPlain) {
		this.fromPlain = fromPlain;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getStanza() {
		return stanza;
	}

	public void setStanza(String stanza) {
		this.stanza = stanza;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public KaskusSecureMessage getSecure_message() {
		return secure_message;
	}

	public void setSecure_message(KaskusSecureMessage secure_message) {
		this.secure_message = secure_message;
	}

}
