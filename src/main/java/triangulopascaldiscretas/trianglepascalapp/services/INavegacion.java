package triangulopascaldiscretas.trianglepascalapp.services;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import triangulopascaldiscretas.trianglepascalapp.DiscretasApp;

public interface INavegacion {
    default void irPantalla(String fxmlPath) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(DiscretasApp.class.getResource(fxmlPath));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle(null);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    default void cerrarSesion(String fxmlPath, Button button) {
        irPantalla(fxmlPath);
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }
}
