package pl.javastart.library.model;

public class Library {
    private static final int MAX_PUBLICATIONS = 2000;
    private Publication[] publications = new Publication[MAX_PUBLICATIONS];
    private int publicationsAmount;

    public void addBook(Book book){
        if(publicationsAmount < MAX_PUBLICATIONS) {
            publications[publicationsAmount] = book;
            publicationsAmount++;
        } else
            System.out.println("Nie ma miejsca.");
    }

    public void addMagazine(Magazine magazine){
        publications[publicationsAmount] = magazine;
        publicationsAmount++;
    }

    public boolean spaceAvailable(){
        return publicationsAmount < MAX_PUBLICATIONS;
    }

    public void showBooks(){
        int countBooks = 0;
        for (int i = 0; i < publicationsAmount; i++) {
               if(publications[i] instanceof Book) {
                   System.out.println(publications[i]); // toString() automatycznie wywolany
                   countBooks++;
               }
        }
        if(countBooks == 0){
            System.out.println("Brak książek w bibliotece ");
        }
    }

    public void showMagazines() {
        int countMagazines = 0;
        for (int i = 0; i < publicationsAmount; i++) {
            if(publications[i] instanceof Magazine) {
                System.out.println(publications[i]);
                countMagazines++;
            }
        }
        if(countMagazines == 0){
            System.out.println("Brak magazynów w bibliotece ");
        }
    }

    public void showAllPublications(){
        System.out.println(toString() + "Ilość publikacji: ["+publicationsAmount+"/"+MAX_PUBLICATIONS+"]");
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
}
