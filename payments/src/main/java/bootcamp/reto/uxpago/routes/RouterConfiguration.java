package bootcamp.reto.uxpago.routes;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;

import bootcamp.reto.uxpago.handlers.FavouriteHandler;
import bootcamp.reto.uxpago.handlers.UtilityHandler;
import bootcamp.reto.uxpago.handlers.TransactionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfiguration {

  @Bean
  public RouterFunction<ServerResponse> utilityRoutes(UtilityHandler utilityHandler) {
    return RouterFunctions.nest(RequestPredicates.path("/utility"),
        RouterFunctions
            .route(GET("/{channel}"), utilityHandler::findByChannel)
    );
  }

  @Bean
  public RouterFunction<ServerResponse> transactionRoutes(TransactionHandler transactionHandler) {
    return RouterFunctions.nest(RequestPredicates.path("/payment"),
        RouterFunctions
            .route(POST("").and(contentType(APPLICATION_JSON)), transactionHandler::save)
    );
  }

  @Bean
  public RouterFunction<ServerResponse> favouriteRoutes(FavouriteHandler favouriteHandler) {
    return RouterFunctions.nest(RequestPredicates.path("/favourite"),
        RouterFunctions
            .route(POST("").and(contentType(APPLICATION_JSON)), favouriteHandler::save)
    );
  }


}
