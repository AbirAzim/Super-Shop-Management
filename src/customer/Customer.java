package customer;

import java.util.Date;

public class Customer {

    private String name;
    private String id;
    private Date joindate;
    private double totalBrought;
    private String customerType;

    public void setTotalBrought(double totalBrought) {
        this.totalBrought = totalBrought;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerType() {
        return customerType;

    }

    public Customer(String name, String id, double totalBrought , String customerType) {
        this.name = name;
        this.id = id;
        this.totalBrought = totalBrought;
        this.customerType = customerType;
        joindate = new Date();

    }

    public double getTotalBrought() {
        return totalBrought;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getJoindate() {
        return joindate;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", joindate=" + joindate +
                '}';
    }
}
