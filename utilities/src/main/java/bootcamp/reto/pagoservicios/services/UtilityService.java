package bootcamp.reto.pagoservicios.services;

import bootcamp.reto.pagoservicios.models.Utility;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface UtilityService {

  Flux<Utility> findAll();

  Flux<Utility> findByChannel(String canalPermitido);

  Mono<Utility> save(Utility utility);


}
