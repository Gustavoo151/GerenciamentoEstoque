# Documentação da API de Gerenciamento de Produtos

Esta API foi desenvolvida para gerenciar informações sobre produtos. Ela fornece endpoints para criar, recuperar, atualizar e excluir informações de produtos.

## Recursos Disponíveis

### Listar Produtos

**Endpoint:** `/api/V1/product/`

**Método HTTP:** GET

**Descrição:** Retorna uma lista de todos os produtos disponíveis.

**Exemplo de Uso:**

```shell
curl -X GET http://localhost:8080/api/V1/product/
```

### Obter Produto por ID

**Endpoint:** `/api/V1/product/{id}`

**Método HTTP:** GET

**Parâmetros:**
- `{id}` (Path Variable): O ID único do produto que deseja recuperar.

**Descrição:** Retorna as informações de um produto com base no ID fornecido.

**Exemplo de Uso:**

```shell
curl -X GET http://localhost:8080/api/V1/product/1
```

### Registrar Novo Produto

**Endpoint:** `/api/V1/product/`

**Método HTTP:** POST

**Corpo da Requisição:** Deve conter os dados do novo produto em formato JSON.

**Descrição:** Registra um novo produto no sistema.

**Exemplo de Uso:**

```shell
curl -X POST -H "Content-Type: application/json" -d '{
    "name": "Produto Novo",
    "size": 10.0,
    "price": 25.99,
    "color": "Azul",
    "type": "Eletrônico",
    "brand": "Marca A",
    "stock": 50,
    "material": "Plástico"
}' http://localhost:8080/api/V1/product/
```

### Excluir Produto por ID

**Endpoint:** `/api/V1/product/{productId}`

**Método HTTP:** DELETE

**Parâmetros:**
- `{productId}` (Path Variable): O ID único do produto que deseja excluir.

**Descrição:** Exclui um produto com base no ID fornecido.

**Exemplo de Uso:**

```shell
curl -X DELETE http://localhost:8080/api/V1/product/1
```

### Atualizar Produto por ID

**Endpoint:** `/api/V1/product/{productId}`

**Método HTTP:** PUT

**Parâmetros:**
- `{productId}` (Path Variable): O ID único do produto que deseja atualizar.
- Parâmetros Opcionais (Query Parameters): Você pode fornecer qualquer combinação dos seguintes parâmetros para atualizar as informações do produto:
    - `name` (String): Nome do produto.
    - `size` (Double): Tamanho do produto.
    - `price` (Double): Preço do produto.
    - `color` (String): Cor do produto.
    - `type` (String): Tipo do produto.
    - `brand` (String): Marca do produto.
    - `stock` (Integer): Estoque do produto.
    - `material` (String): Material do produto.

**Descrição:** Atualiza as informações de um produto com base no ID fornecido e nos parâmetros opcionais fornecidos.

**Exemplo de Uso:**

```shell
curl -X PUT -H "Content-Type: application/json" -d '{
    "name": "Produto Atualizado",
    "price": 29.99,
    "stock": 60
}' http://localhost:8080/api/V1/product/1
```

## Notas Adicionais

- Certifique-se de incluir os cabeçalhos apropriados (como "Content-Type") ao fazer requisições POST e PUT com corpo JSON.
- Os parâmetros opcionais em endpoints PUT podem ser usados para atualizar apenas as informações desejadas do produto, sem a necessidade de fornecer todos os campos novamente.

