package com.hmaker.itembank.etc;

public class Bmi {
	
	private double k;
	private double w;
	private double bmi;
	private String what;

	public Bmi(double k, double w) {
		this.k = k;
		this.w = w;
		calc();
		re();
	}
	
	public void calc() {
		this.bmi = this.w/this.k/this.k*100*100;
		this.bmi = Math.round((bmi*10000)/10000);
	}

	public void re() {
		if(this.bmi<18.5) {
			what = "저체중";
		}
		else if(this.bmi<23) {
			what = "정상";
		}
		else if(this.bmi<25) {
			what = "과체중";
		}
		else if(this.bmi<30) {
			what = "경도비만";
		}
		else {
			what = "비만";
		}
	}

	public double getK() {
		return k;
	}


	public double getW() {
		return w;
	}

	public double getBmi() {
		return bmi;
	}


	public String getWhat() {
		return what;
	}

	public void setK(double k) {
		this.k = k;
	}

	
	
}
