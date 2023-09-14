package com.gerenciamentoEstoque.gerenciamentoEstoque.Product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration// Essa anotação indica que essa classe é uma classe de configuração.
public class ProductConfig {  // Essa classe vai ser responsável por popular o banco de dados com alguns produtos.

    @Bean // O Bean é uma anotação que indica que o método abaixo é um componente gerenciado pelo Spring.
    CommandLineRunner commandLineRunner(ProductRepository repository){
        return args -> {
            Product camiseta = new Product(
                    "Camiseta",
                    1L,
                    1.0,
                    50.0,
                    "Branca",
                    "Camiseta",
                    "Nike",
                    10,
                    "Algodão"
            );

            Product calca = new Product(
                    "calça jeans",
                    2L,
                    3.0,
                    60.0,
                    "Jeans",
                    "CALÇA",
                    "Coca-Cola",
                    18,
                    "Algodão"
            );

            repository.saveAll(
                    List.of(camiseta, calca)
            );
        };
    }
}
