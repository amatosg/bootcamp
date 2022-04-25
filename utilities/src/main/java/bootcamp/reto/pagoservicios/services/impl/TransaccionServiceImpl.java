package bootcamp.reto.pagoservicios.services.impl;

import bootcamp.reto.pagoservicios.models.Transaction;
import bootcamp.reto.pagoservicios.repositories.TransactionRepository;
import bootcamp.reto.pagoservicios.services.TransaccionService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransaccionServiceImpl implements TransaccionService {

  private final TransactionRepository transactionRepository;

  public TransaccionServiceImpl(TransactionRepository transactionRepository) {
    this.transactionRepository = transactionRepository;
  }

  @Override
  public Flux<Transaction> findAll() {
    return transactionRepository.findAll();
  }

  @Override
  public Mono<Transaction> save(Transaction transaction) {
    return transactionRepository.save(transaction);
  }

}
