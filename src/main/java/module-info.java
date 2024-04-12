module org.example.cuoiki_code_tutorial {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires javafx.web;
    requires org.fxmisc.richtext;

    opens org.example.cuoiki_code_tutorial to javafx.fxml;
    exports org.example.cuoiki_code_tutorial.View;
    opens org.example.cuoiki_code_tutorial.View to javafx.fxml;
    exports org.example.cuoiki_code_tutorial.Controllers;
    opens org.example.cuoiki_code_tutorial.Controllers to javafx.fxml;
}