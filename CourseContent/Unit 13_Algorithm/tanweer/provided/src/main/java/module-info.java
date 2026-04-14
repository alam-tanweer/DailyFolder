module unit08 {
    requires transitive javafx.graphics;
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.media;
    requires java.desktop;

    opens unit08.assignment1.pacman.gui to javafx.fxml;
    exports unit08.assignment1.pacman.gui;

    opens unit08.examples.queens.view to javafx.fxml;
    exports unit08.examples.queens.view;
    exports unit08.examples.queens.model;
    exports unit08.backtracker;
}
