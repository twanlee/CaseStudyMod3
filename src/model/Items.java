package model;

import java.sql.Date;

public class Items {
    private int item_id;
    private int user_id;
    private int product_id;
    private int product_quantity;
    private Date order_date;

    public Items(int user_id, int product_id, int product_quantity) {
        this.user_id = user_id;
        this.product_id = product_id;
        this.product_quantity = product_quantity;
    }

    public Items(int item_id, int user_id, int product_id, int product_quantity, Date order_date) {
        this.item_id = item_id;
        this.user_id = user_id;
        this.product_id = product_id;
        this.product_quantity = product_quantity;
        this.order_date = order_date;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(int product_quantity) {
        this.product_quantity = product_quantity;
    }
}
