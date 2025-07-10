package app;

import controller.ModuleChooserController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.ModuleChooserRootPane;

public class ApplicationLoader extends Application {

    @Override
    public void start(Stage primaryStage) {
        // View and Controller setup
        ModuleChooserRootPane root = new ModuleChooserRootPane();
        new ModuleChooserController(root);

        // Scene and Stage setup
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("University Module Chooser");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // launch JavaFX application
    }
}
