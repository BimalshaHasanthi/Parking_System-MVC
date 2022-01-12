package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.*;

import java.io.IOException;

import static controller.DataListController.vehicleDetailList;

public class AddVehicleFormController {
    public AnchorPane addVehicleContext;
    public AnchorPane addVehiclecontext2;
    public AnchorPane addVehicleContextMain;
    public JFXTextField txtAddVehicleNumber;
    public JFXTextField txtAddMaxWeigh;
    public JFXTextField txtAddNoOfPassenger;
    public JFXComboBox cmbAddVehicleType;


    private String selectedType="";
    private static int busCount=0;
    private static int vanCount=0;
    private static int cargoLorryCount=0;
    public void initialize(){
        cmbAddVehicleType.getItems().addAll("Bus","Van","Cargo Lorry");
        cmbAddVehicleType.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedType=(String)newValue;
        });
    }
    public void cancelAddVehicleOnAction(ActionEvent actionEvent) throws IOException {
        //addVehicleContextMain.getChildren().clear();
        Stage window = (Stage) addVehicleContextMain.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ManagementDashBoardForm.fxml"))));
        //window.initStyle(StageStyle.UNDECORATED);
    }
    public void addVehicleOnAction(ActionEvent actionEvent) throws IOException {

       // Driver driver1= new Driver(txtAddVehicleNumber.getText(),txtAddMaxWeigh.getText(),txtAddNoOfPassenger.getText(), cmbAddVehicleType);

        if(!txtAddVehicleNumber.getText().equals("") && !selectedType.equals("") && !txtAddMaxWeigh.getText().equals("") && !txtAddNoOfPassenger.getText().equals("")){
            if(selectedType.equals("Bus")){
                if(busCount<1){
                    vehicleDetailList[nextIndex()]=new Bus(txtAddVehicleNumber.getText(),Integer.valueOf(txtAddMaxWeigh.getText()),Integer.valueOf(txtAddNoOfPassenger.getText()),"Not Assigned");
                    busCount++;
                    addVehicleContextMain.getChildren().add(FXMLLoader.load(getClass().getResource("../view/ManagementDashBoardForm.fxml")));
                }
            }else if(selectedType.equals("Van")){
                if(vanCount<6){
                    vehicleDetailList[nextIndex()]=new Van(txtAddVehicleNumber.getText(),Integer.valueOf(txtAddMaxWeigh.getText()),Integer.valueOf(txtAddNoOfPassenger.getText()),"Not Assigned");
                    vanCount++;
                    addVehicleContextMain.getChildren().add(FXMLLoader.load(getClass().getResource("../view/ManagementDashBoardForm.fxml")));
                }
            }else if(selectedType.equals("Cargo Lorry")){
                if(cargoLorryCount<6){
                    vehicleDetailList[nextIndex()]=new CargoLorry(txtAddVehicleNumber.getText(),Integer.valueOf(txtAddMaxWeigh.getText()),Integer.valueOf(txtAddNoOfPassenger.getText()),"Not Assigned");
                    cargoLorryCount++;
                    addVehicleContextMain.getChildren().add(FXMLLoader.load(getClass().getResource("../view/ManagementDashBoardForm.fxml")));
                }
            }
            selectedType="";
        }
        selectedType="";

        /*
       try {
            if () {
                new Alert(Alert.AlertType.CONFIRMATION, "Invalid Input ", ButtonType.OK).show();
            } else {
                    //initialize();
                    System.out.println(vehicleDetailList.toString());
                    new Alert(Alert.AlertType.CONFIRMATION, "Vehicle details saved successfully", ButtonType.OK).show();
                }
            }

        } catch(NumberFormatException e){
            new Alert(Alert.AlertType.WARNING, "Please try again..!\n Fill all data Or Enter correct data format.. ", ButtonType.CLOSE).show();
        }
        //stage.close();

    }*/
    }
    private int nextIndex() {
        Vehicle[] list=vehicleDetailList;
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
