package Product;

import java.util.ArrayList;

public class ProductMaintain {

    private static ProductMaintain productMaintain;
    private ArrayList<Product> productList;

    public ProductMaintain(){ productList = new ArrayList<Product>();}

    public static  ProductMaintain getInstance(){
        if(productMaintain == null){

            synchronized (ProductMaintain.class){

                if(productMaintain == null){

                    productMaintain = new ProductMaintain();
                }
            }

        }
        return productMaintain;
    }

    public void addProduct(Product product){
        productList.add(product);
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }
}
