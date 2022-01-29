package com.qa.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.app.data.entity.Player;


@RestController
@RequestMapping(path = "/player")
public class PlayerController {

	List<Player> players = List.of(new Player(1L, "Shuaib", "Hussein", "Midfielder", 0, 0),
								   new Player(2L, "Abdi", "Hussein", "Attacker", 0, 0));
								   
	
	
	@GetMapping
	public List<Player> getPlayers() {
		
		return players;
	}
	
	
	
}
