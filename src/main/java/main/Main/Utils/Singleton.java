package main.Main.Utils;

import main.Main.Models.History;

public class Singleton {
    private static Singleton instance = null;
    private History history;

    private Singleton() {
        history = new History();
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public History getHistory() {
        return this.history;
    }
}
