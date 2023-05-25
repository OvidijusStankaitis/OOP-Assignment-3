package main.Main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.Main.Controllers.Stage1Controller;
import main.Main.Stages.Stage1;

public class Main extends Application {
    private Stage stage;
    private Stage1Controller stage1Controller = new Stage1Controller();

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        Font customFont = Font.loadFont(getClass().getResource("/JetBrainsMono-ExtraBold.ttf").toExternalForm(), 100);
        this.stage = stage;
        this.stage.setTitle("Expense Tracker");
        this.stage.setOnCloseRequest(e -> System.exit(0));
        this.stage.setFullScreen(true);

        Label title = new Label("Expense Tracker");
        title.setFont(customFont);

        customFont = Font.loadFont(getClass().getResource("/JetBrainsMono-ExtraBold.ttf").toExternalForm(), 50);

        Button newExpenseButton = new Button("New Expense");
        newExpenseButton.setFont(customFont);
        newExpenseButton.setPadding(new Insets(10));
        newExpenseButton.setOnAction(e -> handleNewExpense());

        Button exitButton = new Button("Exit");
        exitButton.setFont(customFont);
        exitButton.setPadding(new Insets(10));
        exitButton.setOnAction(e -> System.exit(0));

        VBox menuBox = new VBox(40);
        menuBox.getChildren().addAll(title, newExpenseButton, exitButton);
        menuBox.setAlignment(Pos.TOP_LEFT);
        menuBox.setPadding(new Insets(100, 0, 0, 100));

        BorderPane root = new BorderPane();
        root.setLeft(menuBox);

        Scene scene = new Scene(root);
        stage.setScene(scene);

        this.stage.show();
    }

    private void handleNewExpense() {
        Stage1 stage1 = new Stage1(stage1Controller);

        stage1.setFullScreen(true);

        stage1.show();
        stage.close();
    }
}
