package com.isilbolatbas.covid.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.isilbolatbas.covid.model.Bilgiler;
import com.isilbolatbas.covid.model.Result;
import com.isilbolatbas.covid.model.ResultByCity;
import com.isilbolatbas.covid.model.ResultByTarih;
import com.isilbolatbas.covid.repository.BilgilerRepository;

@Service
public class BilgilerService implements IBilgilerService {

	@Autowired
	private BilgilerRepository bilgiRepo;

	@Autowired
	MongoTemplate mongoTemplate;
	
	public BilgilerService() {}

	public List<Bilgiler> findAll() {
		List<Bilgiler> bilgiler = bilgiRepo.findAll();
		return bilgiler;
	}

	public void saveBilgi(Bilgiler bilgiler) {

		bilgiRepo.save(bilgiler);

	}

	public List<Result> total() {
		return bilgiRepo.total();
	}

	public List<ResultByCity> totalByCity() {
		// TODO Auto-generated method stub
		return bilgiRepo.totalByCity();
	}

	public ResultByTarih totalByTarih(String tarih) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Bilgiler> findByDate(String date) {
		Query query = new Query();
		query.addCriteria(Criteria.where("tarih").is(date));
		return mongoTemplate.find(query, Bilgiler.class);
	}

	/*
	 * public ResultByTarih totalByTarih(String tarih) {
	 * 
	 * return bilgiRepo.totalByTarih(tarih); }
	 */

}
