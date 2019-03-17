package br.com.washington.api.wars.api_wars;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import br.com.washington.api.wars.api_wars.util.BusinessException;

@Configuration
public class PlanetaRouter {

	@Bean
	public RouterFunction<ServerResponse> route(PlanetaHandler handler) {
		return RouterFunctions.route(GET("/planetas").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
				.andRoute(GET("/planeta/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::findById)
				.andRoute(GET("/planeta/name/{nome}").and(accept(MediaType.APPLICATION_JSON)), handler::findByName)
				.andRoute(GET("/api/planetas").and(accept(MediaType.APPLICATION_JSON)), handler::findAllListApiPlanets)
				.andRoute(POST("/planeta").and(accept(MediaType.APPLICATION_JSON)), request -> {
					try {
						return handler.save(request);
					} catch (IOException | BusinessException e) {
						e.printStackTrace();
					}
					return null;
				})
				.andRoute(DELETE("/planeta/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::delete);
	}
}
