package sample.controller;

import Admin.AdminMaintain;
import Admin.Admin;
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

public class CreateAdmin {

    AdminMaintain adminMaintain;

    public CreateAdmin(){
        adminMaintain = AdminMaintain.getInstance();
    }

    @FXML
    private TextField adminName;

    @FXML
    private TextField adminPassword;

    @FXML
    private TextField adminReTypedPassword;

    @FXML
    private TextField adminId;

    private Admin admin;



    public void createNewAdmin(ActionEvent actionEvent) throws IOException {

        String userName = adminName.getText();
        String password = adminPassword.getText();
        String rePassword = adminReTypedPassword.getText();
        String adminid = adminId.getText();

        //Id should be unique i dont want to use uuid class here
        IdChecker idChecker = new IdChecker(adminMaintain);

        //try and catch for null pointer exception
        boolean bool = false;
        try {
            bool = idChecker.checkAdminId(adminid);
        }
        catch (NullPointerException e){
            System.out.println(e);
            bool = true;
        }



        if(bool == true){

            if(! password.equals(rePassword) || adminId.getText().equals("") || adminName.getText().equals("") || adminPassword.getText().equals("") ){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Something went Wrong , Fill Proper Information!!");

                alert.showAndWait();
                adminName.setText("");
                adminPassword.setText("");
                adminReTypedPassword.setText("");
                adminId.setText("");
            }

            else{

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirm");
                alert.setHeaderText(null);
                alert.setContentText("Added New Admin !");

                alert.showAndWait();

                admin = new Admin(userName,adminid,rePassword);
                System.out.println(admin.toString());
                adminMaintain.addAdmin(admin);
                adminName.setText("");
                adminPassword.setText("");
                adminReTypedPassword.setText("");
                adminId.setText("");
            }

        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING");
            alert.setHeaderText(null);
            alert.setContentText("WARNING ID IS NOT AVAILABLE !");

            alert.showAndWait();

            adminName.setText("");
            adminPassword.setText("");
            adminReTypedPassword.setText("");
            adminId.setText("");
        }


    }

    public void backToThePreviousWindow(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/login.fxml"));
        Parent loginPrent = loader.load();
        Scene scene = new Scene(loginPrent);

        Stage profileStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        profileStage.setScene(scene);
        profileStage.setResizable(false);
        profileStage.show();
    }
}
