package com.gerenciamentoEstoque.gerenciamentoEstoque.Product;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Essa classe será reponsável por fazer todas as regras de negócio da aplicação.
@Service // @Component é a mesma coisa, mas é mais semantico usar @Service  para classes que são serviços.
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> GetProduct() {
        return productRepository.findAll();
    }

    public void addNewProduct(Product product) {
        System.out.println(product);
        Optional<Product> productOptional = productRepository.findProductByName(product.getName()); // O findProductByName é um método que foi criado no ProductRepository.
        if (productOptional.isPresent()) {
            throw new IllegalStateException("Produto já existe!");
        } else {
            productRepository.save(product);
        }
    }

    public void deleteProduct(Long productId) {
        boolean exists = productRepository.existsById(productId);
        if (!exists) {
            throw new IllegalStateException("Produto com id " + productId + " não existe!");
        } else {
            productRepository.deleteById(productId);
        }
    }

    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new IllegalStateException(
                        "Produto com ID " + productId + " não existe!"));
    }

    @Transactional
    public ResponseEntity<Product> updateProduct(Product product) {
        Product updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);
    }
}
