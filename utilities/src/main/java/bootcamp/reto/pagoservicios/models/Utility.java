package bootcamp.reto.pagoservicios.models;

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
@Document(value = "utilities")
public class Utility {

  @Id
  private String id;
  private String code;
  private String description;
  private String channel;

}
