package bootcamp.reto.uxpago.services;

import bootcamp.reto.uxpago.models.Utility;
import reactor.core.publisher.Flux;

public interface UtilityService {

  Flux<Utility> findByChannel(String canalPermitido, String token);
}
