package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.InParking;

public class InParkingFormController {


    public TableView tblInParking;
    public TableColumn colVehicleName;
    public TableColumn colVehicleType;
    public TableColumn colParkingSlot;
    public TableColumn colParkedTime;
    public TableColumn colVehicleNo;

    public void initialize(){
        InParking[] tableList=new InParking[listLength(DataListController.parkedList)];
        for(int i=0;i<tableList.length;i++){
            tableList[i]=DataListController.parkedList[i];
        }
        ObservableList<InParking> ob= FXCollections.observableArrayList();
        for(InParking record:tableList) {
            ob.add(record);
        }
        tblInParking.setItems(ob);
        colVehicleNo.setCellValueFactory(new PropertyValueFactory<>("vehicleNo"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colParkingSlot.setCellValueFactory(new PropertyValueFactory<>("parkingSlot"));
        colParkedTime.setCellValueFactory(new PropertyValueFactory<>("parkedTime"));
    }
    private int listLength(InParking[] parkedList) {
        int nextIndex=0;
        for(int i=0;i<parkedList.length;i++){
            if(parkedList[i]==null){
                nextIndex=i;
                break;
            }
        }
        return nextIndex;

    }

}
