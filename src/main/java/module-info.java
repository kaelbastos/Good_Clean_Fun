module org.kaelbastos {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;

    opens org.kaelbastos to javafx.fxml;
    exports org.kaelbastos;
}