module com.mycompany.coladoublefx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.coladoublefx.controller to javafx.fxml;
    exports com.mycompany.coladoublefx;
    exports com.mycompany.coladoublefx.controller;
    exports com.mycompany.coladoublefx.model;
    exports com.mycompany.coladoublefx.view;
}
