package bootcamp.reto.uxpago.core.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UtilityException extends RuntimeException {

  private HttpStatus status = HttpStatus.BAD_REQUEST;
  private String message;

  public UtilityException(String message) {
    this.message = message;
  }
}
