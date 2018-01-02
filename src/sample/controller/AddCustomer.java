package sample.controller;
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
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class AddCustomer implements Initializable{

    CustomerMaintain customerMaintain;
    public AddCustomer(){
        customerMaintain = CustomerMaintain.getInstance();
    }

    ObservableList<String> selectedTypeList = FXCollections.observableArrayList("Beginner","Golden");

    @FXML
    private TextField customerName;

    @FXML
    private TextField customerId;

    @FXML
    private TextField customerTotalBrought;

    @FXML
    private ComboBox<String> selectedType;
    private String value;
    private BeginnerCustomer customer;
    private GoldenCustomer customer2;



    public void addNewCustomer(ActionEvent actionEvent) {

        String customerNameForAdding = customerName.getText();
        String customerIdForAdding = customerId.getText();
        double custommerTotalBroughtForAdding = Double.parseDouble(customerTotalBrought.getText());
        String value1 = value;

        IdChecker idChecker = new IdChecker(customerMaintain);
        boolean bool = false;

        try{
            bool = idChecker.checkCustomerId(customerIdForAdding);
        }catch (NullPointerException e){
            System.out.println(e);
            System.out.println(bool+"2");
        }

        if(bool == true){

            if(value.equals("Golden")){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("New "+value1+ " Customer Added SuccessFully !");

                alert.showAndWait();
                customer2 = new GoldenCustomer(customerNameForAdding,customerIdForAdding,custommerTotalBroughtForAdding,value1);
                customerMaintain.addCustomer(customer2);

                customerName.setText("");
                customerId.setText("");
                customerTotalBrought.setText("");

                System.out.println(customer2);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("New "+value1 +" Customer Added SuccessFully !");

                alert.showAndWait();
                customer = new BeginnerCustomer(customerNameForAdding,customerIdForAdding,custommerTotalBroughtForAdding,value1);
                customerMaintain.addCustomer(customer);

                customerName.setText("");
                customerId.setText("");
                customerTotalBrought.setText("");

                System.out.println(customer);

            }

        }

        else{

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING");
            alert.setHeaderText(null);
            alert.setContentText("The Given Id Is Not Available !");

            alert.showAndWait();


            customerName.setText("");
            customerId.setText("");
            customerTotalBrought.setText("");


        }



    }

    public void backToThePreviousMenu(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/mainMenu.fxml"));
        Parent loginPrent = loader.load();
        Scene scene = new Scene(loginPrent);

        Stage profileStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        profileStage.setScene(scene);
        profileStage.setResizable(false);
        profileStage.show();

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        selectedType.setItems(selectedTypeList);
    }

    public void typingCast(ActionEvent actionEvent) {
        value = selectedType.getValue();
    }
}
