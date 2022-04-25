package bootcamp.reto.uxpago.repositories;

import bootcamp.reto.uxpago.models.Utility;
import reactor.core.publisher.Flux;

public interface UtilityRepository {

  Flux<Utility> findByChannel(String channel, String token);

}
