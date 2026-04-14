package unit08.assignment1.pacman.gui;
import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MazeMakerGUI extends Application {
    private static final String IMAGE_PATH = "file:media/images/";
    private static final Image EMPTY = new Image(IMAGE_PATH + "pathway.png");
    private static final Image WALL = new Image(IMAGE_PATH + "wall.png");
    private static final Image PAC_MAN = new Image(IMAGE_PATH + "pac_right.png");
    private static final Image GHOST = new Image(IMAGE_PATH + "ghost.png");
    private static final Image PELLET = new Image(IMAGE_PATH + "pellet.png");
    private static final Image POWER_PELLET = new Image(IMAGE_PATH + "power_pellet.png");

    private static final Border BLACK_BORDER = new Border(
        new BorderStroke(
            Color.BLACK, 
            BorderStrokeStyle.SOLID, 
            CornerRadii.EMPTY, 
            BorderStroke.THIN));

    private static final Border WHITE_BORDER = new Border(
        new BorderStroke(
            Color.WHITE, 
            BorderStrokeStyle.SOLID, 
            CornerRadii.EMPTY, 
            BorderStroke.THIN));

    private static final int ROWS = 9;
    private static final int COLS = 9;

    private static final Font COURIER_18 = new Font("Courier New", 18);

    private GuiCell[][] cells;
    private Button[][] buttons;

    private Label status;

    @Override
    public void start(Stage stage) throws Exception {
        cells = new GuiCell[ROWS][COLS];
        buttons = new Button[ROWS][COLS];

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setBackground(
            new Background(
                new BackgroundFill(
                    Color.BLUE, 
                    CornerRadii.EMPTY, 
                    Insets.EMPTY)));

        for(int row=0; row<ROWS; row++) {
            for(int col=0; col<COLS; col++) {
                grid.add(makeCellButton(row, col), col, row);
            }
        }

        status = new Label();
        status.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        status.setFont(COURIER_18);
        status.setBackground(
            new Background(
                new BackgroundFill(
                    Color.LIGHTBLUE, 
                    CornerRadii.EMPTY, 
                    Insets.EMPTY)));
        grid.add(status, 0, ROWS, COLS, 1); 

        Button makeMaze = new Button("Make Maze!");
        makeMaze.setFont(COURIER_18);
        makeMaze.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        makeMaze.setOnAction((e) -> makeMaze());
        grid.add(makeMaze, 0, ROWS+1, COLS, 1);

        Scene scene = new Scene(grid);
        stage.setTitle("Pac-Man Maz Maker");
        stage.setScene(scene);
        stage.show();
    }

    private void makeMaze() {
        MazeGraph maze = new MazeGraph();
        
        // add all of the non-empty cells to the graph
        for(int row=0; row<ROWS; row++) {
            for(int col=0; col<COLS; col++) {
                GuiCell cell = cells[row][col];
                if(!cell.isEmpty()) {
                    maze.add(cell);
                }
            }
        }

        // connect them
        maze.connectCells();
        // Collection<WVertex<GuiCell>> vertices = maze.getVertices();
        // for(WVertex<GuiCell> vertex : vertices) {
        //     GuiCell cell = vertex.getValue();
        //     connectIfExists(maze, cell, cell.getRow() - 1, cell.getCol());
        //     connectIfExists(maze, cell, cell.getRow() + 1, cell.getCol());
        //     connectIfExists(maze, cell, cell.getRow(), cell.getCol() - 1);
        //     connectIfExists(maze, cell, cell.getRow(), cell.getCol() + 1);
        // }
        // save to a file
        try{
            maze.saveToFile("maze.maz");
            status.setText("Maze saved!");
        } catch(IOException ioe) {
            status.setText("Error saving maze!");
        }
    }

    // private void connectIfExists(WGraph<GuiCell> maze, GuiCell cell, int row, int col) {
    //     GuiCell neighbor = new GuiCell(row, col);
    //     if(maze.contains(neighbor)) {
    //         System.out.println("Connecting " + cell + " to " + neighbor);
    //         maze.connect(cell, neighbor, 1);
    //     }
    // }

    private void toggleState(int row, int col) {
        GuiCell cell = cells[row][col];
        cell.toggle();
        Button button = buttons[row][col];
        switch(cell.getState()) {
            case WALL:
                button.setGraphic(new ImageView(WALL));
                button.setBorder(BLACK_BORDER);
                break;
            case PELLET:
                button.setGraphic(new ImageView(PELLET));
                button.setBorder(WHITE_BORDER);
                break;
            case POWER_PELLET:
                button.setGraphic(new ImageView(POWER_PELLET));
                button.setBorder(WHITE_BORDER);
                break;
            case GHOST:
                button.setGraphic(new ImageView(GHOST));
                button.setBorder(WHITE_BORDER);
                break;
            case PAC_MAN:
                button.setGraphic(new ImageView(PAC_MAN));
                button.setBorder(WHITE_BORDER);
                break;
        }
    }

    private Button makeCellButton(int row, int col) {
        Button button = new Button();
        button.setGraphic(new ImageView(WALL));
        button.setBackground(
            new Background(
                new BackgroundImage(
                    EMPTY, 
                    BackgroundRepeat.NO_REPEAT, 
                    BackgroundRepeat.NO_REPEAT, 
                    BackgroundPosition.CENTER, 
                    BackgroundSize.DEFAULT)
            ));
        button.setPadding(Insets.EMPTY);
        button.setBorder(BLACK_BORDER);
        button.setOnAction((e) -> toggleState(row, col));
        cells[row][col] = new GuiCell(row, col);
        buttons[row][col] = button;
        return button;
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
