package com.qa.app.data.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	private int height;
	
	// right footed or left footed
	@Column
	private String laterality;
	
	
	@OneToOne(mappedBy = "player", fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	
	private Stats stats;
	
	
	public Player() {
		super();
	}
	
	public Player(Long id, @NotNull @Length(min = 1, message = "You must specify a forename") String forename,
			@NotNull @Length(min = 1, message = "You must specify a surname") String surname, String position,
			int height, String laterality) {
		super();
		this.id = id;
		this.forename = forename;
		this.surname = surname;
		this.position = position;
		this.height = height;
		this.laterality = laterality;
	}


	public Player(@NotNull @Length(min = 1, message = "You must specify a forename") String forename,
			@NotNull @Length(min = 1, message = "You must specify a surname") String surname, String position,
			int height, String laterality) {
		super();
		this.forename = forename;
		this.surname = surname;
		this.position = position;
		this.height = height;
		this.laterality = laterality;
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


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public String getLaterality() {
		return laterality;
	}


	public void setLaterality(String laterality) {
		this.laterality = laterality;
	}


	@Override
	public String toString() {
		return "Player [id=" + id + ", forename=" + forename + ", surname=" + surname + ", position=" + position
				+ ", height=" + height + ", laterality=" + laterality + "]";
	}
	 
	

	
	
	
	

}
