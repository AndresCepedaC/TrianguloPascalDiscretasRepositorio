package triangulopascaldiscretas.trianglepascalapp.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.beans.property.ReadOnlyObjectWrapper;

public class TrianglePascal2Controller {

    @FXML
    private TextField numField;

    @FXML
    private TableView<ObservableList<Integer>> tableView;

    @FXML
    private void handleGenerateButton(ActionEvent event) {
        String text = numField.getText();
        try {
            int numRows = Integer.parseInt(text) + 1;
            if (numRows > 0) {
                generatePascalTriangle(numRows);
            } else {
                showAlert("Por favor ingrese un número positivo.");
            }
        } catch (NumberFormatException ex) {
            showAlert("Por favor ingrese un número válido.");
        }
    }

    private void generatePascalTriangle(int numRows) {
        tableView.getColumns().clear();
        tableView.getItems().clear();

        for (int i = 0; i < numRows; i++) {
            final int colIndex = i;
            TableColumn<ObservableList<Integer>, Integer> column = new TableColumn<>(String.valueOf(i));
            column.setCellValueFactory(param -> {
                ObservableList<Integer> row = param.getValue();
                // Verificar si el índice colIndex existe en la fila antes de acceder a él
                return colIndex < row.size() ? new ReadOnlyObjectWrapper<>(row.get(colIndex)) : null;
            });
            tableView.getColumns().add(column);
        }

        ObservableList<ObservableList<Integer>> data = FXCollections.observableArrayList();
        for (int i = 0; i < numRows; i++) {
            ObservableList<Integer> row = FXCollections.observableArrayList();
            for (int j = 0; j <= i; j++) {
                row.add(pascalValue(i, j));
            }
            data.add(row);
        }
        tableView.setItems(data);
    }

    private int pascalValue(int row, int col) {
        if (col == 0 || col == row) {
            return 1;
        }
        return pascalValue(row - 1, col - 1) + pascalValue(row - 1, col);
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
