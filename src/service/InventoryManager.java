package service;

import entities.Inventory;
import entities.Product;
import utils.ScannerSingleton;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class InventoryManager {
    private Inventory inventory;

    public InventoryManager(Inventory inventory) {
        this.inventory = inventory;
    }

    public void addProduct() {
        try {
            Scanner sc = ScannerSingleton.getScanner();

            System.out.print("Insert product name: ");
            String name = sc.nextLine();

            System.out.print("Insert the product quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();

            System.out.print("Insert the product price: ");
            double price = sc.nextDouble();
            sc.nextLine();

            System.out.print("Insert the product category: ");
            String category = sc.nextLine();

            Date date = new Date();

            Product product = new Product(name, quantity, price, category, date, date);
            inventory.addProduct(product);

            System.out.println("Product added successfully.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void removeProduct() {
        try {
            Scanner sc = ScannerSingleton.getScanner();
            System.out.print("Insert product name: ");
            String name = sc.nextLine();

            Product product = inventory.getProductByName(name);

            if (product == null) {
                System.out.println("Product not found.");
                return;
            }

            inventory.removeProduct(product);
            System.out.println("Product removed successfully.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void editProduct() {
        try {
            Scanner sc = ScannerSingleton.getScanner();
            System.out.print("Insert product name: ");
            String name = sc.nextLine();

            Product product = inventory.getProductByName(name);

            if (product == null) {
                System.out.println("Product not found.");
                return;
            }

            System.out.print("Insert product's new name: ");
            String newName = sc.nextLine();

            System.out.print("Insert the product's new quantity: ");
            int newQuantity = sc.nextInt();
            sc.nextLine();

            System.out.print("Insert the product's new price: ");
            double newPrice = sc.nextDouble();
            sc.nextLine();

            System.out.print("Insert the product's new category: ");
            String newCategory = sc.nextLine();

            Date date = new Date();

            product.setName(newName);
            product.setQuantity(newQuantity);
            product.setPrice(newPrice);
            product.setCategory(newCategory);
            product.setUpdateDate(date);

            System.out.println("Product edited successfully.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void listProducts() {
        try {
            System.out.println("Products: ");
            List<Product> productList = inventory.getProducts();
            productList.forEach(System.out::println);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void exportToCSV() {
        try {
            List<Product> sortedProducts = inventory.listAndSortProducts("name");
            inventory.generateCSV("output.csv");
            System.out.println("output.csv generated successfully.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void loadInventoryFromCSV(ConsumerCSVFunction csvConsumer) {
        inventory.consumeCSV("input.csv", csvConsumer);
    }
}
