package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.OnDeliveryShift;

public class OnDeliveryFormController {
    public TableView tblOnDelivery;
    public TableColumn colVehicleNo;
    public TableColumn colVehicleType;
    public TableColumn colDriverName;
    public TableColumn colLeftTime;

    public void initialize(){
        OnDeliveryShift[] tableList=new OnDeliveryShift[listLength(DataListController.onDeliveryList)];
        for(int i=0;i<tableList.length;i++){
            tableList[i]=DataListController.onDeliveryList[i];
        }
        ObservableList<OnDeliveryShift> ob= FXCollections.observableArrayList();
        for(OnDeliveryShift record:tableList) {
            ob.add(record);
        }
        tblOnDelivery.setItems(ob);
        colVehicleNo.setCellValueFactory(new PropertyValueFactory<>("vehicleNo"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colDriverName.setCellValueFactory(new PropertyValueFactory<>("driverName"));
        colLeftTime.setCellValueFactory(new PropertyValueFactory<>("leftTime"));
    }

    private int listLength(OnDeliveryShift[] onDeliveryList) {
        int nextIndex=0;
        for(int i=0;i<onDeliveryList.length;i++){
            if(onDeliveryList[i]==null){
                nextIndex=i;
                break;
            }
        }
        return nextIndex;
    }

}
