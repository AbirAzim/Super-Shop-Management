package Product;


public class Fruit extends Product{
    private String dealBy;

    public Fruit(String name, double price, double quantity, String id) {
        super(name, price, quantity, id);
        dealBy = "Weight";
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "Name="+super.getName()+
                "Price="+super.getPrice()+
                "quntity="+super.getQuantity()+
                "Id="+super.getId()+
                "dealBy='" + dealBy + '\'' +
                '}';
    }
}
