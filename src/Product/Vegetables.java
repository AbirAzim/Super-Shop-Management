package Product;

public class Vegetables extends Product {
    private String dealBy;


    public Vegetables(String name, double price, double quantity, String id) {
        super(name, price, quantity, id);
        dealBy = "Weight";
    }

    @Override
    public String toString() {
        return "Vegetables{" +
                "Name="+super.getName()+
                "Price="+super.getPrice()+
                "quntity="+super.getQuantity()+
                "Id="+super.getId()+
                "dealBy='" + dealBy + '\'' +
                '}';
    }

}
