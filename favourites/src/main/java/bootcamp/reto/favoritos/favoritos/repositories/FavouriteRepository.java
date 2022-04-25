package bootcamp.reto.favoritos.favoritos.repositories;

import bootcamp.reto.favoritos.favoritos.models.Favourite;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface FavouriteRepository extends ReactiveCrudRepository<Favourite, Integer> {

}
