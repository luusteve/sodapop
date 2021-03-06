package sluu.sodapop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SodapopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SodapopApplication.class, args);
	}

	@RequestMapping("/")
	public String greeting() {
		return "Hello World";
	}

}
