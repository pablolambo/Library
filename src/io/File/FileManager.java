package io.File;

import pl.javastart.library.model.Library;

import java.io.File;
import java.io.IOException;

public interface FileManager {
    // logika z wczytywaniem i zapisywaniem danych
    void saveData(Library library) throws IOException;
    void loadData();
}
