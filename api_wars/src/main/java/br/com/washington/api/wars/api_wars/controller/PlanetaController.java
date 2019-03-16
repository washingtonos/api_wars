package br.com.washington.api.wars.api_wars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.washington.api.wars.api_wars.document.Planeta;
import br.com.washington.api.wars.api_wars.service.PlanetaService;
import reactor.core.publisher.Flux;

@RestController
public class PlanetaController {

	@Autowired
	PlanetaService planetaService;

	@GetMapping(value="/planetas")
	public Flux<Planeta> getAllPlaneta(){
		return planetaService.findAll();
	}

	
}
