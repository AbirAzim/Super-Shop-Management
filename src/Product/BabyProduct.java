package Product;


public class BabyProduct extends Product{

    private String dealBy;
    public BabyProduct(String name, double price, double quantity, String id) {
        super(name, price, quantity, id);
        dealBy = "Individual";
    }

    @Override
    public String toString() {
        return "BabyProduct{" +
                "Name="+super.getName()+
                "Price="+super.getPrice()+
                "quntity="+super.getQuantity()+
                "Id="+super.getId()+
                "dealBy='" + dealBy + '\'' +
                '}';
    }
}
