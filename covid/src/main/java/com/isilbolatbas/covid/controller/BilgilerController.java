package com.isilbolatbas.covid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.isilbolatbas.covid.model.*;
import com.isilbolatbas.covid.service.BilgilerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@Api(value = "Haberlerin parse islemlerinden sonra elde edilen verilerin bulundugu api dokumantasyonu")
public class BilgilerController {

	@Autowired
	private BilgilerService bilgiService;


	public BilgilerController(BilgilerService bilgiService) {
		this.bilgiService = bilgiService;
	}
	
	public BilgilerController() {}

	@GetMapping("/api/v1/bilgi")
	@ApiOperation(value = "Bilgileri listeleme apisi")
	public List<Bilgiler> getHaber() {

		List<Bilgiler> bilgiler = bilgiService.findAll();
		return bilgiler;
	}

	@GetMapping("/api/v1/bilgiToplam")
	@ApiOperation(value = "Haberle ilgili bilgilerin türkiye genelinde toplam vaka, toplam taburcu ve toplam vefat sayısını getirien api")
	public List<Result> total() {
		return bilgiService.total();
	}

	@GetMapping("/api/v1/toplamSehir")
	@ApiOperation(value = "Sehirlere göre haberlerden alinan toplam vaka, toplam taburcu ve toplam vefat sayisini getiren api")
	public List<ResultByCity> totalByCity() {
		return bilgiService.totalByCity();
	}

	@GetMapping("/api/v1/byDate/{tarih}")
	@ApiOperation(value = "Daha once var olan haberlerden gunluk olarak haberlerin vaka, taburcu ve vefat sayisini getiren api")
	public List<Bilgiler> findByDate(@PathVariable String tarih) {
		return bilgiService.findByDate(tarih);
	}

}
