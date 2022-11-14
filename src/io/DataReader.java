package io;

import pl.javastart.library.model.Book;
import pl.javastart.library.model.Magazine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {
    private Scanner scanner = new Scanner(System.in);
    private ConsolePrinter consolePrinter;

    // unikam tworzenia obiektow, wiec uzywam juz istniejacego obiektu:


    public DataReader(ConsolePrinter consolePrinter) {
        this.consolePrinter = consolePrinter;
    }

    public Book readAndCreateBook() {
        consolePrinter.printLine("Tytuł: ");
        String title = scanner.nextLine();
        consolePrinter.printLine("Autor: ");
        String author = scanner.nextLine();
        consolePrinter.printLine("Wydawnictwo: ");
        String publisher = scanner.nextLine();
        consolePrinter.printLine("ISBN: ");
        String isbn = scanner.nextLine();
        consolePrinter.printLine("Data wydania: ");
        int dateRelease = getInt();
        consolePrinter.printLine("Ilość stron: ");
        int pages = getInt();

        return new Book(title, author, dateRelease, pages, publisher, isbn);
    }

    public Magazine readAndCreateMagazine(){
        consolePrinter.printLine("Tytuł: ");
        String title = scanner.nextLine();
        consolePrinter.printLine("Wydawnictwo: ");
        String publisher = scanner.nextLine();
        consolePrinter.printLine("Język: ");
        String language = scanner.nextLine();
        consolePrinter.printLine("Rok wydania: ");
        int year = getInt();
        consolePrinter.printLine("Miesiąc: ");
        int month = getInt();
        consolePrinter.printLine("Dzień: ");
        int day = getInt();

        return new Magazine(title,publisher,language,month,day,year);
    }

    public void closeApp(){
        scanner.close();
    }

    public int getInt(){
        int choice = 0;
        try{
            choice = scanner.nextInt();
            return choice;
        } finally {
            scanner.nextLine();
        }
    }

    public String getString(){
        return scanner.nextLine();
    }
}
