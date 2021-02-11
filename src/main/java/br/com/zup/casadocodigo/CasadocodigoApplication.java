package br.com.zup.casadocodigo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CasadocodigoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasadocodigoApplication.class, args);
	}

}
