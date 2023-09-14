package com.gerenciamentoEstoque.gerenciamentoEstoque.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController  // RestController é uma anotação que indica que essa classe é um controller que responde a requisições REST.
@RequestMapping(path = "/api/V1/product")
public class ProductController {
    final ProductService productService;

    @Autowired  // O Auto wired faz com que o Spring injete a dependência automaticamente.
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping ("/")// GetMapping é uma anotação que indica que o método abaixo é um endpoint que responde a requisições do tipo GET.
    public List<Product> GetProduct(){
        return productService.GetProduct();
    }

    @GetMapping("/{id}") // O GetMapping é uma anotação que indica que o método abaixo é um endpoint que responde a requisições do tipo GET.
    public Product getProductById(@PathVariable Long id){  //@pathVariable é uma anotação que indica que o parâmetro é obrigatório. Ela faz com que o Spring mapeie o parâmetro para o valor da variável na URL.
        return productService.getProductById(id);
    }


    @PostMapping // O PostMapping é uma anotação que indica que o método abaixo é um endpoint que responde a requisições do tipo POST.
    public void registerNewProduct(@RequestBody Product product){ // O RequestBody é uma anotação que indica que o corpo da requisição será convertido para o objeto passado como parâmetro.
        productService.addNewProduct(product);
    }

    @DeleteMapping(path= "{productId}") // O DeleteMapping é uma anotação que indica que o método abaixo é um endpoint que responde a requisições do tipo DELETE.
    public void deleteProduct(
                @PathVariable("productId") Long productId){
            productService.deleteProduct(productId);
    }

    @PutMapping(path = "/update") // O PutMapping é uma anotação que indica que o método abaixo é um endpoint que responde a requisições do tipo PUT.
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }
}
