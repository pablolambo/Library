package pl.javastart.library.model;

import java.io.Serial;
import java.io.Serializable;

public class Library implements Serializable {
    public static final int MAX_PUBLICATIONS = 2000;
    private Publication[] publications = new Publication[MAX_PUBLICATIONS];
    private int publicationsAmount;

    public void addBook(Book book){
        addPublication(book);
    }

    public void addMagazine(Magazine magazine){
        addPublication(magazine);
    }

    private void addPublication(Publication publication){
        if(publicationsAmount >= MAX_PUBLICATIONS) {
            throw new ArrayIndexOutOfBoundsException("Osiągnięto limit: " + MAX_PUBLICATIONS);
        }
        publications[publicationsAmount] = publication;
        publicationsAmount++;
    }
    // zwraca tablice ale bez nulli
    public Publication[] getPublications() {
        Publication[] copyWithoutNulls = new Publication[publicationsAmount];
        for (int i = 0; i < copyWithoutNulls.length; i++) {
            copyWithoutNulls[i] = publications[i];
        }
        return copyWithoutNulls;
    }

    public int getPublicationsAmount() {
        return publicationsAmount;
    }

    public boolean spaceAvailable(){
        return publicationsAmount < MAX_PUBLICATIONS;
    }

    // zwraca napis złożony ze wszystkich książek i magazynów w bibliotece.
    public String toString(){
        StringBuilder allPublicationsAvailable = new StringBuilder();
        for (int i = 0; i < publicationsAmount ;i++){
            allPublicationsAvailable.append(publications[i]);
            allPublicationsAvailable.append("\n");
        }
        return allPublicationsAvailable.toString();
    }

    public void showAllPublications() {

    }
}
