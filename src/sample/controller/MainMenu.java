package sample.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenu {

    public void addCustomerButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/addCustomer.fxml"));
        Parent loginPrent = loader.load();
        Scene scene = new Scene(loginPrent);

        Stage profileStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        profileStage.setScene(scene);
        profileStage.setResizable(false);
        profileStage.show();
    }

    public void searchCustomerButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/searchCustomer.fxml"));
        Parent loginPrent = loader.load();
        Scene scene = new Scene(loginPrent);

        Stage profileStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        profileStage.setScene(scene);
        profileStage.setResizable(false);
        profileStage.show();
    }

    public void deleteCustomerButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/searchCustomer.fxml"));
        Parent loginPrent = loader.load();
        Scene scene = new Scene(loginPrent);

        Stage profileStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        profileStage.setScene(scene);
        profileStage.setResizable(false);
        profileStage.show();
    }

    public void updateCustomerButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/searchCustomer.fxml"));
        Parent loginPrent = loader.load();
        Scene scene = new Scene(loginPrent);

        Stage profileStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        profileStage.setScene(scene);
        profileStage.setResizable(false);
        profileStage.show();
    }

    public void addProductsButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/buyProduct.fxml"));
        Parent loginPrent = loader.load();
        Scene scene = new Scene(loginPrent);

        Stage profileStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        profileStage.setScene(scene);
        profileStage.setResizable(false);
        profileStage.show();

    }

    public void sellProductsButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sellProduct.fxml"));
        Parent loginPrent = loader.load();
        Scene scene = new Scene(loginPrent);

        Stage profileStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        profileStage.setScene(scene);
        profileStage.setResizable(false);
        profileStage.show();
    }

    public void updateProductsButton(ActionEvent actionEvent) {
    }

    public void searchProductButton(ActionEvent actionEvent) {
    }

    public void checkBalanceButton(ActionEvent actionEvent) {
    }

    public void backTothePreviousButton(ActionEvent actionEvent) {
    }

    public void exitButton(ActionEvent actionEvent) {

        System.exit(0);

    }
}
