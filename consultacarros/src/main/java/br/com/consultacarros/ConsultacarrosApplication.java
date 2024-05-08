package br.com.consultacarros;

import br.com.consultacarros.principal.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsultacarrosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConsultacarrosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main();
		for (int i = 0; i < 3; i++) {
			main.exibeMenu();
		}

	}
}
