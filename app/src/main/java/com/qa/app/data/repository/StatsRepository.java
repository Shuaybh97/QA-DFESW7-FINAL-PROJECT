package com.qa.app.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.app.data.entity.Stats;

public interface StatsRepository extends JpaRepository<Stats, Long>{

}
