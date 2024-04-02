# Sistema de Controle de Estoque


## Funcionalidades

- Consumir um csv com a lista de produtos
- Inserir produtos
- Atualizar produtos (nome, quantidade, preço e categoria)
- Excluir produtos
- Gerar um csv atualizado
- Listar e ordenar produtos por: categoria, preço, datas, nome

## Classe `Product`

Representa um produto no inventário.

### Campos

- `name`: O nome do produto.
- `quantity`: A quantidade do produto no estoque.
- `price`: O preço do produto.
- `creationDate`: A data de criação do produto.
- `category`: A categoria do produto.
- `updateDate`: A data da última atualização do produto.

### Métodos

- `getName()`: Retorna o nome do produto.
- `getQuantity()`: Retorna a quantidade do produto.
- `getPrice()`: Retorna o preço do produto.
- `getCreationDate()`: Retorna a data de criação do produto.
- `getCategory()`: Retorna a categoria do produto.
- `getUpdateDate()`: Retorna a data da última atualização do produto.

---

## Classe `Inventory`

Representa o inventário de produtos.

### Campos

- `products`: Uma lista de produtos no inventário.

### Métodos

- `addProduct(Product product)`: Adiciona um produto ao inventário.
- `removeProduct(Product product)`: Remove um produto do inventário.
- `getProducts()`: Retorna a lista de produtos no inventário.
- `consumeCSV(String fileName)`: Lê um arquivo CSV e adiciona todos os produtos listados no arquivo ao inventário.
- `generateCSV(String fileName)`: Escreve a lista atual de produtos no inventário para um arquivo CSV.
- `listAndSortProducts(String sortBy)`: Retorna a lista de produtos no inventário, ordenada por um critério especificado.

---

## Classe `CSVHandler`

Fornece métodos para ler e escrever arquivos CSV.

### Métodos

- `writeCSV(List<Product> products, String fileName)`: Escreve uma lista de produtos para um arquivo CSV.
- `readCSV(String fileName)`: Lê um arquivo CSV e retorna um `Inventory` com os produtos listados no arquivo.

---

## Classe `Main`

Executa o programa.

### Métodos

- `main(String[] args)`: O ponto de entrada do programa. Cria um novo inventário, consome um arquivo CSV, lista e ordena produtos, e gera um novo arquivo CSV.

---
