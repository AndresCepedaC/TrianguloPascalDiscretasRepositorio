module triangulopascaldiscretas.trianglepascalapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens triangulopascaldiscretas.trianglepascalapp to javafx.fxml;
    exports triangulopascaldiscretas.trianglepascalapp;

    opens triangulopascaldiscretas.trianglepascalapp.controller to javafx.fxml;
    exports triangulopascaldiscretas.trianglepascalapp.controller;

    opens triangulopascaldiscretas.trianglepascalapp.model to javafx.base;
    exports triangulopascaldiscretas.trianglepascalapp.model;

}
