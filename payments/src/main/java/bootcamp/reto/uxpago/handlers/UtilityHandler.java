package bootcamp.reto.uxpago.handlers;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import bootcamp.reto.uxpago.models.Utility;
import bootcamp.reto.uxpago.services.UtilityService;
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

  public Mono<ServerResponse> findByChannel(ServerRequest request) {

    var tokenHeader = request.headers().header("Authorization");
    String token = tokenHeader.get(0);

    var channel = request.pathVariable("channel");
    return ServerResponse
        .ok()
        .contentType(APPLICATION_JSON)
        .body(
            utilityService.findByChannel(channel, token),
            Utility.class
        );
  }
}
