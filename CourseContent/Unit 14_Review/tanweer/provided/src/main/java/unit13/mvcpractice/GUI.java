package unit13.mvcpractice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GUI extends Application{

    private Model model;

    @Override
    public void start(Stage stage) throws Exception {
        model = new Model();

        Button button = new Button();

        button.setText(Integer.toString(model.getCount()));

        // Notify Control
        button.setOnAction((e)->{
            // Notify Model
            model.increment();
            // button.setText(Integer.toString(model.getCount()));
        });

        // Register View to get notified from Model
        model.register((model)->button.setText(Integer.toString(model.getCount())));

        stage.setScene(new Scene(button));
        stage.setTitle("MVC Practice");
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
