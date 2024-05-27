package triangulopascaldiscretas.trianglepascalapp.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import triangulopascaldiscretas.trianglepascalapp.model.TriangleItem;
import triangulopascaldiscretas.trianglepascalapp.services.INavegacion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TrianglePascalController implements INavegacion {

    @FXML
    private AnchorPane trianglePane;

    @FXML
    private TableView<TriangleItem> tblResult;

    @FXML
    private TableColumn<TriangleItem, String> expressionColumn;

    @FXML
    private TextField txtCoeficiente;

    @FXML
    private TextField txtSelectedExpression;

    @FXML
    private Button btnCalcular;
    @FXML
    private void onAbrirPagina(ActionEvent event) {
        irPantalla("TrianglePascalView.fxml");
        Stage stage = (Stage) btnCalcular.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void onCalcular() {
        try {
            int numRows = Integer.parseInt(txtCoeficiente.getText()) + 1;
            List<TriangleItem> triangle = generateTriangle(numRows);

            ObservableList<TriangleItem> items = FXCollections.observableArrayList(triangle);
            tblResult.setItems(items);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private List<TriangleItem> generateTriangle(int rows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
                }
            }
            triangle.add(row);
        }

        return IntStream.range(0, rows)
                .mapToObj(i -> new TriangleItem(generateExpression(triangle.get(i), i)))
                .collect(Collectors.toList());
    }

    private String generateExpression(List<Integer> coefficients, int rowIndex) {
        StringBuilder expression = new StringBuilder();
        int n = coefficients.size() - 1;

        for (int i = 0; i < coefficients.size(); i++) {
            int coeff = coefficients.get(i);
            int powerA = n - i;
            int powerB = i;

            if (i > 0) {
                expression.append(" + ");
            }

            if (coeff != 1) {
                expression.append(coeff);
            }
            if (powerA > 0) {
                expression.append("a");
                if (powerA > 1) {
                    expression.append("^").append(powerA);
                }
            }
            if (powerB > 0) {
                expression.append("b");
                if (powerB > 1) {
                    expression.append("^").append(powerB);
                }
            }
        }
        return expression.toString();
    }

    @FXML
    private void initialize() {
        expressionColumn.setCellValueFactory(new PropertyValueFactory<>("expression"));

        // Add listener to TableView selection model
        tblResult.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                txtSelectedExpression.setText(newValue.getExpression());
            }
        });
    }
}


