package bootcamp.reto.favoritos.favoritos.handlers;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import bootcamp.reto.favoritos.favoritos.models.Favourite;
import bootcamp.reto.favoritos.favoritos.services.FavouriteService;
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

  public Mono<ServerResponse> findAll(ServerRequest request) {
    return ok().contentType(APPLICATION_JSON)
        .body(favouriteService.findAll(), Favourite.class);
  }

  public Mono<ServerResponse> save(ServerRequest request) {
    return request.bodyToMono(Favourite.class)
        .flatMap(this.favouriteService::save)
        .flatMap(favourite -> ServerResponse.ok().body(Mono.just(favourite), Favourite.class));
  }

}
