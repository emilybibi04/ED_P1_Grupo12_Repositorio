module com.espol.ed_p1_grupo12 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.espol.ed_p1_grupo12 to javafx.fxml;
    exports com.espol.ed_p1_grupo12;
}
