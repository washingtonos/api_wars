package br.com.washington.api.wars.api_wars;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class PlanetaRouter {

	@Bean
	public RouterFunction<ServerResponse> route(PlanetaHandler handler) {
		return RouterFunctions.route(GET("/planetas").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
				.andRoute(GET("/planeta/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::findById)
				.andRoute(GET("/planeta/name/{nome}").and(accept(MediaType.APPLICATION_JSON)), handler::findByName)
				.andRoute(POST("/planeta").and(accept(MediaType.APPLICATION_JSON)), handler::save)
				.andRoute(DELETE("/planeta/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::delete);
	}
}
