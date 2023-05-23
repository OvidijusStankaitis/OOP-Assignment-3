module main.oopassignment3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens main.Main.Controllers to javafx.fxml;
    opens main.Main.Models;
    opens main.Main.Utils;

    exports main.Main;
}
