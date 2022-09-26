package pl.javastart.library.app;

import io.DataReader;
import pl.javastart.library.model.Book;
import pl.javastart.library.model.Library;
import pl.javastart.library.model.Magazine;

public class LibraryControl {
    private DataReader dataReader = new DataReader();
    private Library library = new Library();


    void controlLoop(){
        Option choice;
        do {
            showOptions();
            choice = Option.createFromInt(dataReader.getInt());
            switch (choice){
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
                    library.showAllPublications();
                    break;
                default:
                    System.out.println("Niepoprawna opcja");
            }
        }while(choice != Option.EXIT);

    }

    private void showMagazines() {
        library.showMagazines();
    }

    private void addMagazine() {
        if(library.spaceAvailable()) {
            Magazine magazine = dataReader.readAndCreateMagazine();
            library.addMagazine(magazine);
        }else{
            fullLibraryForMagazines();
        }
    }

    private void showBooks() {
        library.showBooks();
    }
    private void addBook() {
        if(library.spaceAvailable()) {
            Book book = dataReader.readAndCreateBook();
            library.addBook(book);
        }else{
            fullLibraryForBooks();
        }
    }
    private void fullLibraryForBooks(){
        System.out.println("=================================");
        System.out.println("Nie ma miejsca dla nowej książki");
        System.out.println("=================================");
    }

    private void fullLibraryForMagazines(){
        System.out.println("==================================");
        System.out.println("Nie ma miejsca dla nowego magazynu");
        System.out.println("==================================");
    }

    private void exit() {
        System.out.println("Do widzenia!");
        dataReader.closeApp();
    }

    private void showOptions(){
        System.out.println("\nWybierz opcję: ");
        for(Option option : Option.values()){
            System.out.println(option);
        }
    }
}
