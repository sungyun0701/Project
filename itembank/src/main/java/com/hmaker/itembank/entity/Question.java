package com.hmaker.itembank.entity;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table
public class Question {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String question;
	private String answer;
	private String kind;
	private String etc;
	@Lob
	private byte[] photo;
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Question(Long id, String question, String answer, String kind, String etc, byte[] photo) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.kind = kind;
		this.etc = etc;
		this.photo = photo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", answer=" + answer + ", kind=" + kind + ", etc="
				+ etc + ", photo=" + Arrays.toString(photo) + "]";
	}
	
	
}
