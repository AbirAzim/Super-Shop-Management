package Product;

public class Fish extends Product {
    private String dealBy;

    public Fish(String name, double price, double quantity, String id) {
        super(name, price, quantity, id);
        dealBy = "Weight";
    }

    @Override
    public String toString() {
        return "Fish{" +
                "Name="+super.getName()+
                "Price="+super.getPrice()+
                "quntity="+super.getQuantity()+
                "Id="+super.getId()+
                "dealBy='" + dealBy + '\'' +
                '}';
    }
}
