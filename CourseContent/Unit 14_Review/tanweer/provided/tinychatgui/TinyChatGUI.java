import java.io.IOException;
import java.net.Socket;

import duplexer.Duplexer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TinyChatGUI extends Application {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 54321;
    private Duplexer server;
    private TextField name;
    private TextField message;
    private Label chatMessages;
    private Button connectButton;
    private Button disconnectButton;

    private void connect() {
        try {
            server = new Duplexer(new Socket(SERVER_HOST,SERVER_PORT));

            server.send(name.getText());
            String connected = server.receive();
            if (!connected.equals("Connected")) {
                chatMessages.setText("Error: Unexpected connection response: " + connected);
                return;
            }

            new Thread(()-> {
                while (true) {
                    String response = server.receive();
                    if (response.equals("Disconnected"))
                        break;
                    Platform.runLater(() -> {
                        String allMessages = chatMessages.getText();
                        allMessages = (allMessages.length() > 0) ? allMessages + "\n" + response : response;
                        chatMessages.setText(allMessages);
                    });
                }
                try {
                    server.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }).start();

            message.setDisable(false);
            connectButton.setDisable(true);
            disconnectButton.setDisable(false);
        }
        catch(IOException e) {
            chatMessages.setText("Error: Unable to connect");
        }
    }

    private void disconnect() {
            server.send("Disconnect");

            message.setDisable(true);
            connectButton.setDisable(false);
            disconnectButton.setDisable(true);
    }
    
    private void setBackgroundColor(Control control,Color color) {
        control.setBackground(new Background(new BackgroundFill(color,CornerRadii.EMPTY,Insets.EMPTY)));
    }

    @Override
    public void start(Stage stage) throws Exception {
        name = new TextField();
        name.setPromptText("Enter name");
        name.setMaxSize(Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY);

        connectButton = new Button("Connect");
        connectButton.setMaxSize(Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY);
        connectButton.setOnAction(e -> connect());

        disconnectButton = new Button("Disconnect");
        disconnectButton.setOnAction(e -> disconnect());
        disconnectButton.setMaxSize(Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY);
        disconnectButton.setDisable(true);
        HBox connection = new HBox(name,connectButton,disconnectButton);
        HBox.setHgrow(name,Priority.ALWAYS);

        chatMessages = new Label();
        chatMessages.setMaxSize(Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY);
        chatMessages.setPrefSize(500,500);
        chatMessages.setAlignment(Pos.TOP_LEFT);
        setBackgroundColor(chatMessages,Color.LIGHTBLUE);

        message = new TextField();
        message.setPromptText("Enter message");
        message.setDisable(true);
        setBackgroundColor(message,Color.WHITE);

        VBox box = new VBox(connection,chatMessages,message);
        VBox.setVgrow(chatMessages,Priority.ALWAYS);

        stage.setScene(new Scene(box));
        stage.setTitle("TinyChat");
        stage.show();        

        message.setOnAction(e -> {
            server.send(message.getText());
            message.setText("");
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}