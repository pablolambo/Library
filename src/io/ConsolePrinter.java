package io;

import pl.javastart.library.model.Book;
import pl.javastart.library.model.Magazine;
import pl.javastart.library.model.Publication;

import static pl.javastart.library.model.Library.MAX_PUBLICATIONS;
// jesli chce wszystkie sout wyswietlic TOUPPERCASE metoda to tylko w jednym miejscu dodaje!
public class ConsolePrinter {

    public void showBooks(Publication[] publications){
        int countBooks = 0;
        for (Publication publication : publications) {
            if (publication instanceof Book) {
                printLine(publication.toString());
                countBooks++;
            }
        }
        if(countBooks == 0){
            printLine("Brak książek w bibliotece.");
        }
    }

    public void showMagazines(Publication[] publications) {
        int countMagazines = 0;
        for (Publication publication : publications) {
            if(publication instanceof Magazine) {
                printLine(publication.toString());
                countMagazines++;
            }
        }
        if(countMagazines == 0){
            printLine("Brak magazynów w bibliotece.");
        }
    }

    public void showAllPublications(Publication[] publication){
        printLine(/* toString() +*/ "Ilość publikacji: [" + publication.length + "/" + MAX_PUBLICATIONS + "]");
    }

    public void printLine(String line){
        System.out.println(line);
    }

    public void printError(String line){
        System.err.println(line);
    }
}

