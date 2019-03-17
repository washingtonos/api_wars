package br.com.washington.api.wars.api_wars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.washington.api.wars.api_wars.document.Planeta;
import br.com.washington.api.wars.api_wars.service.PlanetaService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PlanetaController {

	@Autowired
	PlanetaService planetaService;

	@GetMapping(value = "/planetas")
	public Flux<Planeta> getAllListPlaneta() {
		return planetaService.findAll();
	}

	@GetMapping(value = "/planeta/{id}")
	public Mono<Planeta> getListPlanetaId(@PathVariable String id) {
		return planetaService.findById(id);
	}

	@GetMapping(value = "/planeta/{nome}")
	public Mono<Planeta> getListPlanetaNome(@PathVariable String nome) {
		return planetaService.findByName(nome);
	}
	
	@PostMapping(value="/planeta")
	public Mono<Planeta> save(@RequestBody Planeta planeta){
		return planetaService.save(planeta);
	}
}
