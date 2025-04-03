package com.jaydeep.cricketDashboard.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaydeep.cricketDashboard.model.Player;
import com.jaydeep.cricketDashboard.model.Statistics;
import com.jaydeep.cricketDashboard.repository.PlayerRepository;

@Service
public class PlayerService {
	@Autowired
	PlayerRepository repository;

	public Player addPlayer(Player player) {
		return (repository.save(player));
	}

	public List<Player> allPlayers() {
		List<Player> allPlayers = (List<Player>) repository.findAll();
		return allPlayers;
	}

	public List<Player> getPlayerByName(String name) {
		List<Player> playerList = repository.findByNameLike(name);
		return playerList;
	}

	public List<Player> getPlayerByTeam(String team) {
		List<Player> playerList = repository.findByTeam(team);

		return playerList;
	}

	public List<Player> getPlayerByNameAndTeam(String name, String team) {
		List<Player> playerList = repository.findByNameAndTeam(name, team);

		return playerList;
	}

	public List<Statistics> getPlayerByStats(String name) {
		List<Player> playerList = repository.findByNameLike("%" + name + "%");
		List<Statistics> statList = new ArrayList<>();
		for (Player p : playerList) {
			statList.add(p.getStatistics());
		}
		return statList;
	}

}
