package com.gerenciamentoEstoque.gerenciamentoEstoque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
 // Essa anotação é responsável por dizer ao Spring que essa classe é a classe principal da aplicação.
@SpringBootApplication
public class GerenciamentoEstoqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciamentoEstoqueApplication.class, args);
	}

}
