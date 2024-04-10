package Challange1;

public class Item {
    private String name;
    private String category;
    private double price;
    private String sellerEmail;

    public Item(String name, String category, double price, String sellerEmail) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.sellerEmail = sellerEmail;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }
}