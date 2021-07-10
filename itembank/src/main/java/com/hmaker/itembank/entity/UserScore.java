package com.hmaker.itembank.entity;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_score")
public class UserScore {

	@Id
	private String username;
	private int capital;
	private int trivia;
	private int proverb;
	private int nonsense;
	private double aver;
	private int total;
	public UserScore() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserScore(String username, int capital, int trivia, int proverb, int nonsense, double aver, int total) {
		super();
		this.username = username;
		this.capital = capital;
		this.trivia = trivia;
		this.proverb = proverb;
		this.nonsense = nonsense;
		this.aver = aver;
		this.total = total;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getCapital() {
		return capital;
	}
	public void setCapital(int capital) {
		this.capital = capital;
	}
	public int getTrivia() {
		return trivia;
	}
	public void setTrivia(int trivia) {
		this.trivia = trivia;
	}
	public int getProverb() {
		return proverb;
	}
	public void setProverb(int proverb) {
		this.proverb = proverb;
	}
	public int getNonsense() {
		return nonsense;
	}
	public void setNonsense(int nonsense) {
		this.nonsense = nonsense;
	}
	public double getAver() {
		return aver;
	}
	public void setAver(double aver) {
		this.aver = aver;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "UserScore [username=" + username + ", capital=" + capital + ", trivia=" + trivia + ", proverb="
				+ proverb + ", nonsense=" + nonsense + ", aver=" + aver + ", total=" + total + "]";
	}
	
	
	
}