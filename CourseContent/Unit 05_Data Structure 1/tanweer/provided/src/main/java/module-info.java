module unit05 {
    requires transitive javafx.graphics;
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.media;
    requires java.desktop;

    opens unit05 to javafx.fxml;

    exports unit05;
    exports unit05.practicum.hilo.model;
    exports unit05.practicum.hilo.view;
    exports unit05.assignment1.list;
    exports unit05.assignment2.files;
    exports unit05.assignment2.ranges;
}
