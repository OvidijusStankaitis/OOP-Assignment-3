package main.Main.Models;

import java.util.ArrayList;
import java.util.List;

public class History {
    private List<Expense> expenses;

    public History() {
        this.expenses = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        this.expenses.add(expense);
    }

    public List<Expense> getExpenses() {
        return this.expenses;
    }
}