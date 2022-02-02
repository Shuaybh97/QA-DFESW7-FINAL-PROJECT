package com.qa.app.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qa.app.data.entity.Player;
import com.qa.app.service.PlayerService;


@WebMvcTest(PlayerController.class)
public class PlayerControllerWebIntegrationTest {

	@Autowired 
	private PlayerController controller;
	
	@MockBean 
	private PlayerService playerService;
	
	
	private List<Player> players;
	private List<Player> midfielders; 
	private Player playerToCreate; 
	private Player validPlayer;
	private ResponseEntity<Optional<Player>> optionalValidPlayer;
	
	@BeforeEach // junit5 (jupiter) annotation to run this method before every test
	public void init() {
		players = new ArrayList<>();
		players.addAll(List.of(new Player(1L, "shuayb", "h", "midfielder"), 
							   new Player(2L, "jamal", "A", "attacker"),
							   new Player(3L, "Mo", "S", "defender")));
		midfielders = new ArrayList<>();
		midfielders.addAll(List.of(new Player(1L, "shuayb", "h", "midfielder"),
				                   new Player(2L, "jamal", "A", "midfielder")));
	
		playerToCreate = new Player("shuayb", "h", "midfielder");
		validPlayer = new Player(1L, "shuaib", "h", "midfielder");
		
	}
	
	@Test 
	public void getAllPlayersTest() {
		
		// Given
		ResponseEntity<List<Player>> expected = new ResponseEntity<List<Player>>(players, HttpStatus.OK);
		
		// When 
		when(playerService.getPlayers()).thenReturn(players);
		
		// Then 
		ResponseEntity<List<Player>> actual = controller.getPlayers();
		assertThat(expected).isEqualTo(actual);
		
		// Verify
		verify(playerService, times(1)).getPlayers(); 
	}
	
	@Test
	public void createPlayerTest() {
		
		// Given
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/player/" + String.valueOf(validPlayer.getId()));
		ResponseEntity<Player> expected = new ResponseEntity<Player>(validPlayer, headers, HttpStatus.CREATED);
		
		// when
		when(playerService.addPlayer(playerToCreate)).thenReturn(validPlayer);
		
		// then
		ResponseEntity<Player> actual = controller.addPlayer(playerToCreate);
		assertEquals(expected, actual); // junit assertion
		
		verify(playerService).addPlayer(playerToCreate);
	}
	
	@Test
	public void getPlayerByIdTest() {
		
		// Given 
		ResponseEntity<Optional<Player>> expected = ResponseEntity.status(HttpStatus.OK)
				  .body(Optional.of(validPlayer));
		
		// When
		when(playerService.getById(1L)).thenReturn(Optional.of(validPlayer));
		
		// then
		ResponseEntity<Optional<Player>> actual = controller.getById(1L);
		assertEquals(expected, actual);
		
		verify(playerService, times(1)).getById(1L);
	}
	
	@Test
	public void updatePlayerTest() {
		
		// Given
		Player updatedPlayer = new Player(1L, "shuayb", "h", "midfielder", 0, 0);
//		Player savedPlayer = new Player(1L, "shuayb", "h", "attacker", 0, 0);
		Long playerId = updatedPlayer.getId();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/player/" + String.valueOf(playerId));
		
		// when 
		when(playerService.updatePlayer(playerId, updatedPlayer)).thenReturn(updatedPlayer);
		ResponseEntity<Player> expected = new ResponseEntity<Player>(updatedPlayer, headers, HttpStatus.ACCEPTED);
		ResponseEntity<Player> actual = controller.updatePlayer(playerId, updatedPlayer);
		
		// then
		assertEquals(expected, actual);
		verify(playerService).updatePlayer(playerId, updatedPlayer);
	}
	
	@Test
	public void deletePlayerTest() {
		// Given
		long PlayerId = 1;
		ResponseEntity<?> expected = ResponseEntity.accepted().build();
		ResponseEntity<?> actual = controller.deletePlayer(PlayerId);
		
		//then
		assertEquals(expected, actual);
		verify(playerService).deletePlayer(PlayerId);
	}
	
	@Test
	public void getbyPositionTest() {
		
		// given 
		
		String position = "midfielder";
		
		// when
		
		when(playerService.getByPosition(position)).thenReturn(midfielders);
		ResponseEntity<List<Player>> expected = new ResponseEntity<List<Player>>(midfielders, HttpStatus.OK);
		ResponseEntity<List<Player>> actual = controller.getByPosition(position);
		
		// then
		
		assertEquals(expected, actual);
		verify(playerService).getByPosition(position);
		
		
		
	}
	
	
}
