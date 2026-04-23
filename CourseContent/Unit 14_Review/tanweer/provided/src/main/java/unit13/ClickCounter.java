package unit13;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ClickCounter extends Application {

    private int count;

    @Override
    public void start(Stage stage) throws Exception {
        count = 0;
        
        Label countLabel = makeLabel("0", new Font("Courier New", 128), Color.CYAN);

        Button clicker = new Button("Click Me!");
        clicker.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        clicker.setAlignment(Pos.CENTER);
        clicker.setPadding(new Insets(20));
        clicker.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        VBox.setVgrow(clicker, Priority.NEVER);

        // event handling activity
        clicker.setOnAction((e) -> {
            count++;
            countLabel.setText(Integer.toString(count));
        });

        VBox box = new VBox();
        box.getChildren().addAll(
            makeLabel("Number of Clicks", new Font("Arial", 24), 
                Color.LIGHTGRAY),
            countLabel,
            clicker
        );

        stage.setTitle("Click Counter");
        stage.setScene(new Scene(box));
        stage.show();
        
    }

    private static Label makeLabel(String text, Font font, Color fill) {
        Label label = new Label(text);
        label.setFont(font);
        label.setBackground(new Background(new BackgroundFill(fill, 
            CornerRadii.EMPTY, Insets.EMPTY)));
        label.setAlignment(Pos.CENTER);
        label.setPadding(new Insets(20));
        label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        VBox.setVgrow(label, Priority.ALWAYS);

        return label;
    }

    public static void main(String[] args) {
        launch(args);   
    }
}
