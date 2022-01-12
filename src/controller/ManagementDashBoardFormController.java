package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ManagementDashBoardFormController {
    public AnchorPane loadWindowContext;
    public AnchorPane dashBordLoadContext;

    public void inParkingOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/InParkingForm.fxml");
        Parent load = FXMLLoader.load(resource);
        loadWindowContext.getChildren().add(load);
    }

    public void onDeliveryOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/OnDeliveryForm.fxml");
        Parent load = FXMLLoader.load(resource);
        loadWindowContext.getChildren().add(load);
    }

    public void addDriverOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddDriverForm.fxml");
        Parent load = FXMLLoader.load(resource);
        dashBordLoadContext.getChildren().add(load);
    }

    public void addVehicleOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddVehicleForm.fxml");
        Parent load = FXMLLoader.load(resource);
        dashBordLoadContext.getChildren().add(load);
    }

    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DriverViewForm.fxml");
        Parent load = FXMLLoader.load(resource);
        dashBordLoadContext.getChildren().add(load);
    }
}
