module polaris.meritcalculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens polaris.meritcalculator to javafx.fxml, com.google.gson;

    exports polaris.meritcalculator;
}