package com.example.StructuralMethodDP.Command;


/**
 * Concrete Command to open a file.
 */
public class OpenCommand implements CommandInterface {
    private TxtFile txtFile;

    // Constructor
    public OpenCommand(TxtFile txtFile) {
        this.txtFile = txtFile;
    }

    @Override
    public String executeCommand() {
        return txtFile.open();
    }
}
