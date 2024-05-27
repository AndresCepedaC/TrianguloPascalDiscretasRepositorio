package triangulopascaldiscretas.trianglepascalapp.controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NewtonBinomialAppController {

    @FXML
    private TextField inputA;
    @FXML
    private TextField inputB;
    @FXML
    private Label result;

    @FXML
    private void handleCalculateButtonAction() {
        try {
            int a = Integer.parseInt(inputA.getText());
            int b = Integer.parseInt(inputB.getText());
            long resultado = calcularBinomioDeNewton(a, b);
            result.setText(String.valueOf(resultado));
        } catch (NumberFormatException ex) {
            result.setText("Por favor ingrese números válidos.");
        }
    }

    private long calcularBinomioDeNewton(int a, int b) {
        return factorial(a) / (factorial(b) * factorial(a - b));
    }

    private long factorial(int n) {
        if (n == 0) return 1;
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
