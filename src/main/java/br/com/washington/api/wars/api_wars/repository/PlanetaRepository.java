package br.com.washington.api.wars.api_wars.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import br.com.washington.api.wars.api_wars.document.Planeta;
import reactor.core.publisher.Mono;

public interface PlanetaRepository extends ReactiveMongoRepository<Planeta, String> {

	Mono<Planeta> findByNome(String nome);

}
