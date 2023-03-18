package homer.view;

import homer.view.javafx.AdjustableDeviceView;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JFXApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 300, 500);
        VBox vBox = new VBox();
        root.getChildren().add(vBox);
        vBox.getChildren().add(new AdjustableDeviceView("something", 0,10, 2));
        stage.setTitle("demo");
        stage.setScene(scene);
        stage.show();
    }
    
}
