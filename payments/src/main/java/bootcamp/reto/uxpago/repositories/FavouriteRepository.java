package bootcamp.reto.uxpago.repositories;

import bootcamp.reto.uxpago.models.Favourite;
import reactor.core.publisher.Mono;

public interface FavouriteRepository {

  Mono<Favourite> save(Favourite favourite, String token);
}
