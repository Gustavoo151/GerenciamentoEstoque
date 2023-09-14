package com.gerenciamentoEstoque.gerenciamentoEstoque.ProducTest;

import com.gerenciamentoEstoque.gerenciamentoEstoque.Product.Product;
import com.gerenciamentoEstoque.gerenciamentoEstoque.Product.ProductController;
import com.gerenciamentoEstoque.gerenciamentoEstoque.Product.ProductService;
import io.restassured.http.ContentType;
import org.springframework.http.HttpStatus;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@WebMvcTest
public class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;

    @BeforeEach
    public void setup(){
        RestAssuredMockMvc.standaloneSetup(this.productController);
    }

    @Test  //
    public void deveRestornaSucesso_QuandoBuscarProduct(){
        // when é uma função do Mockito que permite que você defina um comportamento para um método de uma classe mockada.
        when(this.productService.getProductById(1L)). // O getFilmeById é um método que foi criado no FilmeService. Ele retorna um product dado um id.
                thenReturn(new Product( "Camiseta",  // theReturn é uma função do Mockito que permite que você defina um retorno para um método de uma classe mockada.
                    10L,
                    1.0,
                    50.0,
                    "Branca",
                    "Camiseta",
                    "Nike",
                    10,
                    "Algodão")
        );

        RestAssuredMockMvc.given() // given é uma função do RestAssured que permite que você defina o estado inicial de uma requisição.
            .accept(ContentType.JSON)  // accept é uma função do RestAssured que permite que você defina o tipo de conteúdo que você aceita como resposta.
        .when()  // when é uma função do RestAssured que permite que você defina o estado final de uma requisição.
            .get("/api/V1/product/{id}", 1L)  // get é uma função do RestAssured que permite que você defina o método e o endpoint de uma requisição.
        .then()  // then é uma função do RestAssured que permite que você defina o estado esperado de uma requisição.
            .statusCode(HttpStatus.OK.value()); // statusCode é uma função do RestAssured que permite que você defina o código de status esperado de uma requisição.
    }


    @Test
    public void deveRetornarUmExceptiom_QuandoNaoAcharOProduto() {
        Long productId = 5L;

        when(productService.getProductById(productId)).thenThrow(new IllegalStateException("Produto com id 5 não existe!"));

        try {
            productController.getProductById(productId);
        } catch (IllegalStateException e) {
            assertEquals("Produto com id 5 não existe!", e.getMessage());
        }
        verify(productService, times(1)).getProductById(productId);
    }

    // Falta fazer uma post e para delete

    @Test
    public void deveRetornarUmException_QuandoDeletarInexistente() {
        Long productId = 6L;

        when(this.productService.getProductById(productId))
                .thenThrow(new IllegalStateException("Produto com id " + productId + " não existe!"));

        try {
            RestAssuredMockMvc.given()
                    .accept(ContentType.JSON)
                    .when()
                    .delete("/api/V1/product/{id}", productId); // delete é uma função do RestAssured que permite que você defina o método e o endpoint de uma requisição. essa requisição é do tipo delete.
        } catch (IllegalStateException e) {
            assertEquals("Produto com id " + productId + " não existe!", e.getMessage());
        }
    }
}
