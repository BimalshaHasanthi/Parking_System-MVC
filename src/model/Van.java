package model;

public class Van extends Vehicle {
    public Van() {
    }

    public Van(String vehicleNumber,  int maxWeight, int passengerCount, String vehicleStatus) {
        super(vehicleNumber, maxWeight, passengerCount, vehicleStatus);
    }
}
