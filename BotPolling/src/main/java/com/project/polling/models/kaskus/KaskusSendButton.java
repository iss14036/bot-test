package com.project.polling.models.kaskus;

import java.util.List;

public class KaskusSendButton {
	private long id;
	private List<KaskusListButton> sendList;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<KaskusListButton> getSendList() {
		return sendList;
	}

	public void setSendList(List<KaskusListButton> sendList) {
		this.sendList = sendList;
	}

	public KaskusSendButton(long id, List<KaskusListButton> sendList) {
		super();
		this.id = id;
		this.sendList = sendList;
	}

}
