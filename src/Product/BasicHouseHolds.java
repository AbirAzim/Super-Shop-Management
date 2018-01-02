package Product;

public class BasicHouseHolds extends Product {

    private String dealBy;

    public BasicHouseHolds(String name, double price, double quantity, String id) {
        super(name, price, quantity, id);
        dealBy = "Package";
    }

    @Override
    public String toString() {
        return "BasicHouseHolds{" +
                "Name="+super.getName()+
                "Price="+super.getPrice()+
                "quntity="+super.getQuantity()+
                "Id="+super.getId()+
                "dealBy='" + dealBy + '\'' +
                '}';
    }

}
