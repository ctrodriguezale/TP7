import Controller.GestorSimulacion;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception{
        GestorSimulacion gestor = new GestorSimulacion();
        gestor.ejecutar();

        /*
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Inicio.fxml"));
        primaryStage.setTitle("Trabajo Práctico 6 - Grupo5 - Simulación - 4K3 ");
        primaryStage.setScene(new Scene(root, 500, 300));
        primaryStage.setResizable(true);
        primaryStage.show();*/
    }

    public static void main(String[] args) {
        launch(args);
    }
}
