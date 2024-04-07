package service;

import entities.Inventory;
import entities.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class CSVConsumer implements ConsumerCSVFunction {
    @Override
    public void accept(String fileName, Inventory inventory) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] data = line.split(",");
                String name = data[0];
                int quantity = Integer.parseInt(data[1]);
                double price = Double.parseDouble(data[2]);
                String category = data[3];
                Date creationDate = new Date();
                Date updateDate = new Date();
                inventory.addProduct(new Product(name, quantity, price, category, creationDate, updateDate));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

