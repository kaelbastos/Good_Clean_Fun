package org.kaelbastos;

import javafx.application.Application;
import javafx.stage.Stage;
import org.kaelbastos.view.DesktopUI.Windows.ServiceWindow;

/**
 * This is the code, enjoy it.
 *
 *
 * Do or do not, there is no try... Master Yoda.
 */
public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        ServiceWindow window = new ServiceWindow();
        window.showAndWait();
        System.out.println("Au revoir shoshana!!!");
    }
}

