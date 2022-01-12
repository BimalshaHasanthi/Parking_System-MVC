package model;

import javafx.scene.layout.AnchorPane;

public class Slot {
    private int slotId;
    private boolean availability;
    private String vehicleType;

    public Slot() {
    }

    public Slot(int slotId, boolean availability, String vehicleType) {
        this.slotId = slotId;
        this.availability = availability;
        this.vehicleType = vehicleType;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}
