package bootcamp.reto.pagoservicios.services;


import bootcamp.reto.pagoservicios.models.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransaccionService {

  Flux<Transaction> findAll();

  Mono<Transaction> save(Transaction transaction);
}
