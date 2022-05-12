module com.example.sosgame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sosgame to javafx.fxml;
    exports com.sosgame;
    exports sample;
    opens sample to javafx.fxml;
}