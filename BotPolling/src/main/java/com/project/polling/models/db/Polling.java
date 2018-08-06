package com.project.polling.models.db;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "t_polling")
public class Polling {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String namePolling;
	private String authorPolling;
	private String groupPolling;
	private String statusPolling;
	@OneToMany(mappedBy = "polling")
	private Set<Option> option;
	@OneToMany(mappedBy = "polling")
	private Set<UserOption> userOption;

	public Polling() {
		super();
	}
	
	public Polling(String namePolling, String authorPolling, String groupPolling, String statusPolling) {
		super();
		this.namePolling = namePolling;
		this.authorPolling = authorPolling;
		this.groupPolling = groupPolling;
		this.statusPolling = statusPolling;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNamePolling() {
		return namePolling;
	}

	public void setNamePolling(String namePolling) {
		this.namePolling = namePolling;
	}

	public String getAuthorPolling() {
		return authorPolling;
	}

	public void setAuthorPolling(String authorPolling) {
		this.authorPolling = authorPolling;
	}

	public String getGroupPolling() {
		return groupPolling;
	}

	public void setGroupPolling(String groupPolling) {
		this.groupPolling = groupPolling;
	}

	public String getStatusPolling() {
		return statusPolling;
	}

	public void setStatusPolling(String statusPolling) {
		this.statusPolling = statusPolling;
	}

	

}
