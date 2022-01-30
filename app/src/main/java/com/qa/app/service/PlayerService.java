package com.qa.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.app.data.entity.Player;
import com.qa.app.data.repository.PlayerRepository;


@Service
public class PlayerService {

	
	
	private final PlayerRepository playerRepository;
	

	@Autowired
	public PlayerService(PlayerRepository playerRepository) {
		super();
		this.playerRepository = playerRepository;
	}

	

//	List<Player> test = List.of(new Player(1L, "Shuaib", "Hussein", "Midfielder", 0, 0),
//			   new Player(2L, "Abdi", "Hussein", "Attacker", 0, 0));


	public List<Player> getPlayers() {
		
		return playerRepository.findAll();
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
