package main.Main.Stages;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import main.Main.Controllers.Stage1Controller;

public class Stage1 extends Stage {

    public Stage1(Stage1Controller controller) {
        Font customFont = Font.loadFont(getClass().getResource("/JetBrainsMono-ExtraBold.ttf").toExternalForm(), 100);
        setTitle("New Expense");
        initStyle(StageStyle.UNDECORATED);

        Label title = new Label("New Expense");
        title.setFont(customFont);

        customFont = Font.loadFont(getClass().getResource("/JetBrainsMono-ExtraBold.ttf").toExternalForm(), 50);

        Spinner<Double> amountSpinner = new Spinner<>();
        SpinnerValueFactory.DoubleSpinnerValueFactory doubleSpinnerValueFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0, 9999999999.99, 0.0, 0.01);
        amountSpinner.setValueFactory(doubleSpinnerValueFactory);
        amountSpinner.setEditable(true);
        TextFormatter<Double> formatter = new TextFormatter<>(doubleSpinnerValueFactory.getConverter(), doubleSpinnerValueFactory.getValue());
        amountSpinner.getEditor().setTextFormatter(formatter);
        doubleSpinnerValueFactory.valueProperty().bindBidirectional(formatter.valueProperty());

        amountSpinner.getEditor().setFont(customFont);
        amountSpinner.setPrefWidth(600);

        Font jetBrainsExtraBold = Font.loadFont(getClass().getResource("/JetBrainsMono-ExtraBold.ttf").toExternalForm(), 50);

        ComboBox<String> categoryBox = new ComboBox<>();
        categoryBox.getItems().addAll("Miscellaneous", "Housing", "Transportation", "Food", "Utilities", "Clothing", "Medical/Healthcare", "Insurance");
        categoryBox.setPromptText("Miscellaneous");

        categoryBox.setButtonCell(new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setFont(Font.loadFont(getClass().getResource("/JetBrainsMono-ExtraBold.ttf").toExternalForm(), 50));
                    setText(categoryBox.getPromptText());
                } else {
                    setFont(Font.loadFont(getClass().getResource("/JetBrainsMono-ExtraBold.ttf").toExternalForm(), 50));
                    setText(item);
                }
            }
        });

        categoryBox.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                final ListCell<String> cell = new ListCell<String>() {
                    {
                        super.setPrefWidth(600);
                    }

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item);
                            setFont(Font.loadFont(getClass().getResource("/JetBrainsMono-ExtraBold.ttf").toExternalForm(), 50));
                        } else {
                            setText(null);
                        }
                    }
                };
                return cell;
            }
        });

        Button addButton = new Button("Add Expense");
        addButton.setFont(customFont);
        addButton.setPadding(new Insets(10));
        addButton.setOnAction(e -> controller.handleAddExpense(amountSpinner.getValue(), categoryBox.getValue()));

        HBox newExpenseBox = new HBox(40, amountSpinner, categoryBox);
        newExpenseBox.setAlignment(Pos.CENTER_LEFT);

        Button saveButton = new Button("Save to File");
        saveButton.setFont(customFont);
        saveButton.setPadding(new Insets(10));
        saveButton.setOnAction(e -> saveToFile(controller));

        Button historyButton = new Button("History");
        historyButton.setFont(customFont);
        historyButton.setPadding(new Insets(10));
        historyButton.setOnAction(e -> {
            controller.handleHistoryButtonClicked();
            close();
        });

        Button exitButton = new Button("Exit");
        exitButton.setFont(customFont);
        exitButton.setPadding(new Insets(10));
        exitButton.setOnAction(e -> System.exit(0));

        VBox root = new VBox(40, title, newExpenseBox, addButton, saveButton, historyButton, exitButton);
        root.setPadding(new Insets(100, 0, 0, 100));
        root.setAlignment(Pos.TOP_LEFT);

        Scene scene = new Scene(root);

        setScene(scene);
    }

    private void saveToFile(Stage1Controller controller) {
        controller.saveExpenseToFile();
    }
}