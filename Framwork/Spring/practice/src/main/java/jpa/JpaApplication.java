package jpa;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	Hibernate5Module hibernate5Module() {
		// 강제 지연 로딩 설정
		// hibernate5Module.configure(Hibernate5Module.Feature.FORCE_LAZY_LOADING,true);
		return new Hibernate5Module();
	}

}
