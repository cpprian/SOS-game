module sample {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    exports sample;
    opens sample to javafx.fxml;
}