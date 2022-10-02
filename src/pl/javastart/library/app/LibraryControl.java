package pl.javastart.library.app;

import Exceptions.NoSuchOptionException;
import io.ConsolePrinter;
import io.DataReader;
import jdk.internal.util.xml.impl.Input;
import pl.javastart.library.model.Book;
import pl.javastart.library.model.Library;
import pl.javastart.library.model.Magazine;

import java.util.InputMismatchException;

public class LibraryControl {
    private ConsolePrinter consolePrinter = new ConsolePrinter();
    private DataReader dataReader = new DataReader(consolePrinter); // zeby utworzyc obiekt z klasy DataReader to trzeba zdefiniowac ConsolePrintera. Wtedy nie musze tworzyc nowego obiektu w tej klasie zeby poslugiwac sie metoda printLine()
    private Library library = new Library();



    void controlLoop(){
        Option option;
        do {
            showOptions();
            option = getOption();
            switch (option){
                case EXIT:
                    exit();
                    break;
                case ADD_BOOK:
                    addBook();
                    break;
                case ADD_MAGAZINE:
                    addMagazine();
                    break;
                case SHOW_BOOKS:
                    showBooks();
                    break;
                case SHOW_MAGAZINES:
                    showMagazines();
                    break;
                case SHOW_ALL_PUBLICATIONS:
                    showAllPublications();
                    break;
                default:
                    consolePrinter.printLine("Niepoprawna opcja");
            }
        }while(option != Option.EXIT);

    }

    private Option getOption() {
        boolean optionOk = true;
        Option option = null;

        while(optionOk) {
            try {
                option = Option.createFromInt(dataReader.getInt());
                optionOk = false;
            } catch (NoSuchOptionException e) {
                consolePrinter.printError(e.getMessage() + ", podaj ponownie: ");
            } catch (InputMismatchException e) {
                consolePrinter.printError("Wprowadzona wartość nie jest liczbą całkowitą, spróbuj ponownie.");
            }
        }
        return option;
    }

    private void showOptions(){
        consolePrinter.printLine("\nWybierz opcję: ");
        for(Option option : Option.values()){
            consolePrinter.printLine(option.toString());
        }
    }

    private void addMagazine() {
        try {
            Magazine magazine = dataReader.readAndCreateMagazine();
            library.addMagazine(magazine);
        } catch (InputMismatchException e){
            consolePrinter.printError("Nie udało się utworzyć magazynu, niepoprawne dane.");
        } catch (ArrayIndexOutOfBoundsException e){
            consolePrinter.printError(e.getMessage());
        }

    }

    private void showMagazines() {
        consolePrinter.showMagazines(library.getPublications());
    }

    private void addBook() {
        try {
            Book book = dataReader.readAndCreateBook();
            library.addBook(book);
        } catch (InputMismatchException e){
            consolePrinter.printError("Nie udało się utworzyć książki, niepoprawne dane.");
        } catch (ArrayIndexOutOfBoundsException e){
            consolePrinter.printError(e.getMessage());
        }
    }
    private void showBooks() {
        consolePrinter.showBooks(library.getPublications());
    }

    private void showAllPublications(){
        consolePrinter.showAllPublications(library.getPublications());
    }

    private void exit() {
        consolePrinter.printLine("Do widzenia!");
        dataReader.closeApp();
    }

}
