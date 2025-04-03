package com.jaydeep.cricketDashboard.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jaydeep.cricketDashboard.model.Player;
import com.jaydeep.cricketDashboard.model.Statistics;
import com.jaydeep.cricketDashboard.services.PlayerService;

@RestController
public class PlayerController {

	@Autowired
	PlayerService playerService;

	@PostMapping("/players")
	public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
		Player savedPlayer = playerService.addPlayer(player);
		return ResponseEntity.ok().body(savedPlayer);
	}

	@GetMapping("/players")
	public ResponseEntity<?> getPlayers(@RequestParam(required = false) String name,
			@RequestParam(required = false) String team) {
		if (Objects.nonNull(name) && Objects.nonNull(team)) {
			List<Player> playersByNameAndTeam = playerService.getPlayerByNameAndTeam(name, team);
			if (playersByNameAndTeam.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT)
						.body("No player with the name " + name + " found in the tema " + team);
			}
			return ResponseEntity.ok().body(playersByNameAndTeam);
		}

		if (Objects.nonNull(name)) {
			List<Player> getPlayerByName = playerService.getPlayerByName(name);
			return ResponseEntity.ok().body(getPlayerByName);
		}
		if (Objects.nonNull(team)) {
			List<Player> getPlayerByTeam = playerService.getPlayerByTeam(team);
			return ResponseEntity.ok().body(getPlayerByTeam);
		}

		return ResponseEntity.ok().body(playerService.allPlayers());
	}

	@GetMapping("/players/{name}/stats")
	public ResponseEntity<List<Statistics>> getPlayerByStats(@PathVariable String name) {
		List<Statistics> playerStatistics = playerService.getPlayerByStats(name);
		return ResponseEntity.ok().body(playerStatistics);
	}

//	@GetMapping("/players")
//	public List<Player> getPlayerByName(@RequestParam String name){
//		return playerService.playerList(name);
//	}
//	
//	@GetMapping("/getplayerbyteam")
//	public List<Player> getPlayerByTeam(@RequestParam String team){
//		List<Player> playerList = playerService.getPlayerByTeam(team);
//		return playerList;
//	}
}
