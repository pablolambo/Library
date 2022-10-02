package pl.javastart.library.app;

import Exceptions.NoSuchOptionException;

enum Option {
    EXIT(0, "Wyjście z programu"),
    ADD_BOOK(1, "Dodanie książki"),
    ADD_MAGAZINE(2,"Dodanie magazynu/gazety"),
    SHOW_BOOKS(3, "Wyświetlenie dostępnych książek"),
    SHOW_MAGAZINES(4, "Wyświetlenie dostępnych magazynów/gazet"),
    SHOW_ALL_PUBLICATIONS(5,"Wyświetlenie wszystkich dostępnych publikacji");

    private int value;
    private String description;

    Option(int value, String desc) {
        this.value = value;
        this.description = desc;
    }

    @Override
    public String toString() {
        return value + " - " + description;
    }


    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    static Option createFromInt(int option) throws NoSuchOptionException { // statyczna zeby nie musiec jej wywolywac dluzej
        try {
            return Option.values()[option];
        } catch (ArrayIndexOutOfBoundsException e){
            throw new NoSuchOptionException("Brak opcji o id: " + option);
        }
    }
}
