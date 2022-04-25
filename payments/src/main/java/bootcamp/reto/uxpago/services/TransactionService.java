package bootcamp.reto.uxpago.services;

import bootcamp.reto.uxpago.models.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {

  Mono<Transaction> save(Transaction transaction, String favorito, String token);
}
