package com.isilbolatbas.covid.service;

import java.util.List;

import com.isilbolatbas.covid.model.*;


public interface IBilgilerService {
	
	public List<Bilgiler> findAll();
	public void saveBilgi(Bilgiler bilgiler);
	public List<Result> total();
	public List<ResultByCity> totalByCity();
	public List<Bilgiler> findByDate(String date);
	
	public ResultByTarih totalByTarih(String tarih);
	
	
	
}
