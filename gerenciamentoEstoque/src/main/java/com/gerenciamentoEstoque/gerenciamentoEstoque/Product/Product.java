package com.gerenciamentoEstoque.gerenciamentoEstoque.Product;
import jakarta.persistence.*;

@Entity  // Essa anotação indica que essa classe é uma entidade do banco de dados para o hibernate.
@Table  // Essa anotação indica que essa classe é uma tabela do banco de dados para o nosso database.
public class Product {
    @Id // Essa anotação indica que esse atributo é uma chave primária.
    @SequenceGenerator( // Essa anotação indica que esse atributo é um gerador de sequência.
            name = "product_sequence",  // O name é o nome da sequência que será criada no banco de dados.
            sequenceName = "product_sequence", // O sequenceName é o nome da sequência que será criada no banco de dados.
            allocationSize = 1  // O allocationSize é o tamanho da sequência que será criada no banco de dados.
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, // Essa anotação indica que esse atributo é um gerador de sequência.
            generator = "product_sequence" // O generator é o nome da sequência que será criada no banco de dados.
    )

    private Long id;
    private String name;
    private double size;
    private double price;
    private String color;
    private String type;
    private String brand;
    private int stock;
    private String material;

    public Product(String name,Long id ,double size, double price, String color, String type, String brand, int stock, String material){
        this.id = id;
        this.name = name;
        this.size = size;
        this.price = price;
        this.color = color;
        this.type = type;
        this.brand = brand;
        this.stock = stock;
        this.material = material;
    }
    public Product(String name,double size, double price, String color, String type, String brand, int stock, String material){
        this.name = name;
        this.size = size;
        this.price = price;
        this.color = color;
        this.type = type;
        this.brand = brand;
        this.stock = stock;
        this.material = material;
    }

    public Product(){}

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return this.id;
    }

    public void setMaterial(String material){
        this.material = material;
    }

    public String getMaterial(){
        return this.material;
    }

    public void setStock(int stock){
        this.stock = stock;
    }

    public int getStock(){
        return this.stock;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getSize() {
        return this.size;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public String getBrand(){
        return this.brand;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name=" + name + '\'' +
                ", size=" + size + '\'' +
                ", price=" + price + '\'' +
                ", color=" + color + '\'' +
                ", type=" + type + '\'' +
                ", brand=" + brand + '\'' +
                ", stock=" + stock + '\'' +
                ", material=" + material + '\'' +
                '}';
    }
}
