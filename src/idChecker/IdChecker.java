package idChecker;

import Admin.Admin;
import Admin.AdminMaintain;
import Product.Product;
import Product.ProductMaintain;
import customer.Customer;
import customer.CustomerMaintain;

public class IdChecker {

    private AdminMaintain adminMaintain;
    private CustomerMaintain customerMaintain;
    private ProductMaintain productMaintain;

    public IdChecker(AdminMaintain adminMaintain){
        this.adminMaintain = adminMaintain;
    }

    public IdChecker(CustomerMaintain customerMaintain){
        this.customerMaintain = customerMaintain;
    }

    public IdChecker(ProductMaintain productMaintain){
        this.productMaintain = productMaintain;
    }



    public boolean checkAdminId (String id){
        for(Admin admin : adminMaintain.getAdminList()){
            if(admin.getId().equals(id)){
                return false;
            }
        }
        return true;
    }

    public boolean checkCustomerId(String id){
        for(Customer customer : customerMaintain.getCustomerList()){
            if(customer.getId().equals(id)){
                return false;
            }
        }
        return true;
    }

    public boolean checkProductId(String id){
        for(Product product : productMaintain.getProductList()){
            if(product.getId().equals(id)){
                return  false;
            }

        }
        return true;
    }

    public Customer checkCustomerIdforSearch (String id){
        for(Customer customer : customerMaintain.getCustomerList()){
            if(customer.getId().equals(id)){
                return customer;
            }
        }
        return null;
    }

    public Product checkProductIdForSearch (String id){
        for(Product product : productMaintain.getProductList()){
            if(product.getId().equals(id)){
                return  product;
            }

        }
        return null;
    }
}
