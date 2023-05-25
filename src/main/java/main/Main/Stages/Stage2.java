package main.Main.Stages;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.Main.Controllers.Stage1Controller;
import main.Main.Controllers.Stage2Controller;
import main.Main.Models.Expense;

public class Stage2 extends Stage {
    private Stage1Controller stage1Controller = new Stage1Controller();

    public Stage2(Stage2Controller controller) {
        Font customFont = Font.loadFont(getClass().getResource("/JetBrainsMono-ExtraBold.ttf").toExternalForm(), 100);
        setTitle("Expense History");
        initStyle(StageStyle.UNDECORATED);

        Label title = new Label("Expense History");
        title.setFont(customFont);

        customFont = Font.loadFont(getClass().getResource("/JetBrainsMono-ExtraBold.ttf").toExternalForm(), 50);

        TableView<Expense> tableView = controller.getExpenseHistoryTableView();
        tableView.setPrefHeight(500);

        Button reportButton = new Button("View Report");
        reportButton.setFont(customFont);
        reportButton.setPadding(new Insets(10));
        reportButton.setOnAction(e -> {
            controller.handleReportButtonClicked();
            close();
        });

        Button backButton = new Button("Back");
        backButton.setFont(customFont);
        backButton.setPadding(new Insets(10));
        backButton.setOnAction(e -> {
            Stage1 stage1 = new Stage1(stage1Controller);
            stage1.setUserData(getUserData());
            stage1.setFullScreen(true);
            stage1.show();
            close();
        });

        Button exitButton = new Button("Exit");
        exitButton.setFont(customFont);
        exitButton.setPadding(new Insets(10));
        exitButton.setOnAction(e -> System.exit(0));

        HBox buttonBox = new HBox(40, backButton, exitButton);

        VBox root = new VBox(40, title, tableView, reportButton, buttonBox);
        root.setPadding(new Insets(100, 100, 0, 100));
        root.setAlignment(Pos.TOP_LEFT);

        Scene scene = new Scene(root);

        setScene(scene);
    }
}