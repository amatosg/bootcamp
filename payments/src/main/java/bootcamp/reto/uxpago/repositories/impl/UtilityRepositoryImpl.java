package bootcamp.reto.uxpago.repositories.impl;

import bootcamp.reto.uxpago.config.ApplicationProperties;
import bootcamp.reto.uxpago.core.exception.UtilityException;
import bootcamp.reto.uxpago.models.Utility;
import bootcamp.reto.uxpago.repositories.UtilityRepository;
import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

@Slf4j
@Repository
public class UtilityRepositoryImpl implements UtilityRepository {

  private final WebClient webClient;

  public UtilityRepositoryImpl(WebClient.Builder builder,
      ApplicationProperties applicationProperties) {
    this.webClient = builder
        .baseUrl(applicationProperties.getUrlApiUtility())
        .build();
  }

  @Override
  public Flux<Utility> findByChannel(String channel, String token) {
    return this.webClient.get().uri("/channel/{channel}", channel)
        .accept(MediaType.APPLICATION_JSON)
        .header("Authorization", "Bearer " + token)
        .retrieve()
        .onStatus(HttpStatus::is5xxServerError,
            response -> Mono.error(new UtilityException("Server error")))
        .bodyToFlux(Utility.class)
        .retryWhen(
            Retry.fixedDelay(2, Duration.ofSeconds(2))
                .doBeforeRetry(x -> log.info("LOG BEFORE RETRY=" + x))
        )
        .doOnError(x -> log.info("LOG ERROR"));


  }
}
