package com.qa.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.app.data.entity.Stats;
import com.qa.app.data.repository.StatsRepository;

@Service
public class StatsService {

	
	private StatsRepository statsRepository;

	
	@Autowired
	public StatsService(StatsRepository statsRepository) {
		super();
		this.statsRepository = statsRepository;
	}
	
	
	public List<Stats> getAll(){
		
		return statsRepository.findAll();
	
	}
	
	public Stats create(Stats stats) {
		
		return statsRepository.save(stats);
	}
	
	
}
