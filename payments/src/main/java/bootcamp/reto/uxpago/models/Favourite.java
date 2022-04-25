package bootcamp.reto.uxpago.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Favourite {

  private Integer id;
  private String type;
  private String name;
  private String utilityCode;
  private String customerId;
}
