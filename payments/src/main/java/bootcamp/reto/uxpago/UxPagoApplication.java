package bootcamp.reto.uxpago;

import bootcamp.reto.uxpago.config.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ ApplicationProperties.class })
public class UxPagoApplication {

  public static void main(String[] args) {
    SpringApplication.run(UxPagoApplication.class, args);
  }

}
