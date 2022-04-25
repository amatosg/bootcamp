package bootcamp.reto.uxpago.repositories.impl;

import bootcamp.reto.uxpago.config.ApplicationProperties;
import bootcamp.reto.uxpago.core.exception.FavouriteException;
import bootcamp.reto.uxpago.models.Favourite;
import bootcamp.reto.uxpago.repositories.FavouriteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;
import reactor.core.publisher.Mono;

@Slf4j
@Repository
public class FavouriteRepositoryImpl implements FavouriteRepository {

  private final WebClient webClient;

  public FavouriteRepositoryImpl(Builder builder,
      ApplicationProperties applicationProperties) {
    this.webClient = builder
        .baseUrl(applicationProperties.getUrlApiFavourite())
        .build();
  }

  @Override
  public Mono<Favourite> save(Favourite favourite, String token) {
    return this.webClient.post()
        .uri("")
        .contentType(MediaType.APPLICATION_JSON)
        .header("Authorization", "Bearer " + token)
        .bodyValue(favourite)
        .retrieve()
        .onStatus(
            HttpStatus::is5xxServerError,
            response -> Mono.error(new FavouriteException("Server error"))
        )
        .bodyToMono(Favourite.class);
  }
}
