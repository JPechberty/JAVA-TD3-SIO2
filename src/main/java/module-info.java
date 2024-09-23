module com.sio.javatd3sio2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires json.simple;


    opens com.sio.javatd3sio2 to javafx.fxml;
    exports com.sio.javatd3sio2;
    opens com.sio.javatd3sio2.models to javafx.fxml;
    exports com.sio.javatd3sio2.models;
}