package model;

public class Product {
    private int id;
    private String name;
    private String brand;
    private Double price;
    private int quantity;
    private String description;
    private String imgUrl;

    public Product(String name, String brand, Double price, int quantity, String description, String imgUrl) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.imgUrl = imgUrl;
    }

    public Product(int id, String name, String brand, Double price, int quantity, String description, String imgUrl) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.imgUrl = imgUrl;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
