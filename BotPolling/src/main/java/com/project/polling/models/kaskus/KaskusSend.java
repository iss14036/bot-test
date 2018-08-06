package com.project.polling.models.kaskus;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KaskusSend {
	private long id;
	@JsonProperty("sendList")
	private List<KaskusSendList> sendListMesage;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<KaskusSendList> getSendListMesage() {
		return sendListMesage;
	}

	public void setSendListMesage(List<KaskusSendList> sendListMesage) {
		this.sendListMesage = sendListMesage;
	}

	public KaskusSend(long id, List<KaskusSendList> sendListMesage) {
		super();
		this.id = id;
		this.sendListMesage = sendListMesage;
	}

	@Override
	public String toString() {
		return "KaskusSend [id=" + id + ", sendListMesage=" + sendListMesage + "]";
	}

}
