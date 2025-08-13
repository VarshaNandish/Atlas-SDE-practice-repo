package com.example.StructuralMethodDP.Command;


/**
 * Concrete Command to save a file.
 */
public class SaveCommand implements CommandInterface {
    private TxtFile txtFile;

    // Constructor
    public SaveCommand(TxtFile txtFile) {
        this.txtFile = txtFile;
    }

    @Override
    public String executeCommand() {
        return txtFile.save();
    }
}

