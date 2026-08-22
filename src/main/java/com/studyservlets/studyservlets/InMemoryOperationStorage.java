package com.studyservlets.studyservlets;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * В названии класса используется 'InMemory' — это понятие обычно указывает, что это оперативная память.
 * Коллекции, например, хранятся в оперативной памяти.
 */
public class InMemoryOperationStorage {

    private static final List<Operation> operations = new ArrayList<>();

    public void addOperation(Operation operation) {
        operations.add(operation);
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public Optional<Operation> getOperationById(UUID id) {
        return operations.stream()
                .filter(operation -> operation.getId().equals(id))
                .findFirst();
    }
}
