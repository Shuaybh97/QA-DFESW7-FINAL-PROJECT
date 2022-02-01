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
@Table(name = "Player")
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "forename")
	@Length(min = 1, message = "You must specify a forename")
	private String a_forename;
	
	@NotNull
	@Column(name = "surname")
	@Length(min = 1, message = "You must specify a surname")
	private String b_surname;
	
	@Column(name = "position")
	private String c_position;
	
	@Column(name = "goals")
	private Integer d_goals = 0;
	
	@Column(name = "assists")
	private Integer e_assists = 0;
	
	
	public Player() {
		super();
	}

	public Player(Long id, String forename, String surname, String position, Integer goals, Integer assists) {
		super();
		this.id = id;
		this.a_forename = forename;
		this.b_surname = surname;
		this.c_position = position;
		this.d_goals = goals;
		this.e_assists = assists;
	}


	public Player(String forename, String surname, String position, Integer goals, Integer assists) {
		super();
		this.a_forename = forename;
		this.b_surname = surname;
		this.c_position = position;
		this.d_goals = goals;
		this.e_assists = assists;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getForename() {
		return a_forename;
	}


	public void setForename(String forename) {
		this.a_forename = forename;
	}


	public String getSurname() {
		return b_surname;
	}


	public void setSurname(String surname) {
		this.b_surname = surname;
	}


	public String getPosition() {
		return c_position;
	}


	public void setPosition(String position) {
		this.c_position = position;
	}
	 
	public Integer getGoals() {
		return d_goals;
	}


	public void setGoals(Integer goals) {
		this.d_goals = goals;
	}


	public Integer getAssists() {
		return e_assists;
	}


	public void setAssists(Integer assists) {
		this.e_assists = assists;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", forename=" + a_forename + ", surname=" + b_surname + ", position=" + c_position
				+ ", goals=" + d_goals + ", assists=" + e_assists + "]";
	}


	
	
	
	
	

}
