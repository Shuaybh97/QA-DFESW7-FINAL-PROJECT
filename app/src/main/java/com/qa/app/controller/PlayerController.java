package com.qa.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.app.data.entity.Player;
import com.qa.app.service.PlayerService;


@RestController
@RequestMapping(path = "/player")
public class PlayerController {

	private final PlayerService playerService;
	
	
	@Autowired
	public PlayerController(PlayerService playerService) {
		super();
		this.playerService = playerService;
	}



	@GetMapping
	public List<Player> getPlayers() {

	 return playerService.getPlayers();
	 
	}

	
	public Player getById(Long id) {
		
		return null;
		
	}
	
	
	public Player create(Player player) {
		
		return null;
		
	}
	
	public Player update(Long id, Player player) {
		
		return null;
	}
	
	
	public void delete(long id) {
		
	}


	
}
