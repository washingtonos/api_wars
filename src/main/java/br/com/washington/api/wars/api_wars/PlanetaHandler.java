package br.com.washington.api.wars.api_wars;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import br.com.washington.api.wars.api_wars.document.Planeta;
import br.com.washington.api.wars.api_wars.document.Result;
import br.com.washington.api.wars.api_wars.service.PlanetaService;
import br.com.washington.api.wars.api_wars.util.BusinessException;
import reactor.core.publisher.Mono;

@Component
public class PlanetaHandler {

	@Autowired
	PlanetaService planetaService;

	public Mono<ServerResponse> findAll(ServerRequest request) {
		return ok().contentType(MediaType.APPLICATION_JSON).body(planetaService.findAll(), Planeta.class);
	}

	public Mono<ServerResponse> findById(ServerRequest request) {
		String id = request.pathVariable("id");
		return ok().contentType(MediaType.APPLICATION_JSON).body(planetaService.findById(id), Planeta.class);
	}

	public Mono<ServerResponse> findByName(ServerRequest request) {
		String nome = request.pathVariable("nome");
		return ok().contentType(MediaType.APPLICATION_JSON).body(planetaService.findByName(nome), Planeta.class);
	}

	public Mono<ServerResponse> save(ServerRequest request) throws IOException, BusinessException{
		final Mono<Planeta> planeta = request.bodyToMono(Planeta.class);
			return ok().contentType(MediaType.APPLICATION_JSON)
					.body(fromPublisher(planeta.flatMap(planetaService::save), Planeta.class));
			
	}

	public Mono<ServerResponse> delete(ServerRequest request) {
		String id = request.pathVariable("id");
		return planetaService.findById(id)
				.flatMap(p -> ok().contentType(MediaType.APPLICATION_JSON).build(planetaService.remove(id)))
				.switchIfEmpty(notFound().build());
	}

	public Mono<ServerResponse> findAllListApiPlanets(ServerRequest request) {
		List<Result> result;
		try {
			result = planetaService.findAllListPlanets();
			return ok().contentType(MediaType.APPLICATION_JSON).syncBody(result);

		} catch (IOException | BusinessException ex) {
			new BusinessException(ex.getMessage(), "STAR_500", "Erro ao consultar SWAPI - The Star Wars API");
		}
		return null;
	}

}
