package customer;

public class BeginnerCustomer extends Customer {

    private double discount;

    public BeginnerCustomer(String name, String id , double totalBrought, String customerType) {
        super(name, id , totalBrought, customerType);
        this.discount = 1;
    }

    public double getDiscount() {
        return discount;
    }


    @Override
    public String toString() {
        return "BeginnerCustomer{" +
                " Name="+super.getName() +
                " Id="+super.getId() +
                " JoinDate"+super.getJoindate()+
                ", discount=" + discount +
                ", totalBrought=" + super.getTotalBrought() +
                ", customerType='" + super.getCustomerType()+ '\'' +
                '}';
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

}
