package BookSwap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableWebSecurity
public class BookSwapApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookSwapApplication.class, args);
	}

}
