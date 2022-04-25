package bootcamp.reto.uxpago.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Utility {

  private String id;
  private String code;
  private String description;
  private String channel;
}
