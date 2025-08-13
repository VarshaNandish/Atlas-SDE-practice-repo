package com.example.StructuralMethodDP.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * Invoker - Executes commands and keeps a history.
 */
public class Invoker_Executor {
    private final List<CommandInterface> commandsList = new ArrayList<>();

    public String invokeOperation(CommandInterface commandInterface) {
        commandsList.add(commandInterface);
        return commandInterface.executeCommand();
    }

    // Optional: View command history
    public void showHistory() {
        System.out.println("Executed commands count: " + commandsList.size());
    }
}

