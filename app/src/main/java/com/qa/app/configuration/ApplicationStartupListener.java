package com.qa.app.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.qa.app.data.entity.Player;
import com.qa.app.data.repository.PlayerRepository;


@Profile("dev")
@Configuration
public class ApplicationStartupListener implements ApplicationListener<ApplicationReadyEvent> {

	private PlayerRepository playerRepository;
	
	@Autowired // dependency injection
	public ApplicationStartupListener(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}
	
	// The application has booted and its components are ready to server
	// content when this method fires
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		playerRepository.saveAll(List.of(
				new Player("Liban", "D", "Attacker"),
				new Player("Jamaal", "D", "Midfielder"),
				new Player("Abdi", "E", "Midfielder"),
				new Player("Shuayb", "D", "Defender"),
				new Player("Hasan", "D", "Goalkeeper"),
				new Player("Ali", "T", "Midfielder"),
				new Player("Mo", "A", "Attacker"),
				new Player("Ibrahim", "D", "Defender"),
				new Player("Anas", "E", "Midfielder"),
				new Player("Sadaq", "D", "Attacker"),
				new Player("Mo", "D", "Defender"),
				new Player("Ahmed", "E", "Goalkeeper"),
				new Player("Harun", "D", "Attacker"),
				new Player("Hus", "D", "Midfielder")
				
		));
	}

}
