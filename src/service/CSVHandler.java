package service;

import entities.Inventory;
import entities.Product;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Stream;

public class CSVHandler {
  private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  public static void writeCSV(List<Product> products, String fileName) {
    try (PrintWriter writer = new PrintWriter(new File(fileName))) {
      writer.println("Name,Quantity,Price,Category,CreationDate,UpdateDate");
      products.forEach(product -> writer.println(formatProduct(product)));
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    }
  }

  public static Inventory readCSV(String fileName) {
    Inventory inventory = new Inventory();
    try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
      lines.skip(1).map(line -> line.split(",")).map(CSVHandler::parseProduct).forEach(inventory::addProduct);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return inventory;
  }

  public static void generateCSV(List<Product> products, String fileName) {
    Path path = Paths.get(fileName);
    try (BufferedWriter writer = Files.newBufferedWriter(path)) {
      writer.write("Name,Quantity,Price,Category,CreationDate,UpdateDate\n");
      for (Product product : products) {
        writer.write(formatProduct(product) + "\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static String formatProduct(Product product) {
    return String.join(",",
            product.getName(),
            String.valueOf(product.getQuantity()),
            String.valueOf(product.getPrice()),
            product.getCategory(),
            DATE_FORMAT.format(product.getCreationDate()),
            DATE_FORMAT.format(product.getUpdateDate()));
  }

  private static Product parseProduct(String[] product) {
    try {
      return new Product(
              product[0],
              Integer.parseInt(product[1]),
              Double.parseDouble(product[2]),
              product[3],
              DATE_FORMAT.parse(product[4]));
    } catch (ParseException e) {
      throw new RuntimeException(e);
    }
  }
}
