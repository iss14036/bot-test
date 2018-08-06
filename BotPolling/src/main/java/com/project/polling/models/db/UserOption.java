package com.project.polling.models.db;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "t_user_option")
public class UserOption {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String userId;
	private String optionUser;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "t_polling_id")
	private Polling polling;

	public UserOption(String userId, String optionUser, Polling polling) {
		super();
		this.userId = userId;
		this.optionUser = optionUser;
		this.polling = polling;
	}

	public UserOption() {
		super();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOptionUser() {
		return optionUser;
	}

	public void setOptionUser(String optionUser) {
		this.optionUser = optionUser;
	}

	public Polling getPolling() {
		return polling;
	}

	public void setPolling(Polling polling) {
		this.polling = polling;
	}

	@Override
	public String toString() {
		return "UserOption [id=" + id + ", userId=" + userId + ", optionUser=" + optionUser + ", polling=" + polling
				+ "]";
	}

}
