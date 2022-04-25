package bootcamp.reto.uxpago.services.impl;

import bootcamp.reto.uxpago.models.Favourite;
import bootcamp.reto.uxpago.repositories.FavouriteRepository;
import bootcamp.reto.uxpago.services.FavouriteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class FavouriteServiceImpl implements FavouriteService {

  private final FavouriteRepository favouriteRepository;

  public FavouriteServiceImpl(FavouriteRepository favouriteRepository) {
    this.favouriteRepository = favouriteRepository;
  }

  @Override
  public Mono<Favourite> save(Favourite favourite, String token) {
    return favouriteRepository.save(favourite, token);
  }
}
