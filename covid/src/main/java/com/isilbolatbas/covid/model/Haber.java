package com.isilbolatbas.covid.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "haber")
public class Haber {

	@Id
	public ObjectId _id;
	public String text;

	public Haber() {}
	public Haber(ObjectId _id, String text) {
		this._id = _id;
		this.text = text;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
