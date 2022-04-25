package bootcamp.reto.pagoservicios.routes;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import bootcamp.reto.pagoservicios.handlers.UtilityHandler;
import bootcamp.reto.pagoservicios.handlers.TransactionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfiguration {

  @Bean
  public RouterFunction<ServerResponse> serviceRoutes(UtilityHandler utilityHandler) {
    return RouterFunctions.nest(RequestPredicates.path("/utility"),
        RouterFunctions.route(GET(""), utilityHandler::findAll)
            .andRoute(GET("/channel/{channel}"), utilityHandler::findChannel)
            .andRoute(POST("").and(accept(APPLICATION_JSON)), utilityHandler::save)
    );
  }

  @Bean
  public RouterFunction<ServerResponse> transactionRoutes(TransactionHandler transactionHandler) {
    return RouterFunctions.nest(RequestPredicates.path("/payments"),
        RouterFunctions.route(GET(""), transactionHandler::findAll)
            .andRoute(POST("").and(accept(APPLICATION_JSON)), transactionHandler::save)
    );
  }


}
