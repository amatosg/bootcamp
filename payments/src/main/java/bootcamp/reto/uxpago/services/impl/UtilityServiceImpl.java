package bootcamp.reto.uxpago.services.impl;

import bootcamp.reto.uxpago.models.Utility;
import bootcamp.reto.uxpago.repositories.UtilityRepository;
import bootcamp.reto.uxpago.services.UtilityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Slf4j
@Service
public class UtilityServiceImpl implements UtilityService {

  private final UtilityRepository utilityRepository;

  public UtilityServiceImpl(UtilityRepository utilityRepository) {
    this.utilityRepository = utilityRepository;
  }

  @Override
  public Flux<Utility> findByChannel(String channel, String token) {
    return utilityRepository.findByChannel(channel, token);
  }
}
