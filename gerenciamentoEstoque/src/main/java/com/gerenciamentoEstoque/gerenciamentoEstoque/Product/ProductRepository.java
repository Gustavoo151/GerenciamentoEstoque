package com.gerenciamentoEstoque.gerenciamentoEstoque.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Essa classe vai ser responsável por fazer as operações de CRUD no banco de dados.
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    // Isso vair ser igual SELECT * FROM product WHERE name = ?
    Optional<Product> findProductByName(String name);

}
