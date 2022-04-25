package bootcamp.reto.uxpago.handlers;

import bootcamp.reto.uxpago.models.Favourite;
import bootcamp.reto.uxpago.services.FavouriteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class FavouriteHandler {

  private final FavouriteService favouriteService;

  public FavouriteHandler(FavouriteService favouriteService) {
    this.favouriteService = favouriteService;
  }

  public Mono<ServerResponse> save(ServerRequest request) {
    var tokenHeader = request.headers().header("Authorization");
    String token = tokenHeader.get(0);
    return request.bodyToMono(Favourite.class)
        .flatMap(favourite -> this.favouriteService.save(favourite, token))
        .flatMap(favourite -> ServerResponse.ok().body(Mono.just(favourite), Favourite.class));
  }
}
