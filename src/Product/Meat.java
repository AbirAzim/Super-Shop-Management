package Product;

public class Meat extends Product {
    private String dealBy;

    public Meat(String name, double price, double quantity, String id) {
        super(name, price, quantity, id);
        dealBy = "Weight";
    }
    @Override
    public String toString() {
        return "Meat{" +
                "Name="+super.getName()+
                "Price="+super.getPrice()+
                "quntity="+super.getQuantity()+
                "Id="+super.getId()+
                "dealBy='" + dealBy + '\'' +
                '}';
    }
}
