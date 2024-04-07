package service;

import entities.Inventory;

@FunctionalInterface
public interface ConsumerCSVFunction {
    void accept(String fileName, Inventory inventory);
}
