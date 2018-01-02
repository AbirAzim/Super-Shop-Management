package Product;


public class Beverage extends Product {

    private String dealBy ;

    public Beverage(String name, double price, double quantity, String id ) {

        super(name, price, quantity, id);
        dealBy = "Individual";
    }

    @Override
    public String toString() {
        return "Beverage{" +
                "Name="+super.getName()+
                "Price="+super.getPrice()+
                "quntity="+super.getQuantity()+
                "Id="+super.getId()+
                "dealBy='" + dealBy + '\'' +
                '}';
    }
}
