package bootcamp.reto.uxpago.services.impl;

import bootcamp.reto.uxpago.models.Favourite;
import bootcamp.reto.uxpago.models.Transaction;
import bootcamp.reto.uxpago.repositories.FavouriteRepository;
import bootcamp.reto.uxpago.repositories.TransactionRepository;
import bootcamp.reto.uxpago.repositories.UtilityRepository;
import bootcamp.reto.uxpago.services.FavouriteService;
import bootcamp.reto.uxpago.services.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
@Service
public class TransactionServiceImpl implements TransactionService {

  private final TransactionRepository transactionRepository;

  private final FavouriteService favouriteService;

  public TransactionServiceImpl(
      TransactionRepository transactionRepository,
      FavouriteService favouriteService) {
    this.transactionRepository = transactionRepository;
    this.favouriteService = favouriteService;
  }

  @Override
  public Mono<Transaction> save(Transaction transaction, String favourite, String token) {

    if (favourite.equalsIgnoreCase("s")) {
      Favourite favouriteTransaction = Favourite
          .builder()
          .type(transaction.getFavouriteType())
          .name(transaction.getFavouriteName())
          .utilityCode(transaction.getUtilityCode())
          .customerId(transaction.getCustomerId())
          .build();

      return transactionRepository
          .save(transaction, token)
          .publishOn(Schedulers.boundedElastic())
          .doOnSuccess(t -> favouriteService.save(favouriteTransaction, token).subscribe());
    } else {
      return transactionRepository.save(transaction, token);
    }
  }
}
