package br.com.washington.api.wars.api_wars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.washington.api.wars.api_wars.document.Planeta;
import br.com.washington.api.wars.api_wars.repository.PlanetaRepository;
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
		return planetaRepository.save(planeta);
	}

	@Override
	public Mono<Void> remove(Planeta planeta) {
		return planetaRepository.delete(planeta);
	}

}
