package Product;

import java.util.Date;

public class Product extends ProductManaging {

    private String name;
    private double price;
    private double quantity;
    private String id;
    private Date productDelivery;
    public double totalPrice;
    public double currentlySellQuantity;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {

        return id;
    }

    public Date getProductDelivery() {
        return productDelivery;
    }

    public Product(String name, double price, double quantity, String id) {

        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.id = id;

        productDelivery = new Date();
        totalPrice = this.quantity * this.price;
    }

    @Override
    public double calculateCallingProductQuantity(double callingQuantity) {

        if(this.quantity < callingQuantity || this.quantity == 0){
            return -1;
        }

        else {
            this.currentlySellQuantity = callingQuantity;
            this.quantity -= callingQuantity;
            return 0;
        }
    }
}
