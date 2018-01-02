package sample.controller;

import  Admin.Admin;
import Admin.AdminMaintain;
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


public class Login {

    AdminMaintain adminMaintain;

    public Login(){
        adminMaintain = AdminMaintain.getInstance();
    }

    @FXML
    private TextField nameField;

    @FXML
    private TextField passwordField;


    public void loginButton(ActionEvent actionEvent) throws IOException {

        int size;//to see wheather the list of admin is available or not

        String adminName = nameField.getText();
        String passworField2 = passwordField.getText();

        try{
            size = adminMaintain.getAdminList().size();
        }
        catch (Exception e){
            System.out.println(e);
            size = 0;
        }
        if(size == 0){

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("No Admin AvailAble!");

                alert.showAndWait();
                nameField.setText("");
                passwordField.setText("");
        }

        else{
            for(Admin admin : adminMaintain.getAdminList()){
                if(admin.getPassword().equals(passworField2) && admin.getUserName().equals(adminName)){
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

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("InValid Information !");

                    alert.showAndWait();
                    nameField.setText("");
                    passwordField.setText("");


                }

            }

        }



    }

    public void resetButton(ActionEvent actionEvent) {

        nameField.setText("");
        passwordField.setText("");
    }

    public void createAccount(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/createAdmin.fxml"));
        Parent loginPrent = loader.load();
        Scene scene = new Scene(loginPrent);

        Stage profileStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        profileStage.setScene(scene);
        profileStage.setResizable(false);
        profileStage.show();

    }


}
