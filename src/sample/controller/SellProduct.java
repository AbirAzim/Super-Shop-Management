package sample.controller;

import Product.Product;
import Product.ProductMaintain;
import customer.BeginnerCustomer;
import customer.Customer;
import customer.CustomerMaintain;
import customer.GoldenCustomer;
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
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.collections.FXCollections.observableArrayList;

public class SellProduct implements Initializable{
    ProductMaintain productMaintain;
    CustomerMaintain customerMaintain;

    public SellProduct(){ productMaintain = ProductMaintain.getInstance(); customerMaintain = CustomerMaintain.getInstance();}

    ObservableList<Product> pList2 = FXCollections.observableArrayList();

    @FXML
    private TextField productId;

    @FXML
    private TextField productQuantity;

    @FXML
    private TextField customerId;

    @FXML
    private TextField name;

    @FXML
    private TextField type;

    @FXML
    private TextField discount;

    @FXML
    private TableView<Product> table;

    @FXML
    private TableColumn<Product,String>nameTable;


    @FXML
    private TableColumn<Product,Double> priceTable;

    @FXML
    private TableColumn<Product,Double> quantityTable;

    @FXML
    private TextField current;

    @FXML
    private TextField totalBill;

    @FXML
    private TextField quantityFieldCurrent;

    @FXML
    private TextField raminingField;

    private double totalBill2;
    private double getTotalBill3 = 0.0;


    private Product p;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        nameTable.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceTable.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    public void AddToBazarList(ActionEvent actionEvent) {

        totalBill2 = 0;
        double quantity = Double.parseDouble(productQuantity.getText());
        String idForSearch = productId.getText();
        IdChecker idChecker = new IdChecker(productMaintain);
        p = idChecker.checkProductIdForSearch(idForSearch);
        double result = p.calculateCallingProductQuantity(quantity);
        System.out.println(result);
        System.out.println(p.currentlySellQuantity);

        if(result == -1 || p == null ){


            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING");
            alert.setHeaderText(null);
            alert.setContentText("The Given Quantity is Out Of Bound !");

            alert.showAndWait();


        }
        else {

            pList2.add(p);
            table.getItems().add(p);
            quantityFieldCurrent.setText(String.valueOf(p.currentlySellQuantity));
            raminingField.setText(String.valueOf(p.getQuantity()));

            totalBill2 = p.currentlySellQuantity * p.getPrice();
            getTotalBill3 += totalBill2;
            current.setText(String.valueOf(totalBill2));
            totalBill.setText(String.valueOf(getTotalBill3));

        }


    }

    private double discount2 = 0.0;
    private Customer c;

    public void searchCustomer(ActionEvent actionEvent) {

        IdChecker idChecker = new IdChecker(customerMaintain);
        String idForSearchCustomer = customerId.getText();
        c = idChecker.checkCustomerIdforSearch(idForSearchCustomer);


        name.setText(c.getName());
        discount2 = 0.0;

        if(c != null){
            if(c instanceof GoldenCustomer) {

                GoldenCustomer gc = new GoldenCustomer("name","Id",0.0,"Golden");
                type.setText(gc.getCustomerType());
                discount.setText(String.valueOf(gc.getDiscount()));
                discount2 = gc.getDiscount();

            }
            else{

                BeginnerCustomer bc = new BeginnerCustomer("name","Id",0.0,"Beginner");
                type.setText(bc.getCustomerType());
                discount.setText(String.valueOf(bc.getDiscount()));
                discount2 = bc.getDiscount();

            }
        }
    }

    private int button = 0;
    public void isPaid(ActionEvent actionEvent) {
        button++;
        double bal = ((100 - discount2) / 100) * getTotalBill3;
        totalBill.setText(String.valueOf(bal));

        if(c != null){
            c.setTotalBrought(bal);
        }

    }

    public void sellProduct(ActionEvent actionEvent) throws IOException {
        if(button>0){

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("ConFirm");
            alert.setHeaderText(null);
            alert.setContentText("Products is Sold");

            alert.showAndWait();

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
            alert.setContentText("Select The Paid Button");

            alert.showAndWait();



        }
    }
}
