package main.Main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage stage;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        Font customFont = Font.loadFont(getClass().getResource("/JetBrainsMono-ExtraBold.ttf").toExternalForm(), 100);
        this.stage = stage;
        this.stage.setTitle("Expense Tracker");
        this.stage.setFullScreen(true);
        this.stage.setOnCloseRequest(e -> System.exit(0));

        Label title = new Label("Expense Tracker");
        title.setFont(customFont);
        title.setTextFill(Color.WHITE);

        Button newExpenseButton = new Button("New Expense");
        newExpenseButton.getStyleClass().add("button");
        newExpenseButton.setOnAction(e -> System.out.println("New Expense"));

        Button expenseHistoryButton = new Button("Expense History");
        expenseHistoryButton.getStyleClass().add("button");
        expenseHistoryButton.setOnAction(e -> System.out.println("Expense History"));

        Button expenseReportButton = new Button("Expense Report");
        expenseReportButton.getStyleClass().add("button");
        expenseReportButton.setOnAction(e -> System.out.println("Expense Report"));

        Button exitButton = new Button("Exit");
        exitButton.getStyleClass().add("button");
        exitButton.setOnAction(e -> System.exit(0));

        VBox menuBox = new VBox(40);
        menuBox.getChildren().addAll(title, newExpenseButton, expenseHistoryButton, expenseReportButton, exitButton);
        menuBox.setAlignment(Pos.TOP_LEFT);
        menuBox.setPadding(new Insets(100, 0, 0, 100));

        BorderPane root = new BorderPane();
        root.setLeft(menuBox);
        root.setStyle("-fx-background-color: black;"); // Set background color to black

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/button.css").toExternalForm());
        stage.setScene(scene);

        this.stage.show();
    }
}
