package main.Main.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.chart.PieChart;
import main.Main.Models.Expense;
import main.Main.Utils.Singleton;

import java.util.HashMap;
import java.util.Map;

public class Stage3Controller {

    public PieChart getExpenseReportPieChart() {
        // calculate totals for each category
        Map<String, Double> categoryTotals = new HashMap<>();
        double total = 0.0;
        for (Expense expense : Singleton.getInstance().getHistory().getExpenses()) {
            categoryTotals.merge(expense.getCategory(), expense.getAmount(), Double::sum);
            total += expense.getAmount();
        }

        // create pie chart data
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for (Map.Entry<String, Double> entry : categoryTotals.entrySet()) {
            if (entry.getValue() != 0) {
                double amount = entry.getValue();
                double percentage = (amount / total) * 100;
                String label = String.format("%s: €%.2f (%.2f%%)", entry.getKey(), amount, percentage);
                pieChartData.add(new PieChart.Data(label, amount));
            }
        }

        // create and return pie chart
        PieChart pieChart = new PieChart(pieChartData);
        pieChart.setMaxSize(800, Double.MAX_VALUE);
        pieChart.setPadding(new Insets(0));
        pieChart.setTitle("Expense Report");

        return pieChart;
    }

}
