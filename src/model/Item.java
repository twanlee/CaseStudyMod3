package model;

import java.sql.Date;

public class Item {
    private int productId;
    private int productName;
    private int productQuantity;
    private Double eachPrice;
    private double cost = productQuantity*eachPrice;
    private Date date;

    public Item(int productId, int productName, int productQuantity, Double eachPrice, double cost, Date date) {
        this.productId = productId;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.eachPrice = eachPrice;
        this.cost = cost;
        this.date = date;

    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductName() {
        return productName;
    }

    public void setProductName(int productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Double getEachPrice() {
        return eachPrice;
    }

    public void setEachPrice(Double eachPrice) {
        this.eachPrice = eachPrice;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
