package BookSwap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BookSwapApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookSwapApplication.class, args);
	}

}
