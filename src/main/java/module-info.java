module com.sio.javatd3sio2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sio.javatd3sio2 to javafx.fxml;
    exports com.sio.javatd3sio2;
}