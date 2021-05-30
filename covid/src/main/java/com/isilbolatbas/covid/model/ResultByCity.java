package com.isilbolatbas.covid.model;

public class ResultByCity {
	
	private String _id;
	private Integer toplamVaka;
	private Integer toplamTaburcu;
	private Integer toplamVefat;
	
	public ResultByCity() {
	}

	public ResultByCity(String city, Integer toplamVaka, Integer toplamTaburcu, Integer toplamVefat) {
		this._id = city;
		this.toplamTaburcu = toplamTaburcu;
		this.toplamVaka = toplamVaka;
		this.toplamVefat = toplamVefat;
	}


	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
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
