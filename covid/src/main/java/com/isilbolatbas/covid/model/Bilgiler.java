package com.isilbolatbas.covid.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bilgiler")
public class Bilgiler {
	
	@Id
	public ObjectId _id;
	public String tarih;
	public String il;
	public Integer vaka;
	public Integer taburcu;
	public Integer vefat;
	
	public Bilgiler() {}

	public Bilgiler(String tarih, String il, Integer vaka, Integer taburcu, Integer vefat) {
		this.tarih = tarih;
		this.il = il;
		this.taburcu = taburcu;
		this.vefat = vefat;
		this.vaka = vaka;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getTarih() {
		return tarih;
	}

	public void setTarih(String tarih) {
		this.tarih = tarih;
	}

	public String getIl() {
		return il;
	}

	public void setIl(String il) {
		this.il = il;
	}

	public Integer getVaka() {
		return vaka;
	}

	public void setVaka(Integer vaka) {
		this.vaka = vaka;
	}

	public Integer getTaburcu() {
		return taburcu;
	}

	public void setTaburcu(Integer taburcu) {
		this.taburcu = taburcu;
	}

	public Integer getVefat() {
		return vefat;
	}

	public void setVefat(Integer vefat) {
		this.vefat = vefat;
	}
	
	

}
