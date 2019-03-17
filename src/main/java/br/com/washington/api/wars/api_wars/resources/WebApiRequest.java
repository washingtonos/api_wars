package br.com.washington.api.wars.api_wars.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.washington.api.wars.api_wars.document.Planets;

@Component
public class WebApiRequest {

	public void consumerApiIP() {

		RestTemplate restTemplate = new RestTemplate();

		UriComponents uri = UriComponentsBuilder.newInstance().scheme("https").host("swapi.co/api").path("/planets")
				.build();

		String[] str = restTemplate.getForObject(uri.toString(), String[].class);
	//	Planets[] planets = restTemplate.getForObject(uri.toString(), Planets[].class);
		
		//ResponseEntity<Planets> entity = restTemplate.getForEntity(uri.toString(), Planets.class);
		
		System.out.println(str.toString());

	}
}
