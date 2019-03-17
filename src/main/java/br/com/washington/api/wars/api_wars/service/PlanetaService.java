package br.com.washington.api.wars.api_wars.service;

import java.io.IOException;
import java.util.List;

import br.com.washington.api.wars.api_wars.document.Planeta;
import br.com.washington.api.wars.api_wars.document.Result;
import br.com.washington.api.wars.api_wars.util.BusinessException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlanetaService {

	// Listar planetas do banco de dados
	Flux<Planeta> findAll();

	// Buscar por ID no banco de dados
	Mono<Planeta> findById(String id);

	// Buscar por nome no banco de dados
	Mono<Planeta> findByName(String nome);

	// Adicionar um planeta (com nome, clima e terreno)
	Mono<Planeta> save(Planeta planeta);

	// Remover planeta
	Mono<Void> remove(String id);

	//Listar planetas da API do Star Wars
	List<Result> findAllListPlanets() throws IOException, BusinessException;
}
