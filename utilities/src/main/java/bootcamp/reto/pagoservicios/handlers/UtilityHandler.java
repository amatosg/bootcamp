package bootcamp.reto.pagoservicios.handlers;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import bootcamp.reto.pagoservicios.models.Utility;
import bootcamp.reto.pagoservicios.services.UtilityService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class UtilityHandler {

  private final UtilityService utilityService;

  public UtilityHandler(UtilityService utilityService) {
    this.utilityService = utilityService;
  }

  public Mono<ServerResponse> findAll(ServerRequest request) {
    return ok().contentType(APPLICATION_JSON)
        .body(utilityService.findAll(), Utility.class);
  }

  public Mono<ServerResponse> save(ServerRequest request) {

    return request.bodyToMono(Utility.class)
        .flatMap(this.utilityService::save)
        .flatMap(utility -> ServerResponse.ok().body(Mono.just(utility), Utility.class));
  }

  public Mono<ServerResponse> findChannel(ServerRequest request) {
    var canal = request.pathVariable("channel");
    return ServerResponse.ok()
        .contentType(APPLICATION_JSON)
        .body(utilityService.findByChannel(canal), Utility.class);

  }
}
