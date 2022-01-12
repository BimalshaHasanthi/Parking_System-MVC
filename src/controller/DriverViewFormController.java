package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import static controller.DataListController.*;

public class DriverViewFormController {

    public JFXComboBox cmbVehicleNo;
    public AnchorPane driverViewFormContext;
    public AnchorPane driverViewFormContext2;
    public AnchorPane driverViewFormContext3;
    public Label lblDate;
    public Label lblTime;
    public JFXTextField txtVehicleType;
    public JFXComboBox cmbDriver;
    public Label lblSlotNumber;
    public JFXButton onDelivery;
    public JFXButton btnPark;
    public AnchorPane lblDriver;
    public Label lblDriver2;
    public JFXButton btnOnDelivery;
    private int lastVehicle=-1;
    private int lastDriver=-1;
    private int lastSlot=-1;

    public void initialize(){
        setDateAndTime();
        String[] vehicleList1 = getVehicleList1();
        cmbVehicleNo.getItems().addAll(vehicleList1);
        cmbVehicleNo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String vehicle=(String)newValue;
            int index=findIndex(vehicle,vehicleList1);
            lastVehicle=index;
            setDateAndTime();
            setVehicleType(lastVehicle);
            if(lastDriver<0 && vehicleDetailList[lastVehicle].getVehicleStatus().equals("OnDelivery")){
                String onDeliveryDriver1=findOnDeliveryDriver(vehicle);
                lblDriver2.setText(onDeliveryDriver1);
            }else if(lastDriver<0 && !vehicleDetailList[lastVehicle].getVehicleStatus().equals("OnDelivery")){
                lblDriver2.setText("");
            }
            selectSlot();
            System.out.println(newValue);
        });
        String[] driverList1 = getDriverList1();
        cmbDriver.getItems().addAll(driverList1);
        cmbDriver.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String driver=(String)newValue;
            if(lastVehicle>=0)lblDriver2.setText("");
            int index=findIndex(driver,driverList1);
            lastDriver=index;
            setDateAndTime();
            System.out.println(newValue);
        });
    }
    private void selectSlot() {
        Vehicle vehicle=DataListController.vehicleDetailList[lastVehicle];
        String status = vehicle.getVehicleStatus();
        if(!status.equals("Parked")){
            for(int i=0;i<DataListController.parkingSlotList.length;i++){
                if(DataListController.parkingSlotList[i].getVehicleType().equals(txtVehicleType.getText()) && DataListController.parkingSlotList[i].isAvailability()){
                    lblSlotNumber.setText(String.valueOf(DataListController.parkingSlotList[i].getSlotId()));
                    lastSlot=i;
                    break;
                }
            }
        }
    }
    private String[] getDriverList1() {
        int arrayLength = getArrayLength(DataListController.driverDetailList);
        String[] driverList1=new String[arrayLength];
        for(int i=0;i<driverList1.length;i++){
            driverList1[i]=DataListController.driverDetailList[i].getName();
        }
        return driverList1;
    }
    private String[] getVehicleList1() {
        int arrayLength = getArrayLength(vehicleDetailList);
        String[] vehicleList1=new String[arrayLength];
        for(int i=0;i<vehicleList1.length;i++){
            vehicleList1[i]= vehicleDetailList[i].getVehicleNumber();
        }
        return vehicleList1;
    }
    private int getArrayLength(Object[] vehicleDetailList) {
        int num=0;
        for(int i=0;i<vehicleDetailList.length;i++){
            if(vehicleDetailList[i]==null){
                break;
            }
            num++;
        }
        return num;
    }
    private int findIndex(String element, String[] list) {
        int index=0;
        for(int i=0;i<list.length;i++){
            if(element.equals(list[i])){
                index=i;
            }
        }
        return index;
    }
    private void setVehicleType(int id) {
        String type= vehicleDetailList[id].getClass().getName().substring(6);
        if(type.equals("CargoLorry")){
            type="Cargo Lorry";
        }
        txtVehicleType.setText(type);
    }
    private String findOnDeliveryDriver(String vehicle) {
        String driver="";
        int lastIndex=nextIndex(onDeliveryList)-1;
        for(int i=lastIndex;i>=0;i--){
            if(onDeliveryList[i].getVehicleNo().equals(vehicle)){
                driver=onDeliveryList[i].getDriverName();
            }
        }
        return driver;
    }
    private int nextIndex(Object[] list) {
        int nextIndex=0;
        for(int i=0;i<list.length;i++){
            if(list[i]==null){
                nextIndex=i;
                break;
            }
        }
        return nextIndex;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void loginFormOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/LoginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        driverViewFormContext.getChildren().add(load);
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void setDateAndTime(){
        lblDate.setText(new SimpleDateFormat("dd MMM yyyy").format(new Date()));
        lblTime.setText(new SimpleDateFormat("hh:mm a").format(new Date()));
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void parkAndDeliveryShiftOnAction(ActionEvent actionEvent) throws IOException {
        if(lastVehicle>=0 && (lastDriver>=0 || !lblDriver2.getText().equals(""))){
            Vehicle vehicle=DataListController.vehicleDetailList[lastVehicle];
            String status=vehicle.getVehicleStatus();
            Driver driver=null;
            if(lastDriver>=0){
                driver=DataListController.driverDetailList[lastDriver];
            }else if(!lblDriver2.getText().equals("")){
                for(Driver d:driverDetailList){
                    if(d.getName().equals(lblDriver2.getText())){
                        driver=d;
                        break;
                    }
                }
            }
            if(status.equals("Not Assigned")){
                save(actionEvent.getSource(),vehicle,driver);
            }else if(status.equals("Parked")){
                if(actionEvent.getSource()==btnOnDelivery){
                    save(actionEvent.getSource(),vehicle,driver);
                }
            }else if(status.equals("OnDelivery")){
                if(actionEvent.getSource()==btnPark){
                    save(actionEvent.getSource(),vehicle,driver);
                }
            }
        }
    }
    private void save(Object source, Vehicle vehicle, Driver driver) throws IOException {
        String status = vehicle.getVehicleStatus();
        System.out.println("Old Status : "+status);
        if(source==btnPark){
            vehicle.park();
            DataListController.parkingSlotList[lastSlot].setAvailability(false);
            int nextIndex=nextIndex(DataListController.parkedList);
            if(nextIndex==DataListController.parkedList.length){
                DataListController.parkedList=expand(DataListController.parkedList);
            }
            InParking record=new InParking(vehicle.getVehicleNumber(),txtVehicleType.getText(),String.valueOf(DataListController.parkingSlotList[lastSlot].getSlotId()),lblDate.getText()+" - "+lblTime.getText());
            DataListController.parkedList[nextIndex]=record;
        }else if(source==btnOnDelivery){
            if(vehicle.getVehicleStatus().equals("Parked")){
                Slot previousSlot=findPreviousSlot(vehicle.getVehicleNumber());
                previousSlot.setAvailability(true);
            }
            vehicle.depart();
            int nextIndex=nextIndex(onDeliveryList);
            if(nextIndex==onDeliveryList.length){
                onDeliveryList=expand(onDeliveryList);
            }
            OnDeliveryShift record=new OnDeliveryShift(vehicle.getVehicleNumber(),txtVehicleType.getText(),driver.getName(),lblDate.getText()+" - "+lblTime.getText());
            onDeliveryList[nextIndex]=record;
        }
        driverViewFormContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/DriverViewForm.fxml")));
        status = vehicle.getVehicleStatus();
        System.out.println("New Status : "+status);
        lastVehicle=-1;
        lastDriver=-1;
        lastSlot=-1;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   /* public void btnOnDeliveryOnAction(ActionEvent actionEvent) {
    }

    public void parkOnAction(ActionEvent actionEvent) {
    }*/
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private Slot findPreviousSlot(String vehicleNumber) {
        Slot previousSlot=null;
        int lastIndex=nextIndex(parkedList)-1;
        for(int i=lastIndex;i>=0;i--){
            if(parkedList[i].getVehicleNo().equals(vehicleNumber)){
                int slotId=Integer.valueOf(parkedList[i].getParkingSlot());
                previousSlot=parkingSlotList[slotId-1];
            }
        }
        return previousSlot;
    }

    private InParking[] expand(InParking[] parkedRecordList) {
        int arrayLength= parkedRecordList.length;
        InParking[] temp=new InParking[arrayLength*2];
        for(int i=0;i<arrayLength;i++){
            temp[i]= parkedRecordList[i];
        }
        parkedRecordList =temp;
        return parkedRecordList;
    }
    private OnDeliveryShift[] expand(OnDeliveryShift[] departedRecordList) {
        int arrayLength= departedRecordList.length;
        OnDeliveryShift[] temp=new OnDeliveryShift[arrayLength*2];
        for(int i=0;i<arrayLength;i++){
            temp[i]=departedRecordList[i];
        }
        departedRecordList=temp;
        return departedRecordList;
    }
}
