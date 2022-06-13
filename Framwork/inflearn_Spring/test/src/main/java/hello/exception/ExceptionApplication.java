package hello.exception;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
public class ExceptionApplication {
	public static void main(String[] args) {
		SpringApplication.run(ExceptionApplication.class, args);
	}

}
