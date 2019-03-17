package br.com.washington.api.wars.api_wars.service;

import br.com.washington.api.wars.api_wars.document.Planeta;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlanetaService {

	// Listar planetas do banco de dados
	Flux<Planeta> findAll();

	// Buscar por ID no banco de dados
	Mono<Planeta> findById(String id);

	// Buscar por nome no banco de dados
	Mono<Planeta> findByName(String nome);

	//Adicionar um planeta (com nome, clima e terreno)
	Mono<Planeta> save(Planeta planeta);
	
	//Remover planeta
	Mono<Void> remove(Planeta planeta);
}
