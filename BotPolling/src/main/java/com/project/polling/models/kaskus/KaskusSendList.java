package com.project.polling.models.kaskus;

public class KaskusSendList {
	private String recipient;
	private String body;

	public KaskusSendList(String recipient, String body) {
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

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "KaskusSendList [recipient=" + recipient + ", body=" + body + "]";
	}
	
}
