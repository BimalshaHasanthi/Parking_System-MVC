package controller;

import com.jfoenix.controls.JFXTextField;
import com.sun.glass.ui.Window;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Driver;
import model.Vehicle;

import java.io.IOException;

import static controller.DataListController.*;

public class AddDriverFormController {
    public AnchorPane addDriverContext;
    public AnchorPane addDriverContextMain;
    public JFXTextField txtAddDriverName;
    public JFXTextField txtAddNIC;
    public JFXTextField txtAddDrivingLicenseNo;
    public JFXTextField txtContactNo;
    public JFXTextField txtAddress;
    private static int countDriver=0;


    public void cancelAddDriverOnAction(ActionEvent actionEvent) throws IOException {
        //addDriverContextMain.getChildren().clear();
        //addDriverContextMain.setVisible(false);
        Stage window = (Stage) addDriverContextMain.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ManagementDashBoardForm.fxml"))));
        //window.initStyle(StageStyle.UNDECORATED);
    }
   public void addDriverOnAction(ActionEvent actionEvent) throws IOException {
       //  Driver driver1= new Driver(txtAddDriverName.getText(),txtAddNIC.getText(),txtAddDrivingLicenseNo.getText(), txtAddress.getText(),txtContactNo.getText());

       ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


       if(!txtAddDriverName.getText().equals("") && !txtAddDrivingLicenseNo.getText().equals("") && !txtAddress.getText().equals("") && !txtAddNIC.getText().equals("") && !txtContactNo.getText().equals("")){
           if(countDriver<16){
               driverDetailList[nextIndex()]=new Driver(txtAddDriverName.getText(),txtAddNIC.getText(),txtAddDrivingLicenseNo.getText(),txtContactNo.getText(),txtAddress.getText());
               countDriver++;
               addDriverContextMain.getChildren().add(FXMLLoader.load(getClass().getResource("../view/ManagementDashBoardForm.fxml")));
           }
       }
/*
       try {
            Driver driver1 = new Driver(txtAddDriverName.getText(), (String) txtAddNIC.getText(), txtAddDrivingLicenseNo.getText(), txtAddress.getText(), txtContactNo.getText());
            if (txtAddNIC.getText().equals("")& txtAddDriverName.getText().equals("")) {
                new Alert(Alert.AlertType.CONFIRMATION, "Invalid Input ", ButtonType.OK).show();
            } else {
                if (driverDetailList.add(driver1)) {
                    txtAddDriverName.clear();
                    txtAddNIC.clear();
                    txtAddDrivingLicenseNo.clear();
                    txtAddress.clear();
                    txtContactNo.clear();
                    //initialize();
                    System.out.println(vehicleDetailList.toString());
                    new Alert(Alert.AlertType.CONFIRMATION, "Vehicle details saved successfully", ButtonType.OK).show();
                }

            }

        } catch(NumberFormatException e){
            new Alert(Alert.AlertType.WARNING, "Please try again..!\n Fill all data Or Enter correct data format.. ", ButtonType.CLOSE).show();
        }
        //Stage stage = (Stage) AddDriverContext.getScene().getWindow();
        //stage.close();

    }*/

   }
    private int nextIndex() {
        Driver[] list=driverDetailList;
        int nextIndex=0;
        for(int i=0;i<list.length;i++){
            if(list[i]==null){
                nextIndex=i;
                break;
            }
        }
        return nextIndex;
    }
}
