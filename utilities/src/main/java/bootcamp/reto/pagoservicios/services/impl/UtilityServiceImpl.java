package bootcamp.reto.pagoservicios.services.impl;

import bootcamp.reto.pagoservicios.models.Utility;
import bootcamp.reto.pagoservicios.repositories.UtilityRepository;
import bootcamp.reto.pagoservicios.services.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UtilityServiceImpl implements UtilityService {

  @Autowired
  private UtilityRepository utilityRepository;

  @Override
  public Flux<Utility> findAll() {
    return utilityRepository.findAll();
  }

  @Override
  public Flux<Utility> findByChannel(String channel) {
    return utilityRepository.findByChannel(channel);
  }

  @Override
  public Mono<Utility> save(Utility utility) {
    return utilityRepository.save(utility);
  }
}
