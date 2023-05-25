package main.Main.Stages;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.Main.Controllers.Stage2Controller;
import main.Main.Controllers.Stage3Controller;

public class Stage3 extends Stage {
    public Stage3(Stage3Controller controller) {
        Font customFont = Font.loadFont(getClass().getResource("/JetBrainsMono-ExtraBold.ttf").toExternalForm(), 100);
        setTitle("Expense Report");
        initStyle(StageStyle.UNDECORATED);

        Label title = new Label("Expense Report");
        title.setFont(customFont);

        customFont = Font.loadFont(getClass().getResource("/JetBrainsMono-ExtraBold.ttf").toExternalForm(), 50);

        PieChart pieChart = controller.getExpenseReportPieChart();

        Button backButton = new Button("Back");
        backButton.setFont(customFont);
        backButton.setPadding(new Insets(10));
        backButton.setOnAction(e -> {
            Stage2 stage2 = new Stage2(new Stage2Controller());
            stage2.setFullScreen(true);
            stage2.show();
            close();
        });

        Button exitButton = new Button("Exit");
        exitButton.setFont(customFont);
        exitButton.setPadding(new Insets(10));
        exitButton.setOnAction(e -> System.exit(0));

        HBox buttonBox = new HBox(40, backButton, exitButton);
        buttonBox.setAlignment(Pos.CENTER);

        VBox root = new VBox(120, title, pieChart, buttonBox);
        root.setPadding(new Insets(100, 100, 0, 100));
        root.setAlignment(Pos.TOP_CENTER);

        Scene scene = new Scene(root);

        setScene(scene);
    }
}
