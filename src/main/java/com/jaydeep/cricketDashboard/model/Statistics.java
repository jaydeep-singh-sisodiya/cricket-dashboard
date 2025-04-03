package com.jaydeep.cricketDashboard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Statistics {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int average;
	private int numberOfCatches;
	private int strikeRate;

	public Statistics() {
		super();
	}

	public int getAverage() {
		return average;
	}

	public void setAverage(int average) {
		this.average = average;
	}

	public int getNumberOfCatches() {
		return numberOfCatches;
	}

	public void setNumberOfCatches(int numberOfCatches) {
		this.numberOfCatches = numberOfCatches;
	}

	public int getStrikeRate() {
		return strikeRate;
	}

	public void setStrikeRate(int strikeRate) {
		this.strikeRate = strikeRate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
