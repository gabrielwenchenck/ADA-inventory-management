package entities;

import java.util.Date;

public class Product {
  private String name;
  private int quantity;
  private double price;
  private String category;
  private Date creationDate;
  private Date updateDate;

  public Product(
      String name,
      int quantity,
      double price,
      String category,
      Date creationDate,
      Date updateDate) {
    this.name = name;
    this.quantity = quantity;
    this.price = price;
    this.category = category;
    this.creationDate = creationDate;
    this.updateDate = updateDate;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  public Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }
}
