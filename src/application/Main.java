package application;

import entities.Inventory;
import service.CSVConsumer;
import service.ConsumerCSVFunction;
import service.InventoryManager;
import utils.ScannerSingleton;

import java.util.Scanner;

public class Main {
  private static final int OPTION_EXIT = 6;

  public static void main(String[] args) {
    Scanner sc = ScannerSingleton.getScanner();
    InventoryManager inventoryManager = new InventoryManager(new Inventory());
    ConsumerCSVFunction csvConsumer = new CSVConsumer();
    inventoryManager.loadInventoryFromCSV(csvConsumer);

    int option;

    Menu.welcomeMessage();
    do {
      Menu.options();
      option = getUserOptions(sc);
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
        case OPTION_EXIT:
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

  private static int getUserOptions(Scanner scanner) {
    if (scanner.hasNextInt()) {
      int option = scanner.nextInt();
      scanner.nextLine();
      return option;
    } else {
      Menu.invalidOptionMessage();
      scanner.next();
      return -1;
    }
  }
}
