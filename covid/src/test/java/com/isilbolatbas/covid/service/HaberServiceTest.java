package com.isilbolatbas.covid.service;

import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.isilbolatbas.covid.model.Haber;
import com.isilbolatbas.covid.repository.HaberRepository;
import com.isilbolatbas.covid.service.HaberService;
import com.isilbolatbas.covid.service.IHaberService;

@RunWith(SpringRunner.class)
public class HaberServiceTest {

	@TestConfiguration
	static class StudentServiceImplTestContextConfiguration {
		@Bean
		public IHaberService studentService() {
			return new HaberService();
		}
	}

	@Autowired
	private HaberService haberService;

	@MockBean
	private HaberRepository haberRepository;

	private Haber firstNews;
	private Haber secondNews;

	private final ObjectId firstId = new ObjectId();
	private final ObjectId secondId = new ObjectId();

	private final List<Haber> news = new ArrayList<>();

	@Before
	public void setup() {
		firstNews = new Haber();
		firstNews.set_id(firstId);
		firstNews.setText("test haber");

		secondNews = new Haber();
		secondNews.set_id(secondId);
		secondNews.setText("test haber iki");

		news.add(firstNews);
		news.add(secondNews);

		Mockito.when(haberRepository.findAll()).thenReturn(news);

		Mockito.when(haberRepository.save(firstNews)).thenReturn(firstNews);
	}

	@Test
	public void testFindAll_thenStudentListShouldBeReturned() {
		List<Haber> foundStudents = haberService.findAll();

		assertNotNull(foundStudents);
		assertEquals(2, foundStudents.size());
	}

	@Test
	public void testSaveOrUpdateStudent_thenStudentShouldBeReturned() {
		Haber found = haberRepository.save(firstNews);

		assertNotNull(found);
		assertEquals(firstNews.get_id(), found.get_id());
		assertEquals(firstNews.getText(), found.getText());

	}
}
