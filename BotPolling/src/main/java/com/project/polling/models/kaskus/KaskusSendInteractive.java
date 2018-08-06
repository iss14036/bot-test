package com.project.polling.models.kaskus;

import java.util.List;

public class KaskusSendInteractive {
	private long id;
	private List<KaskusList> sendList;
	private String from;
	private String placeholder;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<KaskusList> getSendList() {
		return sendList;
	}

	public void setSendList(List<KaskusList> sendList) {
		this.sendList = sendList;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

	@Override
	public String toString() {
		return "KaskusSendInteractive [id=" + id + ", sendList=" + sendList + ", from=" + from + ", placeholder="
				+ placeholder + "]";
	}

	public KaskusSendInteractive(long id, List<KaskusList> sendList, String from, String placeholder) {
		super();
		this.id = id;
		this.sendList = sendList;
		this.from = from;
		this.placeholder = placeholder;
	}

	public KaskusSendInteractive() {
		super();
	}
}
