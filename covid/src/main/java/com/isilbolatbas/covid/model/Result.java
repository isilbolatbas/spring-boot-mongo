package com.isilbolatbas.covid.model;

public class Result {

	private Integer toplamVaka;
	private Integer toplamTaburcu;
	private Integer toplamVefat;

	public Result() {
	}

	public Result(Integer toplamVaka, Integer toplamTaburcu, Integer toplamVefat) {
		this.toplamTaburcu = toplamTaburcu;
		this.toplamVaka = toplamVaka;
		this.toplamVefat = toplamVefat;
	}

	public Integer getToplamVaka() {
		return toplamVaka;
	}

	public void setToplamVaka(Integer toplamVaka) {
		this.toplamVaka = toplamVaka;
	}

	public Integer getToplamTaburcu() {
		return toplamTaburcu;
	}

	public void setToplamTaburcu(Integer toplamTaburcu) {
		this.toplamTaburcu = toplamTaburcu;
	}

	public Integer getToplamVefat() {
		return toplamVefat;
	}

	public void setToplamVefat(Integer toplamVefat) {
		this.toplamVefat = toplamVefat;
	}

}
