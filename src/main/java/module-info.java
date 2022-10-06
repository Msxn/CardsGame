module com.mydigitalschool.cardsgame.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.mydigitalschool.cardsgame.demo to javafx.fxml;
    exports com.mydigitalschool.cardsgame.demo;
}