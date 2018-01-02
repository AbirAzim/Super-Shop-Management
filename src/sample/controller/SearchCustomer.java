package sample.controller;

import customer.BeginnerCustomer;
import customer.Customer;
import customer.CustomerMaintain;
import customer.GoldenCustomer;
import idChecker.IdChecker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SearchCustomer {

    CustomerMaintain customerMaintain;

    public SearchCustomer(){customerMaintain = CustomerMaintain.getInstance();}

    @FXML
    private TextField idField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField typeField;

    @FXML
    private TextField totalBroughtField;
    IdChecker idChecker;
    Customer customer;

    public void searchCustomer(ActionEvent actionEvent) {

        String id = idField.getText();
        idChecker = new IdChecker(customerMaintain);
        customer = idChecker.checkCustomerIdforSearch(id);


        if(customer != null){
            nameField.setText(String.valueOf(customer.getName()));
            if(customer instanceof BeginnerCustomer){
                typeField.setText("Beginner");
            }
            else typeField.setText("Golden");



            totalBroughtField.setText(String.valueOf(customer.getTotalBrought()));
        }

        else {
            nameField.setText("No Result Found");
            typeField.setText("No Result Found");
            totalBroughtField.setText("No Result Found");
        }

    }

    public void backButton(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/mainMenu.fxml"));
        Parent loginPrent = loader.load();
        Scene scene = new Scene(loginPrent);

        Stage profileStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        profileStage.setScene(scene);
        profileStage.setResizable(false);
        profileStage.show();

    }

    public void deleteCustomer(ActionEvent actionEvent) {


        if(customer != null){

           customerMaintain.deleteCustomer(customer);


            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("CONFIRM");
            alert.setHeaderText(null);
            alert.setContentText("The Selected Customer is Deleted");

            alert.showAndWait();
            idField.setText("");
            nameField.setText("");
            typeField.setText("");
            totalBroughtField.setText("");
        }

        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING");
            alert.setHeaderText(null);
            alert.setContentText("No Customer Is Found For Delete");

            alert.showAndWait();
            idField.setText("");
            nameField.setText("");
            typeField.setText("");
            totalBroughtField.setText("");
        }
    }

    public void UpdateCustomer(ActionEvent actionEvent) {

        if(customer != null){

            if(customer instanceof BeginnerCustomer){
                customer.setCustomerType("Golden");
                GoldenCustomer gc = new GoldenCustomer(customer.getName(),customer.getId(),customer.getTotalBrought(),customer.getCustomerType());
                customerMaintain.addCustomer(gc);
                customerMaintain.deleteCustomer(customer);
                customer = null;
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("CONFIRM");
                alert.setHeaderText(null);
                alert.setContentText("Up-Dated to Golden Customer!");

                alert.showAndWait();
                idField.setText("");
                nameField.setText("");
                typeField.setText("");
                totalBroughtField.setText("");
            }
            else {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("CONFIRM");
                alert.setHeaderText(null);
                alert.setContentText("Already Up-Dated !");

                alert.showAndWait();

            }
        }

        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING");
            alert.setHeaderText(null);
            alert.setContentText("Nothing to Update");

            alert.showAndWait();

        }


    }

    public void ResetField(ActionEvent actionEvent) {
        idField.setText("");
        nameField.setText("");
        typeField.setText("");
        totalBroughtField.setText("");
    }
}
