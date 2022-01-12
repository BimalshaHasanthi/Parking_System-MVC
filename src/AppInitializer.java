import controller.DataListController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.*;

import java.io.IOException;
import java.net.URL;

public class AppInitializer extends Application {

    public static void main(String[] args) {

        createSlotlist();
        //list1Driver();
       // list1Vehicle();

        launch(args);
    }

    private static void createSlotlist() {
        for(int i=0;i< DataListController.parkingSlotList.length;i++){
            Slot slot1=new Slot();
            slot1.setSlotId(i+1);
            slot1.setAvailability(true);
            if((i+1)==1||(i+1)==2||(i+1)==3||(i+1)==4||(i+1)==12||(i+1)==13){
                slot1.setVehicleType("Van");
            }else if((i+1)==14){
                slot1.setVehicleType("Bus");
            }else{
                slot1.setVehicleType("Cargo Lorry");
            }
            //slotX.setSlotPane(new AnchorPane());
            DataListController.parkingSlotList[i]=slot1;
        }
    }


    private static void list1Vehicle() {
        DataListController.vehicleDetailList[0]=new Bus("NA-3434",3500,60,"Not Assigned");
        DataListController.vehicleDetailList[1]=new Van("KA-4563",1000,7,"Not Assigned");
        DataListController.vehicleDetailList[2]=new Van("58-3567",1500,4,"Not Assigned");
        DataListController.vehicleDetailList[3]=new Van("GF-4358",800,4,"Not Assigned");
        DataListController.vehicleDetailList[4]=new Van("CCB-3568",1800,8,"Not Assigned");
        DataListController.vehicleDetailList[5]=new Van("LM-6679",1500,4,"Not Assigned");
        DataListController.vehicleDetailList[6]=new Van("QA-3369",1800,6,"Not Assigned");
        DataListController.vehicleDetailList[7]=new CargoLorry("KB-3668",2500,2,"Not Assigned");
        DataListController.vehicleDetailList[8]=new CargoLorry("JJ-9878",3000,2,"Not Assigned");
        DataListController.vehicleDetailList[9]=new CargoLorry("GH-5772",4000,3,"Not Assigned");
        DataListController.vehicleDetailList[10]=new CargoLorry("XY-4456",3500,2,"Not Assigned");
        DataListController.vehicleDetailList[11]=new CargoLorry("YQ-3536",2000,2,"Not Assigned");
        DataListController.vehicleDetailList[12]=new CargoLorry("CBB-3566",2500,2,"Not Assigned");
        DataListController.vehicleDetailList[13]=new CargoLorry("QH-3444",5000,4,"Not Assigned");
    }



    private static void list1Driver() {
        DataListController.driverDetailList[0]=new Driver("Sumith Kumara","7835348345V","B6474845","Panadura","0725637456");
        DataListController.driverDetailList[1]=new Driver("Amila Pathirana","8826253734V","B3354674","Galle","0717573583");
        DataListController.driverDetailList[2]=new Driver("Jithmal Perera","9283289272V","B3674589","Horana","0772452457");
        DataListController.driverDetailList[3]=new Driver("Sumith Dissanayaka","9425245373V","B8366399","Kaluthara","0782686390");
        DataListController.driverDetailList[4]=new Driver("Sumanasiri Herath","8976544373V","B3537538","Beruwala","0772534436");
        DataListController.driverDetailList[5]=new Driver("Awantha Fernando","9173537839V","B3554789","Colombo 5","0714534356");
        DataListController.driverDetailList[6]=new Driver("Charith Sudara","9573536833V","B6835836","Baththaramulla","0771536662");
        DataListController.driverDetailList[7]=new Driver("Prashan Dineth","9362426738V","B2683536","Wadduwa","0715353434");
        DataListController.driverDetailList[8]=new Driver("Chethiya Dilan","9162353436V","B6836836","Panadura","0772436737");
        DataListController.driverDetailList[9]=new Driver("Dushantha Perera","9255556343V","B3334435","Matara","0777245343");
        DataListController.driverDetailList[10]=new Driver("Sumith Udayanga","8735354355V","B3573783","Galle","0703635442");
        DataListController.driverDetailList[11]=new Driver("Dinesh Udara","9026344373V","B5343783","Hettimulla","0713456878");
        DataListController.driverDetailList[12]=new Driver("Udana Chathuranga","9692653338V","B7888632","Kottawa","0772442444");
        DataListController.driverDetailList[13]=new Driver("Mohommad Riaz","9124537733V","B3638537","Kaluthara","0777544222");
        DataListController.driverDetailList[14]=new Driver("Sandun Kumara","9563524267V","B2263333","Panadura","0772325544");
        DataListController.driverDetailList[15]=new Driver("Priyanga Perera","9135343537V","B3853753","Matara","0723344562");
    }


    @Override
    public void start(Stage primaryStage) throws IOException {
        URL resource = getClass().getResource("view/DriverViewForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Parking System");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();





        /*Scene scene=new Scene(FXMLLoader.load(getClass().getResource("view/DriverViewForm.fxml")));
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        //primaryStage.setResizable(false);
        primaryStage.show();
         */



    }
}
