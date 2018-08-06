package com.project.polling.models.kaskus;

public class KaskusList {
	private String recipient;
	private KaskusBody body;

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

	@Override
	public String toString() {
		return "KaskusList [recipient=" + recipient + ", body=" + body + "]";
	}

	public KaskusList(String recipient, KaskusBody body) {
		super();
		this.recipient = recipient;
		this.body = body;
	}

	public KaskusList() {
		super();
	}
}
