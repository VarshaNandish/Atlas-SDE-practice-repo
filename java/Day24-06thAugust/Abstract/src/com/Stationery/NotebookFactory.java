package com.Stationery;

public class NotebookFactory implements BookFactory {
    @Override
    public Notebook createShortBook() {
        return new ShortBook();  // returns Notebook
    }

    @Override
    public Textbook createLongBook() {
        return new LongBook();   // returns Textbook
    }
}

