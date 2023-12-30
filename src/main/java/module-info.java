module com.nazrul.inventorymanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.nazrul.inventorymanagement to javafx.fxml;
    exports com.nazrul.inventorymanagement;
}