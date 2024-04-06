package entities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import service.CSVHandler;
import service.ConsumerCSVFunction;

public class Inventory {
  private List<Product> products;

  public Inventory() {
    this.products = new ArrayList<>();
  }

  public void addProduct(Product product) {
    this.products.add(product);
  }

  public void removeProduct(Product product) {
    this.products.remove(product);
  }

  public List<Product> getProducts() {
    return products;
  }

  public void consumeCSV(String fileName, ConsumerCSVFunction consumer) {
    consumer.accept(fileName, this);
  }

  public void generateCSV(String fileName) {
    CSVHandler.generateCSV(this.products, fileName);
  }

  public List<Product> listAndSortProducts(String sortBy) {
    Comparator<Product> comparator =
        switch (sortBy.toLowerCase()) {
          case "category" -> Comparator.comparing(Product::getCategory);
          case "price" -> Comparator.comparing(Product::getPrice);
          case "date" -> Comparator.comparing(Product::getCreationDate);
          default -> Comparator.comparing(product -> product.getName().toLowerCase());
        };

    return this.products.stream().sorted(comparator).collect(Collectors.toList());
  }
}
