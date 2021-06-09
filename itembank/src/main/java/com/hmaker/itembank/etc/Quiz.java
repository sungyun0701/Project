package com.hmaker.itembank.etc;

public class Quiz {

	private String question;
	private String answer;
	private int cnt;

	
	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Quiz(String question, String answer, int cnt) {
		super();
		this.question = question;
		this.answer = answer;
		this.cnt = cnt;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public int getCnt() {
		return cnt;
	}


	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	
	
}
