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

            int quantity;
            System.out.print("Insert the product quantity: ");
            while (true) {
                System.out.print("Insert the product quantity: ");
                try {
                    quantity = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input format for quantity. Please enter a valid integer.");
                }
            }

            double price;
            System.out.print("Insert the product price: ");
            while (true) {
                System.out.print("Insert the product price: ");
                try {
                    price = Double.parseDouble(sc.nextLine());
                    break; // Saia do loop se a entrada for válida
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input format for price. Please enter a valid number.");
                }
            }

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
            System.out.printf("%-20s %-10s %-10s %-20s %-20s %-20s%n", "Name", "Quantity", "Price", "Category", "Creation Date", "Update Date");
            for (Product product : productList) {
                System.out.printf("%-20s %-10d %-10.2f %-20s %-20s %-20s%n", product.getName(), product.getQuantity(),
                        product.getPrice(), product.getCategory(), product.getCreationDate(), product.getUpdateDate());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void exportToCSV() {
        try {
            List<Product> sortedProducts = inventory.listAndSortProducts("name");
            for (Product product : sortedProducts) {
                product.setUpdateDate(new Date());
            }
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
