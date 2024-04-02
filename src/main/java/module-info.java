module web.calcmathlab2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens web.calcmathlab3 to javafx.fxml;
    exports web.calcmathlab3;
}