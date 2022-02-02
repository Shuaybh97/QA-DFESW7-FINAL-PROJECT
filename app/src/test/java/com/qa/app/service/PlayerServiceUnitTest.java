package com.qa.app.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.qa.app.data.entity.Player;
import com.qa.app.data.repository.PlayerRepository;
import com.qa.app.exceptions.PlayerNotFoundException;



@ExtendWith(MockitoExtension.class)
public class PlayerServiceUnitTest {

	@Mock
	private PlayerRepository playerRepository;
	
	
	@InjectMocks
	private PlayerService playerService;
	
	private List<Player> players;
	private List<Player> midfielders;
	private Player expectedPlayerWithoutId;
	private Player expectedPlayerWithId;
	
	@BeforeEach // junit5 (jupiter) annotation to run this method before every test
	public void init() {
		players = new ArrayList<>();
		players.addAll(List.of(new Player(1L, "shuayb", "h", "midfielder"), 
							   new Player(2L, "jamal", "A", "attacker"),
							   new Player(3L, "Mo", "S", "defender")));
		midfielders = new ArrayList<>();
		midfielders.addAll(List.of(new Player(1L, "shuayb", "h", "midfielder"),
				                   new Player(2L, "jamal", "A", "attacker")));
	
		expectedPlayerWithoutId = new Player("shuayb", "h", "midfielder");
		expectedPlayerWithId = new Player(1L, "shuayb", "h", "midfielder");
	}
	
	
	@Test
	public void getPlayersTest() {
		
		when(playerRepository.findAll()).thenReturn(players);
		assertThat(playerService.getPlayers()).isEqualTo(players);
		verify(playerRepository).findAll();
	}
	
	

	@Test
	public void getByIdTest() {
		
		Long id = expectedPlayerWithId.getId();
		when(playerRepository.existsById(id)).thenReturn(true);
		when(playerRepository.findById(id)).thenReturn(Optional.of(expectedPlayerWithId));
		
		assertThat(playerService.getById(id)).isEqualTo(Optional.of(expectedPlayerWithId));
		verify(playerRepository).findById(id);
	}
	
	@Test
	public void addPlayerTest() {
		
		when(playerRepository.save(expectedPlayerWithoutId)).thenReturn(expectedPlayerWithId);

		assertThat(playerService.addPlayer(expectedPlayerWithoutId)).isEqualTo(expectedPlayerWithId);
		verify(playerRepository).save(expectedPlayerWithoutId);
	}
	
	@Test
	public void updatePlayerTest() {
		
		Long id = expectedPlayerWithId.getId();
		Player updatedPlayer = new Player(1L, "shuayb", "h", "attacker");
		
		when(playerRepository.existsById(id)).thenReturn(true);
		when(playerRepository.getById(id)).thenReturn(expectedPlayerWithId);
		when(playerRepository.save(expectedPlayerWithId)).thenReturn(updatedPlayer);

		assertThat(playerService.updatePlayer(1L, updatedPlayer)).isEqualTo(updatedPlayer);
		verify(playerRepository).existsById(id);
		verify(playerRepository).getById(id);
		verify(playerRepository).save(expectedPlayerWithId);
	}
	
	
	@Test
	public void deletePlayerTest() {
		
		Long id = expectedPlayerWithId.getId();
		
		when(playerRepository.existsById(id)).thenReturn(true);
		playerService.deletePlayer(id);
		
		verify(playerRepository).existsById(id);
		verify(playerRepository).deleteById(id);
	}
	
	
	@Test
	public void getByPositionTest() {
		
		String position = "midfielder";
		
		when(playerRepository.findByPosition(position)).thenReturn(midfielders);
		assertThat(playerService.getByPosition(position)).isEqualTo(midfielders);
		verify(playerRepository).findByPosition(position);
	}
	
	
	
	@Test
	public void getPlayerByInvalidIdTest() {
		
		long id = 20;
		when(playerRepository.existsById(id)).thenReturn(false);
		PlayerNotFoundException e = Assertions.assertThrows(PlayerNotFoundException.class, () -> {
			playerService.getById(id);
		});
		
		String expected = "Player with id " + id + " not found";
		assertThat(e.getMessage()).isEqualTo(expected);
		
		verify(playerRepository).existsById(id);
		
		
	}
	
	
	@Test
	public void updateInvalidPlayerTest() {
		
		long id = 20;
		Player updatedPlayer = new Player(1L, "shuayb", "h", "attacker");
		
		when(playerRepository.existsById(id)).thenReturn(false);
		PlayerNotFoundException e = Assertions.assertThrows(PlayerNotFoundException.class, () -> {
			playerService.updatePlayer(id, updatedPlayer);
		});
		
		String expected = "Player with id " + id + " not found";
		assertThat(e.getMessage()).isEqualTo(expected);
		
		verify(playerRepository).existsById(id);
		
		
	}
	
	
	@Test
	public void deleteInvalidPlayerTest() {
		
		long id = 20;
		
		
		when(playerRepository.existsById(id)).thenReturn(false);
		PlayerNotFoundException e = Assertions.assertThrows(PlayerNotFoundException.class, () -> {
			playerService.deletePlayer(id);
		});
		
		String expected = "Player with id " + id + " not found";
		assertThat(e.getMessage()).isEqualTo(expected);
		
		verify(playerRepository).existsById(id);
		
		
	}
	
	
	
	
}
