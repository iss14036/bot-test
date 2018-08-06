package com.project.polling.models.db;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "t_state")
public class State {
	@Id
	private String idGroup;
	private String idUser;
	private String stateDescription;
	public State(String idGroup, String idUser, String stateDescription) {
		super();
		this.idGroup = idGroup;
		this.idUser = idUser;
		this.stateDescription = stateDescription;
	}
	public State() {
		super();
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public String getStateDescription() {
		return stateDescription;
	}
	public void setStateDescription(String stateDescription) {
		this.stateDescription = stateDescription;
	}
	
	
}
