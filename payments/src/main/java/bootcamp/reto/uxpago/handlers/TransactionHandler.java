package bootcamp.reto.uxpago.handlers;

import bootcamp.reto.uxpago.models.Transaction;
import bootcamp.reto.uxpago.services.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class TransactionHandler {

  private final TransactionService transactionService;

  public TransactionHandler(TransactionService transactionService) {
    this.transactionService = transactionService;
  }

  public Mono<ServerResponse> save(ServerRequest request) {
    var favouriteParam = request.queryParam("favourite").orElseThrow();
    var tokenHeader = request.headers().header("Authorization");
    String token = tokenHeader.get(0);
    return request.bodyToMono(Transaction.class)
        .flatMap(transaction -> this.transactionService.save(transaction, favouriteParam, token))
        .flatMap(transaction -> ServerResponse.ok().body(Mono.just(transaction), Transaction.class));
  }
}
