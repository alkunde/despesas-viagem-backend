package br.ufpr.andrekunde.travelexpenses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableCaching
public class TravelexpensesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelexpensesApplication.class, args);
	}

	public Filter getCharacterEncodingFilter() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		encodingFilter.setForceEncoding(true);

		return encodingFilter;
	}
}
