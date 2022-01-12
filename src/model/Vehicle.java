package model;

public class Vehicle {
    private String vehicleNumber;
    //private String vehicleType;
    private int maxWeight;
    private int passengerCount;
    private String vehicleStatus;

    public Vehicle() {

    }
    public Vehicle(String vehicleNumber,  int maxWeight, int passengerCount, String vehicleStatus) {
        this.vehicleNumber = vehicleNumber;
        //this.vehicleType = vehicleType;
        this.maxWeight = maxWeight;
        this.passengerCount = passengerCount;
        this.vehicleStatus = vehicleStatus;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    /*public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
*/
    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    public String getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(String vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public void park(){

        this.setVehicleStatus("Parked");
    }
    public void depart(){

        this.setVehicleStatus("OnDelivery");
    }



}
