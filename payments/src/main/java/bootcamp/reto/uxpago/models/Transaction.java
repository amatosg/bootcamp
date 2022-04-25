package bootcamp.reto.uxpago.models;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

  private String id;
  private String utilityCode;
  private String supplyNumber;
  private ZonedDateTime date;
  private BigDecimal amount;
  private String channel;
  private String customerId;
  private String favouriteType;
  private String favouriteName;
}
