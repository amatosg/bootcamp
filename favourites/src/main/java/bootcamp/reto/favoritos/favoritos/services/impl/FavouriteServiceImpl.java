package bootcamp.reto.favoritos.favoritos.services.impl;

import bootcamp.reto.favoritos.favoritos.models.Favourite;
import bootcamp.reto.favoritos.favoritos.repositories.FavouriteRepository;
import bootcamp.reto.favoritos.favoritos.services.FavouriteService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FavouriteServiceImpl implements FavouriteService {

  private final FavouriteRepository favouriteRepository;

  public FavouriteServiceImpl(FavouriteRepository favouriteRepository) {
    this.favouriteRepository = favouriteRepository;
  }

  @Override
  public Flux<Favourite> findAll() {
    return favouriteRepository.findAll();
  }

  @Override
  public Mono<Favourite> save(Favourite favourite) {
    return favouriteRepository.save(favourite);
  }
}
