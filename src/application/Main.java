package application;

import entities.Inventory;
import entities.Product;
import service.CSVConsumer;
import service.ConsumerCSVFunction;
import service.InventoryManager;
import utils.ScannerSingleton;

import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = ScannerSingleton.getScanner();
    InventoryManager inventoryManager = new InventoryManager(new Inventory());
    ConsumerCSVFunction csvConsumer = new CSVConsumer();
    inventoryManager.loadInventoryFromCSV(csvConsumer);

    int option;

    Menu.welcomeMessage();
    do {
      Menu.options();
      option = sc.nextInt();
      sc.nextLine();
      Menu.clearConsole();

      switch (option) {
        case 1:
          inventoryManager.addProduct();
          break;
        case 2:
          inventoryManager.removeProduct();
          break;
        case 3:
          inventoryManager.editProduct();
          break;
        case 4:
          inventoryManager.listProducts();
          break;
        case 5:
          inventoryManager.exportToCSV();
          break;
        case 6:
          Menu.exitMessage();
          break;
        default:
          Menu.invalidOptionMessage();
          sc.nextLine();
          break;
      }
    } while (option != 6);

    ScannerSingleton.closeScanner();
  }
}
