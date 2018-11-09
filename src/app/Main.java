package app;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Faktura");
        primaryStage.setScene(new Scene(root, 1319, 493));
//        primaryStage.setFullScreen(true);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) throws Exception{
        launch(args);
    }

    protected DatabaseAdapter sql(String controller){
        DatabaseAdapter db = DatabaseAdapter.getInstance();
            return db;
    }
}
