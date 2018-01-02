package customer;

public class GoldenCustomer extends Customer{

    private double discount;

    public GoldenCustomer(String name, String id,double totalBrought, String customerType) {
        super(name, id , totalBrought,customerType);
        this.discount = 2;
    }

    @Override
    public String toString() {
        return "GoldenCustomer{" +
                " Name="+super.getName() +
                " Id="+super.getId() +
                " JoinDate"+super.getJoindate()+
                "discount=" + discount +
                ", totalBrought=" + super.getTotalBrought() +
                ", customerType='" + super.getCustomerType() + '\'' +
                '}';
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

}
