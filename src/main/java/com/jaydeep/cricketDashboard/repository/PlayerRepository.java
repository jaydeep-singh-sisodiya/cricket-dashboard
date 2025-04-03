package com.jaydeep.cricketDashboard.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jaydeep.cricketDashboard.model.Player;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
	public List<Player> findByNameLike(String name);

	public List<Player> findByTeam(String team);

	public List<Player> findByNameAndTeam(String Name, String team);
}
