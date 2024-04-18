module org.example.cuoiki_code_tutorial {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires org.fxmisc.richtext;
    requires jython;

    opens org.example.cuoiki_code_tutorial to javafx.fxml;
    exports org.example.cuoiki_code_tutorial.View;
    opens org.example.cuoiki_code_tutorial.View to javafx.fxml;
    exports org.example.cuoiki_code_tutorial.Controllers;
    opens org.example.cuoiki_code_tutorial.Controllers to javafx.fxml;
    opens org.example.cuoiki_code_tutorial.Models to javafx.base;
    exports org.example.cuoiki_code_tutorial.Utils;
    opens org.example.cuoiki_code_tutorial.Utils to javafx.fxml;

}