package bootcamp.reto.favoritos.favoritos.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table("favorito")
public class Favourite {

  @Id
  private Long id;
  @Column
  private String type;
  @Column
  private String name;
  @Column
  private String serviceCode;
  @Column("client_id")
  private String clientId;
}
