package bootcamp.reto.uxpago.services;

import bootcamp.reto.uxpago.models.Favourite;
import reactor.core.publisher.Mono;

public interface FavouriteService {

  Mono<Favourite> save(Favourite favourite, String token);
}
