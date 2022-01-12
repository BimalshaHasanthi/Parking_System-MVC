package model;

public class Bus extends Vehicle{
    public Bus() {
    }

    public Bus(String vehicleNumber,  int maxWeight, int passengerCount, String vehicleStatus) {
        super(vehicleNumber, maxWeight, passengerCount, vehicleStatus);
    }
}
