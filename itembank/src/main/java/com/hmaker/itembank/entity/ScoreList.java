package com.hmaker.itembank.entity;


public class ScoreList {

	private String username;
	private String capitalScore;
	private String triviaScore;
	private String proverbScore;
	private String nonsenseScore;
	private byte[] photo;
	public ScoreList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ScoreList(String username, String capitalScore, String triviaScore, String proverbScore,
			String nonsenseScore, byte[] photo) {
		super();
		this.username = username;
		this.capitalScore = capitalScore;
		this.triviaScore = triviaScore;
		this.proverbScore = proverbScore;
		this.nonsenseScore = nonsenseScore;
		this.photo = photo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCapitalScore() {
		return capitalScore;
	}
	public void setCapitalScore(String capitalScore) {
		this.capitalScore = capitalScore;
	}
	public String getTriviaScore() {
		return triviaScore;
	}
	public void setTriviaScore(String triviaScore) {
		this.triviaScore = triviaScore;
	}
	public String getProverbScore() {
		return proverbScore;
	}
	public void setProverbScore(String proverbScore) {
		this.proverbScore = proverbScore;
	}
	public String getNonsenseScore() {
		return nonsenseScore;
	}
	public void setNonsenseScore(String nonsenseScore) {
		this.nonsenseScore = nonsenseScore;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
}
