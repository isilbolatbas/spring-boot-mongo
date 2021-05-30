package com.isilbolatbas.covid.controller;

import java.util.Arrays;
import java.util.List;
import java.util.regex.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.isilbolatbas.covid.model.Bilgiler;
import com.isilbolatbas.covid.model.Haber;
import com.isilbolatbas.covid.service.BilgilerService;
import com.isilbolatbas.covid.service.HaberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@Api(value = "Post request haberlerin parseing islemlerinin bulundugu api dokumantasyonu")
public class HaberController {

	int vaka = 0;
	int taburcu = 0;
	int vefat = 0;
	String tarih = null;
	String sehir = null;
	String[] sehirler = { "Ankara", "İstanbul", "İzmir", "Çorum", "İzmit", "Aydın", "Adana", "Adıyaman", "Afyonkarahisar", "Antalya", "Artvin" ,
			"Ağrı", "Amasya", "Aydın", "Balıkesir", "Bilecik", "Bingöl", "Bitlis", "Bolu", "Burdur", "Bursa", "Çanakkale","Çankırı", "Çorum",
			"Denizli", "Diyarbakır", "Edirne", "Elazığ", "Erzincan", "Erzurum", "Eskişehir", "Gaziantep", "Gümüşhane", "Hakkari","Hatay", "Isparta",
			"Mersin", "Kars", "Kastamonu", "Kayseri" ,"Kırklareli" ,"Kırşehir", "Kocaeli" , "Konya", "Kütahya", "Malatya", "Manisa", "Kahramanmaraş",
			"Mardin", "Muğla", "Muş" ,"Nevşehir", "Niğde", "Ordu", "Rize", "Sakarya", "Samsun", "Siirt", "Sinop", "Sivas" ,"Tekirdağ",
			"Tokat", "Trabzon", "Tunceli", "Şanlıurfa", "Uşak", "Van", "Yozgat", "Zonguldak", "Aksaray", "Bayburt", "Karaman", "Kırıkkale",
			"Batman", "Şırnak", "Bartın", "Ardahan", "Iğdır", "Yalova", "Karabük", "Kilis", "Osmaniye", "Düzce"
			
	};

	@Autowired
	private HaberService haberService;

	@Autowired
	private BilgilerService bilgiService;

	@GetMapping("/api/v1/haber")
	@ApiOperation(value = "Haberlerin tumunu gosteren api")
	public List<Haber> getHaber() {
		List<Haber> haberler = haberService.findAll();
		return haberler;
	}

	@PostMapping("/api/v1/haber")
	@ApiOperation(value = "Post request haberlerin parse islemleri")
	public void saveHaber(@RequestBody Haber haber) {

		haberService.saveHaber(haber);

		String[] sentences = haber.getText().split("(?<=[.!?])\\s* ");

		for (String s : sentences) {

			System.out.println(s);

			String regex = "\\d{2}(\\.|-)\\d{2}(\\.|-)\\d{4}";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(s);
			if (matcher.find()) {
				System.out.println("tarih:" + matcher.group());
				tarih = matcher.group();
			} else {
				System.out.println("tarih bulunamadı.");

			}

			String[] splitedSentences = s.split("\\b+");

			if (Arrays.asList(splitedSentences).contains("vaka")) {

				int vakaSayisi = Integer.parseInt(s.replaceAll("[^0-9]", ""));

				System.out.println("Vaka sayisi:" + vakaSayisi);
				vaka = vakaSayisi;
			} else if (Arrays.asList(splitedSentences).contains("taburcu")) {
				int taburcuSayisi = Integer.parseInt(s.replaceAll("[^0-9]", ""));
				System.out.println("taburcu sayisi:" + taburcuSayisi);
				taburcu = taburcuSayisi;

			} else if (Arrays.asList(splitedSentences).contains("vefat")) {
				int vefatSayisi = Integer.parseInt(s.replaceAll("[^0-9]", ""));
				System.out.println("vefat sayisi:" + vefatSayisi);
				vefat = vefatSayisi;
			}
			for (int i = 0; i < sehirler.length; i++) {
				if (Arrays.asList(splitedSentences).contains(sehirler[i])) {
					System.out.println("sehir:" + sehirler[i]);
					sehir = sehirler[i];
				}
			}
		}

		Bilgiler bilgi = new Bilgiler(tarih, sehir, vaka, vefat, taburcu);
		bilgiService.saveBilgi(bilgi);

	}

}
