package com.isilbolatbas.covid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isilbolatbas.covid.model.Haber;
import com.isilbolatbas.covid.repository.*;

@Service
public class HaberService implements IHaberService {

	@Autowired
	private HaberRepository haberRepo;

	public List<Haber> findAll() {

		List<Haber> haberler = haberRepo.findAll();
		return haberler;
	}

	public void saveHaber(Haber haber) {

		haberRepo.save(haber);
	}

}
