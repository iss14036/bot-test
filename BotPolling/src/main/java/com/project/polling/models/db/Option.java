package com.project.polling.models.db;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "t_option")
public class Option {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String optionName;
	private int optionResult;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "t_polling_id")
	private Polling polling;

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getOptionResult() {
		return optionResult;
	}

	public void setOptionResult(int optionResult) {
		this.optionResult = optionResult;
	}

	public Polling getPolling() {
		return polling;
	}

	public void setPolling(Polling polling) {
		this.polling = polling;
	}

	public Option(String optionName, int optionResult, Polling polling) {
		super();
		this.optionName = optionName;
		this.optionResult = optionResult;
		this.polling = polling;
	}

	public Option() {
		super();
	}

	@Override
	public String toString() {
		return "Option [id=" + id + ", optionName=" + optionName + ", optionResult=" + optionResult + ", polling="
				+ polling + "]";
	}

}
