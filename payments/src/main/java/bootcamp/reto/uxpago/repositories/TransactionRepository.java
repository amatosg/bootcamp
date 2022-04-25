package bootcamp.reto.uxpago.repositories;

import bootcamp.reto.uxpago.models.Transaction;
import reactor.core.publisher.Mono;

public interface TransactionRepository {

  Mono<Transaction> save(Transaction transaction, String token);
}
