package com.qa.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<List<Player>> getPlayers() {

		ResponseEntity<List<Player>> players = ResponseEntity.ok(playerService.getPlayers());
		return players;
	}

	
	public Player getById(Long id) {
		
		return null;
		
	}
	
	@PostMapping
	public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
		
		
		Player savedPlayer = playerService.addPlayer(player);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/player/" + String.valueOf(savedPlayer.getId()));
		
															 
		ResponseEntity<Player> response = new ResponseEntity<Player>(savedPlayer, headers, HttpStatus.CREATED);
		return response;
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Player> updatePlayer(@PathVariable("id") Long id, @RequestBody Player player) {
		
		Player updatedPlayer = playerService.updatePlayer(id, player);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/player/" + String.valueOf(updatedPlayer.getId()));
		
		return new ResponseEntity<Player>(updatedPlayer, headers, HttpStatus.ACCEPTED);
		
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletePlayer(@PathVariable("id") Long id) {
		
		playerService.deletePlayer(id);
		return ResponseEntity.accepted().build();
		
	}


	
}
