package bootcamp.reto.favoritos.favoritos.routers;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import bootcamp.reto.favoritos.favoritos.handlers.FavouriteHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfiguration {

  @Bean
  public RouterFunction<ServerResponse> favouriteRoutes(FavouriteHandler favouriteHandler) {
    return RouterFunctions.nest(RequestPredicates.path("/favourites"),
        RouterFunctions.route(GET(""), favouriteHandler::findAll)
            .andRoute(POST("").and(accept(APPLICATION_JSON)), favouriteHandler::save)
    );
  }

}
