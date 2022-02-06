package com.qa.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.app.data.entity.Stats;
import com.qa.app.service.StatsService;



@RestController
@RequestMapping("/stats")
public class StatsController {

	private StatsService statsService;

	public StatsController(StatsService statsService) {
		super();
		this.statsService = statsService;
	}
	
	
	@GetMapping
	public ResponseEntity<List<Stats>> getStats(){
		
		ResponseEntity<List<Stats>> stats = ResponseEntity.ok(statsService.getAll());
		return stats;
		
	}
	
	
	@PostMapping
	public ResponseEntity<Stats> createStat(@Valid @RequestBody Stats stats) {
		
		Stats newStat = statsService.create(stats);
				
		HttpHeaders headers = new HttpHeaders();
		
		headers.add("Location", "/stats/" + String.valueOf(newStat.getId()));
				
		ResponseEntity<Stats> response = new ResponseEntity<Stats>(newStat, headers, HttpStatus.CREATED);
		
		return response;
	}
	
	
}


