package application;

import entities.Inventory;
import entities.Product;
import service.CSVConsumer;
import service.ConsumerCSVFunction;

import java.util.List;

public class Main {
  public static void main(String[] args) {

    Inventory inventory = new Inventory();

    ConsumerCSVFunction csvConsumer = new CSVConsumer();
    inventory.consumeCSV("input.csv", csvConsumer);

    List<Product> sortedProducts = inventory.listAndSortProducts("name");
    sortedProducts.forEach(
        product ->
            System.out.println(
                "Product: "
                    + product.getName()
                    + ", Quantity: "
                    + product.getQuantity()
                    + ", Price: "
                    + product.getPrice()
                    + ", Creation Date: "
                    + product.getCreationDate()
                    + ", Category: "
                    + product.getCategory()
                    + ", Update Date: "
                    + product.getUpdateDate()));

    inventory.generateCSV("output.csv");
  }
}
