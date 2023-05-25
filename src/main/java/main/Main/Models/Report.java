package main.Main.Models;

public class Report {
    private History history;

    public Report(History history) {
        this.history = history;
    }

    public double calculateTotal() {
        double total = 0;
        for (Expense expense : history.getExpenses()) {
            total += expense.getAmount();
        }
        return total;
    }
}