package com.Stationery;

public class AbstractFactoryMethodDriver {
    public static void main(String[] args) {
        // You can switch between NotebookFactory or TextbookFactory here
        BookFactory notebookFactory = new NotebookFactory();
        Notebook shortNotebook = notebookFactory.createShortBook();
        Textbook longTextbook = notebookFactory.createLongBook();

        shortNotebook.writing();
        longTextbook.reading();

        // Similarly use textbookFactory if needed
        BookFactory textbookFactory = new TextbookFactory();
        Notebook shortBook2 = textbookFactory.createShortBook();
        Textbook longBook2 = textbookFactory.createLongBook();

        shortBook2.writing();
        longBook2.reading();
    }
}
