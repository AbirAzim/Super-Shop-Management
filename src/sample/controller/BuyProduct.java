package sample.controller;

import Product.*;
import idChecker.IdChecker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Double.*;

public class BuyProduct implements Initializable{

    ProductMaintain productMaintain;

    public BuyProduct(){ productMaintain = ProductMaintain.getInstance();}

    ObservableList<Product> pList = FXCollections.observableArrayList();
    ObservableList<String> catagoryList = FXCollections.observableArrayList("Beverage","Baby Product", "Vegetables","Fish",
            "Fruit","Basic Households","Meat");

    @FXML
    private ComboBox<String> catagorySelect;
    private String value;



    @FXML
    private TextField productNameField;



    @FXML
    private TextField productPriceField;


    @FXML
    private TextField buyPrice;



    @FXML
    private TextField productQuantityField;



    @FXML
    private TextField productIdField;


    @FXML
    private Label tBill;


    @FXML
    private TableView<Product> table;

    @FXML
    private TableColumn<Product,String> tableName;


    @FXML
    private TableColumn<Product,Double> tablePrice;

    @FXML
    private TableColumn<Product,Double> tableQuantity;

    @FXML
    private TableColumn<Product,Double> tableTotalPrice;

    @FXML
    private TextField totalCurrent;


    @FXML
    private CheckBox ispaid;



    private BabyProduct babyProduct;
    private BasicHouseHolds basicHouseHolds;
    private Beverage beverage;
    private Fish fish;
    private Meat meat;
    private Vegetables vegetables;
    private Fruit fruit;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        catagorySelect.setItems(catagoryList);

        tableName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tablePrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        tableQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));


    }





    public void castCatagory(ActionEvent actionEvent) {

        value = catagorySelect.getValue().toString();
        System.out.println(value);
    }

    private double totalBill = 0.0;
    public void addButton(ActionEvent actionEvent) {

        String name = productNameField.getText();


        double buyPriceTag = parseDouble(buyPrice.getText());

        double price;
        try{
            price = parseDouble(productPriceField.getText());
        }catch (Exception e){
            System.out.println(e);
            price = 0.0;
        }
        double quantity;
        try {
            quantity = parseDouble(productQuantityField.getText());
        }catch (Exception e){
            System.out.println(e);
            quantity = 0;
        }
        String id = productIdField.getText();

        IdChecker idChecker = new IdChecker(productMaintain);
        boolean bool = false;

        try{
            bool = idChecker.checkProductId(id);
        }catch (NullPointerException e){
            System.out.println(e);
            System.out.println(bool);
        }


        if(bool == true){

            switch (value) {
                case "Beverage":{
                    beverage = new Beverage(name,price,quantity,id);

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("ConFirm");
                    alert.setHeaderText(null);
                    alert.setContentText("Product is added");

                    alert.showAndWait();


                    productNameField.setText("");
                    productIdField.setText("");
                    productPriceField.setText("");
                    productPriceField.setText("");
                    productQuantityField.setText("");
                    buyPrice.setText("");

                    productMaintain.addProduct(beverage);
                    pList.add(beverage);
                    table.getItems().add(beverage);
                    System.out.println(beverage.totalPrice);
                    double totalBill1 = buyPriceTag * quantity;
                    totalCurrent.setText(String.valueOf(totalBill1));
                    totalBill += buyPriceTag * quantity;
                    tBill.setText(String.valueOf(totalBill));

                    System.out.println(beverage.toString());

                    break;
                }

                case "Fish":{
                    fish = new Fish(name,price,quantity,id);

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("ConFirm");
                    alert.setHeaderText(null);
                    alert.setContentText("Product is added");

                    alert.showAndWait();


                    productNameField.setText("");
                    productIdField.setText("");
                    productPriceField.setText("");
                    productPriceField.setText("");
                    productQuantityField.setText("");
                    buyPrice.setText("");



                    productMaintain.addProduct(fish);
                    pList.add(fish);
                    table.getItems().add(fish);
                    System.out.println(fish.totalPrice);
                    double totalBill1 = buyPriceTag * quantity;
                    totalCurrent.setText(String.valueOf(totalBill1));
                    totalBill += buyPriceTag * quantity;
                    tBill.setText(String.valueOf(totalBill));
                    System.out.println(fish);
                    break;
                }

                case "Fruit":{
                    fruit = new Fruit(name,price,quantity,id);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("ConFirm");
                    alert.setHeaderText(null);
                    alert.setContentText("Product is added");

                    alert.showAndWait();


                    productNameField.setText("");
                    productIdField.setText("");
                    productPriceField.setText("");
                    productPriceField.setText("");
                    productQuantityField.setText("");
                    buyPrice.setText("");

                    productMaintain.addProduct(fruit);
                    pList.add(fruit);
                    table.getItems().add(fruit);
                    System.out.println(fruit.totalPrice);
                    double totalBill1 = buyPriceTag * quantity;
                    totalCurrent.setText(String.valueOf(totalBill1));
                    totalBill += buyPriceTag * quantity;
                    tBill.setText(String.valueOf(totalBill));
                    System.out.println(fruit);
                    break;
                }

                case "Meat":{
                    meat = new Meat(name,price,quantity,id);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("ConFirm");
                    alert.setHeaderText(null);
                    alert.setContentText("Product is added");

                    alert.showAndWait();


                    productNameField.setText("");
                    productIdField.setText("");
                    productPriceField.setText("");
                    productPriceField.setText("");
                    productQuantityField.setText("");
                    buyPrice.setText("");

                    productMaintain.addProduct(meat);
                    pList.add(meat);
                    table.getItems().add(meat);
                    System.out.println(meat.totalPrice);
                    double totalBill1 = buyPriceTag * quantity;
                    totalCurrent.setText(String.valueOf(totalBill1));
                    totalBill += buyPriceTag * quantity;
                    tBill.setText(String.valueOf(totalBill));
                    System.out.println(meat);
                    break;
                }

                case "Basic Households":{
                    basicHouseHolds = new BasicHouseHolds(name,price,quantity,id);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("ConFirm");
                    alert.setHeaderText(null);
                    alert.setContentText("Product is added");

                    alert.showAndWait();


                    productNameField.setText("");
                    productIdField.setText("");
                    productPriceField.setText("");
                    productPriceField.setText("");
                    productQuantityField.setText("");
                    buyPrice.setText("");

                    productMaintain.addProduct(basicHouseHolds);
                    pList.add(basicHouseHolds);
                    table.getItems().add(basicHouseHolds);
                    System.out.println(basicHouseHolds.totalPrice);
                    double totalBill1 = buyPriceTag * quantity;
                    totalCurrent.setText(String.valueOf(totalBill1));
                    totalBill += buyPriceTag * quantity;
                    tBill.setText(String.valueOf(totalBill));
                    System.out.println(basicHouseHolds);
                    break;
                }

                case "Baby Product":{
                    babyProduct = new BabyProduct(name,price,quantity,id);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("ConFirm");
                    alert.setHeaderText(null);
                    alert.setContentText("Product is added");

                    alert.showAndWait();


                    productNameField.setText("");
                    productIdField.setText("");
                    productPriceField.setText("");
                    productPriceField.setText("");
                    productQuantityField.setText("");
                    buyPrice.setText("");

                    productMaintain.addProduct(babyProduct);
                    pList.add(babyProduct);
                    table.getItems().add(babyProduct);
                    System.out.println(babyProduct.totalPrice);
                    double totalBill1 = buyPriceTag * quantity;
                    totalCurrent.setText(String.valueOf(totalBill1));
                    totalBill += buyPriceTag * quantity;
                    tBill.setText(String.valueOf(totalBill));
                    System.out.println(babyProduct);
                    break;
                }

                case "Vegetables":{
                    vegetables = new Vegetables(name,price,quantity,id);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("ConFirm");
                    alert.setHeaderText(null);
                    alert.setContentText("Product is added");

                    alert.showAndWait();


                    productNameField.setText("");
                    productIdField.setText("");
                    productPriceField.setText("");
                    productPriceField.setText("");
                    productQuantityField.setText("");
                    buyPrice.setText("");

                    productMaintain.addProduct(vegetables);
                    pList.add(vegetables);
                    table.getItems().add(vegetables);
                    System.out.println(vegetables.totalPrice);
                    double totalBill1 = buyPriceTag * quantity;
                    totalCurrent.setText(String.valueOf(totalBill1));
                    totalBill += buyPriceTag * quantity;
                    tBill.setText(String.valueOf(totalBill));
                    System.out.println(vegetables);
                    break;
                }

                default:{
                    Product product = new Product(name,price,quantity,id);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("ConFirm");
                    alert.setHeaderText(null);
                    alert.setContentText("Product is added");

                    alert.showAndWait();


                    productNameField.setText("");
                    productIdField.setText("");
                    productPriceField.setText("");
                    productPriceField.setText("");
                    productQuantityField.setText("");
                    buyPrice.setText("");

                    pList.add(product);
                    table.getItems().add(product);
                    System.out.println(product.totalPrice);
                    double totalBill1 = buyPriceTag * quantity;
                    totalCurrent.setText(String.valueOf(totalBill1));
                    totalBill += buyPriceTag * quantity;
                    tBill.setText(String.valueOf(totalBill));

                    productMaintain.addProduct(product);
                    break;
                }
            }

        }

        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING");
            alert.setHeaderText(null);
            alert.setContentText("The Given Id Is Not Available !");

            alert.showAndWait();

            productNameField.setText("");
            productIdField.setText("");
            productPriceField.setText("");
            productPriceField.setText("");
            productQuantityField.setText("");
            buyPrice.setText("");
        }




    }

    int button = 0;
    public void paidBox(ActionEvent actionEvent) {

      button++;
    }

    public void confirmation(ActionEvent actionEvent) throws IOException {

        if(button > 0){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/mainMenu.fxml"));
            Parent loginPrent = loader.load();
            Scene scene = new Scene(loginPrent);

            Stage profileStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            profileStage.setScene(scene);
            profileStage.setResizable(false);
            profileStage.show();
        }

        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING");
            alert.setHeaderText(null);
            alert.setContentText("Check The Paid Box !");

            alert.showAndWait();

            productNameField.setText("");
            productIdField.setText("");
            productPriceField.setText("");
            productPriceField.setText("");
            productQuantityField.setText("");
            buyPrice.setText("");

        }
    }
}
