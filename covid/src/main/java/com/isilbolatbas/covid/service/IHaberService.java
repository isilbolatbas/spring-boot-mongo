package com.isilbolatbas.covid.service;

import java.util.List;

import com.isilbolatbas.covid.model.Haber;


public interface IHaberService {
	
	public List<Haber> findAll();
	public void saveHaber(Haber haber);

}
