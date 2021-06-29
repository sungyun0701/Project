package com.hmaker.itembank.etc;

public class Calc {

	//데이터와 데이터를 조작하는 기능
	
	//필드 <== 데이터
	private int value1;
	private int value2;
	private double result;
	
	
	// 기본 생성자 : 인수가 없다.
	public Calc() {
		System.out.println("기본 생성자 호출됨");
	}

	//다중 정의 생성자(메소드)는 오브젝트를 생성할 때 먼저 호출된다 (리턴형이 없음)
	public Calc(int value1, int value2) {
		this.value1 = value1;
		this.value2 = value2;
		System.out.println("다중정의 생성자 호출됨");
	}
	
	//메소드 <== 기능
	public void plus()  {
		this.result = (double)this.value1 + (double)this.value2;
	}
	
	public void minus()  {
		this.result = (double)this.value1 - (double)this.value2;
	}
	
	public void multiply()  {
		this.result = this.value1 * this.value2;
	}
	
	public void divide()  {
		this.result = this.value1 / this.value2;
	}

	public int getValue1() {
		return value1;
	}

	public void setValue1(int value1) {
		this.value1 = value1;
	}

	public int getValue2() {
		return value2;
	}

	public void setValue2(int value2) {
		this.value2 = value2;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}
	
	
}
