package com.qa.app.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qa.app.data.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{
	
	@Query("select player from Player player where player.position = :position")
	List<Player> findByPosition(@Param("position") String position);

}
