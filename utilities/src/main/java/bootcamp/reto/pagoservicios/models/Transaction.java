package bootcamp.reto.pagoservicios.models;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "transactions")
public class Transaction {

  @Id
  private String id;
  private String utilityCode;
  private String supplyNumber;
  private Date date;
  private BigDecimal amount;
  private String channel;

}
