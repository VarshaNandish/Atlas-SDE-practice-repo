package com.example.StructuralMethodDP.Command;

/**
 * Concrete Command to close a file.
 */
public class CloseCommand implements CommandInterface {
    private TxtFile txtFile;

    // Constructor
    public CloseCommand(TxtFile txtFile) {
        this.txtFile = txtFile;
    }

    @Override
    public String executeCommand() {
        return txtFile.close();
    }
}

