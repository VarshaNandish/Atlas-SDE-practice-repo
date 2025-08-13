package com.example.StructuralMethodDP.Command;

public class CommandMain {
    public static void main(String[] args) {
        System.out.println("Command Method Design Pattern - Behavioral DP\n");

        // Receiver
        TxtFile file1 = new TxtFile("Document1.txt");

        // Concrete Commands
        CommandInterface openCommand = new OpenCommand(file1);
        CommandInterface saveCommand = new SaveCommand(file1);
        CommandInterface closeCommand = new CloseCommand(file1);

        // Invoker
        Invoker_Executor executor = new Invoker_Executor();

        // Execute commands
        System.out.println(executor.invokeOperation(openCommand));
        System.out.println(executor.invokeOperation(saveCommand));
        System.out.println(executor.invokeOperation(closeCommand));

        // Show history
        executor.showHistory();
    }
}

