package homer.view;

import homer.controller.Controller;
import homer.controller.ControllerImpl;
import homer.view.javafx.AddDevicesView;
import homer.core.SimManagerImpl;
import homer.view.sim.SimManagerViewFxImpl;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Main javaFX application.
 */
public class JFXApplication extends Application {
    private static final long INITIAL_W = 300;
    private static final long INITIAL_H = 300;
    private static final String TITLE = "HOMER";

    @Override
    public final void start(final Stage stage) throws Exception {
        stage.setOnCloseRequest(event -> {
            Platform.exit();
            System.exit(0);
        });

        final Scene scene = new Scene(root, INITIAL_W, INITIAL_H);
        final VBox vBox = new VBox();
        final Controller controller = new ControllerImpl();
        root.getChildren().addAll(vBox, new AddDevicesView(controller));

        final var simManager = new SimManagerImpl(controller);
        Platform.runLater(() -> {
            final var simView = new SimManagerViewFxImpl();
            simView.setObserver(simManager);
        });

        stage.setTitle(TITLE);
        stage.setScene(scene);
        stage.show();
    }


}
