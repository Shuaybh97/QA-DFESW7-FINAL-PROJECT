package com.qa.app.data.entity;

public class Player {
	
	private Long id;
	private String forename;
	private String surname;
	private String position;
	private Integer goals;
	private Integer assists;
	
	
	public Player() {
		super();
	}

	public Player(Long id, String forename, String surname, String position, Integer goals, Integer assists) {
		super();
		this.id = id;
		this.forename = forename;
		this.surname = surname;
		this.position = position;
		this.goals = goals;
		this.assists = assists;
	}


	public Player(String forename, String surname, String position, Integer goals, Integer assists) {
		super();
		this.forename = forename;
		this.surname = surname;
		this.position = position;
		this.goals = goals;
		this.assists = assists;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getForename() {
		return forename;
	}


	public void setForename(String forename) {
		this.forename = forename;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	@Override
	public String toString() {
		return "Player [id=" + id + ", forename=" + forename + ", surname=" + surname + ", position=" + position
				+ ", goals=" + goals + ", assists=" + assists + "]";
	}


	public Integer getGoals() {
		return goals;
	}


	public void setGoals(Integer goals) {
		this.goals = goals;
	}


	public Integer getAssists() {
		return assists;
	}


	public void setAssists(Integer assists) {
		this.assists = assists;
	}
	
	
	
	
	
	

}
