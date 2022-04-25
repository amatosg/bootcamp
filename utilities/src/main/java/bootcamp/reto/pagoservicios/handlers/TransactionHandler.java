package bootcamp.reto.pagoservicios.handlers;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import bootcamp.reto.pagoservicios.models.Transaction;
import bootcamp.reto.pagoservicios.services.TransaccionService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class TransactionHandler {

  private final TransaccionService transaccionService;

  public TransactionHandler(TransaccionService transaccionService) {
    this.transaccionService = transaccionService;
  }

  public Mono<ServerResponse> findAll(ServerRequest request) {
    return ok().contentType(APPLICATION_JSON)
        .body(transaccionService.findAll(), Transaction.class);
  }

  public Mono<ServerResponse> save(ServerRequest request) {

    return request.bodyToMono(Transaction.class)
        .flatMap(this.transaccionService::save)
        .flatMap(transaction -> ServerResponse.ok().body(Mono.just(transaction), Transaction.class));
  }
}
