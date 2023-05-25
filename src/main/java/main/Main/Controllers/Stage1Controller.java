package main.Main.Controllers;

import main.Main.Models.Expense;
import main.Main.Stages.Stage2;
import main.Main.Utils.Singleton;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Stage1Controller {
    private Stage2Controller stage2Controller = new Stage2Controller();

    public void handleAddExpense(double amount, String category) {
        System.out.println("Adding expense: " + amount + " " + category);
        if (category == null) {
            category = "Miscellaneous";
        }
        Expense expense = new Expense(category, amount);
        Singleton.getInstance().getHistory().addExpense(expense);
    }

    public void saveExpenseToFile() {
        try {
            Path filePath = Paths.get("src/main/resources/Expenses.txt");
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }
            String existingContent = Files.lines(filePath).collect(Collectors.joining("\n"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/Expenses.txt"));
            Singleton.getInstance().getHistory().getExpenses().forEach(expense -> {
                try {
                    if (expense.getCategory() == null)
                        writer.write(String.format("%.2f", expense.getAmount()) + " Miscellaneous\n");
                    else writer.write(String.format("%.2f", expense.getAmount()) + " " + expense.getCategory() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            writer.write(existingContent);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleHistoryButtonClicked() {
        Stage2 stage2 = new Stage2(stage2Controller);

        stage2.setFullScreen(true);

        stage2.show();
    }
}
