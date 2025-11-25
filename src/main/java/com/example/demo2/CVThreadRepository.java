package com.example.demo2;

import javafx.concurrent.Task;
import java.util.List;
import java.util.function.Consumer;

public class CVThreadRepository {
    private final DatabaseHelper dbHelper;

    public CVThreadRepository() {
        dbHelper = new DatabaseHelper();
    }

    public void insertCVAsync(Info info, Consumer<Boolean> callback) {
        Task<Boolean> task = new Task<>() {
            @Override
            protected Boolean call() {
                return dbHelper.insert(info) != null;
            }
        };
        task.setOnSucceeded(e -> callback.accept(task.getValue()));
        new Thread(task).start();
    }

    public void deleteCVAsync(int id, Consumer<Boolean> callback) {
        Task<Boolean> task = new Task<>() {
            @Override
            protected Boolean call() {
                return dbHelper.deleteCV(id);
            }
        };
        task.setOnSucceeded(e -> callback.accept(task.getValue()));
        new Thread(task).start();
    }

    public void getAllCVsAsync(Consumer<List<Info>> callback) {
        Task<List<Info>> task = new Task<>() {
            @Override
            protected List<Info> call() {
                return dbHelper.getAllCVs();
            }
        };
        task.setOnSucceeded(e -> callback.accept(task.getValue()));
        new Thread(task).start();
    }
}
