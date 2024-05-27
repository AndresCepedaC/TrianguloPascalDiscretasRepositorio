package triangulopascaldiscretas.trianglepascalapp.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import triangulopascaldiscretas.trianglepascalapp.model.Combinaciones;
import triangulopascaldiscretas.trianglepascalapp.model.Permutaciones;
import triangulopascaldiscretas.trianglepascalapp.model.Variaciones;

public class CombinatorialAppController {

    @FXML
    private TextField inputA;

    @FXML
    private TextField inputB;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private Label result;

    @FXML
    private void handleCalculateButtonAction() {
        try {
            int a = Integer.parseInt(inputA.getText());
            int b = Integer.parseInt(inputB.getText());
            String operation = comboBox.getValue();
            long resultado = 0;

            switch (operation) {
                case "Combinaciones":
                    resultado = Combinaciones.calcularCombinaciones(a, b);
                    break;
                case "Permutaciones":
                    resultado = Permutaciones.calcularPermutaciones(a, b);
                    break;
                case "Variaciones sin repetición":
                    resultado = Variaciones.calcularVariacionesSinRepeticion(a, b);
                    break;
                case "Variaciones con repetición":
                    resultado = Variaciones.calcularVariacionesConRepeticion(a, b);
                    break;
                default:
                    result.setText("Por favor seleccione una operación válida.");
                    return;
            }
            result.setText(String.valueOf(resultado));
        } catch (NumberFormatException ex) {
            result.setText("Por favor ingrese números válidos.");
        }
    }
}
