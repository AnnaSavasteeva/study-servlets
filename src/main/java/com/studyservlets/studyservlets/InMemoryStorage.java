package com.studyservlets.studyservlets;

import java.util.ArrayList;
import java.util.List;

/**
 * В названии класса используется 'InMemory' — это понятие обычно указывает, что это оперативная память.
 * Коллекции, например, хранятся в оперативной памяти.
 */
public class InMemoryStorage {

    private static final List<String> operations = new ArrayList<>();

    public void addOperation(String operation) {
        operations.add(operation);
    }

    public List<String> getOperations() {
        return operations;
    }
}
