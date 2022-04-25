package bootcamp.reto.favoritos.favoritos.services;

import bootcamp.reto.favoritos.favoritos.models.Favourite;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FavouriteService {

  Flux<Favourite> findAll();

  Mono<Favourite> save(Favourite favourite);
}
