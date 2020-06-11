package model;

import java.sql.Date;

public class Order {
    private int item_id;
    private String userName;
    private int productId;
    private String product_name;
    private int quantity;
    private double price;
    private double amount;
    private Date order_date;

    public Order(int item_id, String userName, int productId, String product_name, int quantity, double price, double amount, Date order_date) {
        this.item_id = item_id;
        this.userName = userName;
        this.productId = productId;
        this.product_name = product_name;
        this.quantity = quantity;
        this.price = price;
        this.amount = amount;
        this.order_date = order_date;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void getOrder_date(Date order_date) {
        this.order_date = order_date;
    }
}
