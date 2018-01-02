package customer;

import java.util.ArrayList;

public class CustomerMaintain {

    private static CustomerMaintain customerMaintain;
    private ArrayList<Customer> customerList;

    public CustomerMaintain(){
        customerList = new ArrayList<Customer>();
    }

    public static CustomerMaintain getInstance(){
        if(customerMaintain == null){
            customerMaintain = new CustomerMaintain();
        }
        return customerMaintain;
    }

    public void addCustomer(Customer customer){
        customerList.add(customer);
    }
    public void deleteCustomer(Customer customer){customerList.remove(customer);}

    public ArrayList<Customer> getCustomerList(){
        return customerList;
    }
}







