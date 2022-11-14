package io.File;

import Exceptions.DataSaveException;
import pl.javastart.library.model.Library;

import java.io.*;

public class SerializableFileManager implements FileManager{
    private static String FILE_NAME = "Library.obj";

    @Override
    public void saveData(Library library) throws IOException {
        try(
                FileOutputStream fos = new FileOutputStream(FILE_NAME);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                ){
            oos.writeObject(oos);
        } catch(FileNotFoundException e){
            throw new DataSaveException("Brak pliku o nazwie: " + FILE_NAME);
        } catch(IOException e){
            throw new DataSaveException("Błąd zapisu danych do pliku " + FILE_NAME);
        }
    }

    @Override
    public void loadData() {
        Library library = null;
        try(
                FileInputStream fis = new FileInputStream(FILE_NAME);
                ObjectInputStream ois = new ObjectInputStream(fis);
                ){
            library = (Library) ois.readObject();
        } catch (IOException e) {
            throw new DataSaveException("Błąd odczytu: " + FILE_NAME);
        } catch (ClassNotFoundException e) {
            throw new DataSaveException("Niezgodny typ danych w pliku: " + FILE_NAME);
        }
    }
}
