package triangulopascaldiscretas.trianglepascalapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DiscretasApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DiscretasApp.class.getResource("Bienvenida.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Math Discretas App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}