package com.jaydeep.cricketDashboard.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Player {
	
	public Player() {
		super();
	}
	@Id
	private String name;
	private String team;
	private int age;
	//stats
	private int runs;
	private int wickets;
	
	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="stats_id", referencedColumnName = "id")
	private Statistics statistics;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	
	
	
	
	public Statistics getStatistics() {
		return statistics;
	}
	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}
	@Override
	public String toString() {
		return "Player [name=" + name + ", age=" + age + ", runs=" + runs + ", wickets=" + wickets + "]";
	}
	
	
}
