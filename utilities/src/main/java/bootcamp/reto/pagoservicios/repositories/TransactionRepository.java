package bootcamp.reto.pagoservicios.repositories;

import bootcamp.reto.pagoservicios.models.Transaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String> {

}
