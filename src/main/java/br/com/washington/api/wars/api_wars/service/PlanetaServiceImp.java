package br.com.washington.api.wars.api_wars.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.washington.api.wars.api_wars.document.Planeta;
import br.com.washington.api.wars.api_wars.document.Planets;
import br.com.washington.api.wars.api_wars.document.Result;
import br.com.washington.api.wars.api_wars.repository.PlanetaRepository;
import br.com.washington.api.wars.api_wars.util.BusinessException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlanetaServiceImp implements PlanetaService {

	@Autowired
	PlanetaRepository planetaRepository;

	@Override
	public Flux<Planeta> findAll() {
		return planetaRepository.findAll();
	}

	@Override
	public Mono<Planeta> findById(String id) {
		return planetaRepository.findById(id);
	}

	@Override
	public Mono<Planeta> findByName(String nome) {
		return planetaRepository.findByNome(nome);
	}

	@Override
	public Mono<Planeta> save(Planeta planeta) {
		List<Result> result;
		try {			
			result = consumirStarWars().getResults();
			
			for (Result result2 : result) {
				if (result2.getName().equalsIgnoreCase(planeta.getNome())) {
					planeta.setTotalAparicoes(result2.getFilms().size());
				}
			}
		} catch (Exception ex) {
			ex.addSuppressed(new BusinessException(ex.getMessage(), "STAR_500", "Erro ao salvar planeta"));
		}

		return planetaRepository.save(planeta);
	}

	@Override
	public Mono<Void> remove(String id) {
		return planetaRepository.deleteById(id);
	}

	@Override
	public List<Result> findAllListPlanets() throws IOException, BusinessException {
		return consumirStarWars().getResults();
	}

	public Planets consumirStarWars() throws IOException, BusinessException {

		try {
			List<Result> list = new ArrayList<>();
			String url_next = "https://swapi.co/api/planets/?page=";

			ResponseEntity<Planets> response = restTemplate(url_next, list);
			long pagination = response.getBody().getCount();

			for (int i = 0; i < (pagination / 10); i++) {
				if (!response.getBody().getNext().equalsIgnoreCase(null)) {
					url_next = "https://swapi.co/api/planets/?page=";
					url_next = (url_next + String.valueOf(i + 2));
					restTemplate(url_next, list);
				}
			}

			response.getBody().setResults(list);
			return response.getBody();
		} catch (Exception ex) {
			throw new BusinessException(ex.getMessage(), "STAR_500", "Erro ao consultar SWAPI - The Star Wars API");
		}
	}

	private ResponseEntity<Planets> restTemplate(String url_next, List<Result> list) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<Planets> response = restTemplate.exchange(url_next, HttpMethod.GET, entity, Planets.class);

		list.addAll(response.getBody().getResults());
		System.out.println(url_next);
		return response;
	}

}
