package com.qa.app.data.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Stats {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int goals = 0;
	
	private int assists = 0;
	
	private int gamesWon = 0;

	
	
	@OneToOne(targetEntity = Player.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	
	
	private Player player;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getGoals() {
		return goals;
	}


	public void setGoals(int goals) {
		this.goals = goals;
	}


	public int getAssists() {
		return assists;
	}


	public void setAssists(int assists) {
		this.assists = assists;
	}


	public int getGamesWon() {
		return gamesWon;
	}


	public void setGamesWon(int gamesWon) {
		this.gamesWon = gamesWon;
	}


	public Player getPlayer() {
		return player;
	}


	public void setPlayer(Player player) {
		this.player = player;
	}
	
	
	
	
	
}

