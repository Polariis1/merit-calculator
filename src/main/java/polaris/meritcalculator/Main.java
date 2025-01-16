package polaris.meritcalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage; // Store the primary stage reference
        showMainMenu();
        //primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("/polaris/meritcalculator/images/quiz-logo.png")));
        primaryStage.setTitle("Merit Calculator");
    }

    private scene_controller scene_controller;

    public void showMainMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/polaris/meritcalculator/scene.fxml"));
        Parent root = loader.load();

        scene_controller = loader.getController();
        scene_controller.setMain(this); // Pass main reference to controller
        scene_controller.setRoot(root); // Set the root node in the controller

        Scene scene = new Scene(root, 900, 600);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}