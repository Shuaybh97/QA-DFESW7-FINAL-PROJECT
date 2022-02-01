package com.qa.app.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "player")
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column
	@Length(min = 1, message = "You must specify a forename")
	private String forename;
	
	@NotNull
	@Column
	@Length(min = 1, message = "You must specify a surname")
	private String surname;
	
	@Column
	private String position;
	
	@Column
	private Integer goals = 0;
	
	@Column
	private Integer assists = 0;
	
	
	public Player() {
		super();
	}

	public Player(Long id, String forename, String surname, String position) {
		super();
		this.id = id;
		this.forename = forename;
		this.surname = surname;
		this.position = position;
		
	}


	public Player(String forename, String surname, String position) {
		super();
		this.forename = forename;
		this.surname = surname;
		this.position = position;
		
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

	@Override
	public String toString() {
		return "Player [id=" + id + ", forename=" + forename + ", surname=" + surname + ", position=" + position
				+ ", goals=" + goals + ", assists=" + assists + "]";
	}


	
	
	
	
	

}
