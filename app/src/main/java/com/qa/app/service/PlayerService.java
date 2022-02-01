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



	public List<Player> getPlayers() {
		
		return playerRepository.findAll();
	}
	
	public Player getById(Long id) {
		return null;
		
	}
	
	
	public Player addPlayer(Player player) {
		
		Player savedPlayer = playerRepository.save(player);
		return savedPlayer;
		
	}
	
	public Player updatePlayer(Long id, Player player) {
		
		Player savedPlayer = playerRepository.getById(id);
		savedPlayer.setForename(player.getForename());
		savedPlayer.setSurname(player.getSurname());
		savedPlayer.setPosition(player.getPosition());
		savedPlayer.setGoals(player.getGoals());
		savedPlayer.setAssists(player.getAssists());
		
		return playerRepository.save(savedPlayer);
		
		
	}
	
	
	public void deletePlayer(Long id) {
		
		playerRepository.deleteById(id);
		
		
	}

	
	
	
	
	
}
