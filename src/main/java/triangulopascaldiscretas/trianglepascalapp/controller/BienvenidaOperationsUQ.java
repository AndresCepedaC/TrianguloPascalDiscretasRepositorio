package triangulopascaldiscretas.trianglepascalapp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import triangulopascaldiscretas.trianglepascalapp.services.INavegacion;

public class BienvenidaOperationsUQ implements INavegacion {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnTrianguloPascal;

    @FXML
    private Button btnCombinatorias;

    @FXML
    private Button btnBinomioNewton;

    @FXML
    void onCombinatorias(ActionEvent event) {
        irPantalla("combinatorial_calculator.fxml");
    }

    @FXML
    void onTrianguloPascal(ActionEvent event) {
        irPantalla("trianglePascal.fxml");
    }

    @FXML
    void onBinomioNewton(ActionEvent event) {
        irPantalla("newton_binomial_calculator.fxml");
    }

    @FXML
    void initialize() {
    }
}
