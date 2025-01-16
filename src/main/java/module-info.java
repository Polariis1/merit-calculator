module polaris.meritcalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens polaris.meritcalculator to javafx.fxml;
    exports polaris.meritcalculator;
}