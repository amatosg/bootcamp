package bootcamp.reto.pagoservicios.repositories;

import bootcamp.reto.pagoservicios.models.Utility;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UtilityRepository extends ReactiveMongoRepository<Utility, String> {

  Flux<Utility> findByChannel(String channel);

}
