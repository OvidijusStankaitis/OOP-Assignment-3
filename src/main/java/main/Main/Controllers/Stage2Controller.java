package main.Main.Controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.Main.Models.Expense;
import main.Main.Stages.Stage3;
import main.Main.Utils.Singleton;

import java.text.DecimalFormat;

public class Stage2Controller {
    private Stage3Controller stage3Controller = new Stage3Controller();

    public TableView<Expense> getExpenseHistoryTableView() {
        TableView<Expense> tableView = new TableView<>();

        TableColumn<Expense, String> categoryColumn = new TableColumn<>("Category");
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));

        TableColumn<Expense, String> amountColumn = new TableColumn<>("Amount");
        amountColumn.setCellValueFactory(data -> {
            double amount = data.getValue().getAmount();
            String formattedAmount = new DecimalFormat("0.00").format(amount);
            return new SimpleStringProperty(formattedAmount);
        });

        tableView.getColumns().add(categoryColumn);
        tableView.getColumns().add(amountColumn);

        tableView.setItems(FXCollections.observableArrayList(Singleton.getInstance().getHistory().getExpenses()));
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        return tableView;
    }

    public void handleReportButtonClicked() {
        Stage3 stage3 = new Stage3(stage3Controller);

        stage3.setFullScreen(true);

        stage3.show();
    }
}
