package io.File;

import Exceptions.NoSuchFileTypeException;
import io.ConsolePrinter;
import io.DataReader;

import java.io.File;

public class FileManagerBuilder {
    // logika z wyborem zapisu pliku, nie ma scanera IO
    // user musi podac poprawna nazwe
    // flaga
    private DataReader dataReader;
    private ConsolePrinter consolePrinter;


    public FileManagerBuilder(DataReader dataReader, ConsolePrinter consolePrinter) {
        this.dataReader = dataReader;
        this.consolePrinter = consolePrinter;
    }

    public FileManager getFileManager(){
        FileType fileType = getFileType();
        FileManager fileManager = null;
        switch (fileType){
            case SERIAL:
                return new SerializableFileManager();
            default:
                throw new NoSuchFileTypeException("Nieobsługiwany typ pliku");
        }

    }

    private FileType getFileType(){
        FileType userFileTypeChoice = null;
        String input = "";
        boolean isFormatOk = false;
        do {
            consolePrinter.printLine("Wybierz format pliku: ");
            printValues();
            input = dataReader.getString().toUpperCase();
            try {
                userFileTypeChoice = FileType.valueOf(input);
                isFormatOk = true;
            } catch (Exception e){
                consolePrinter.printError("Nieobsługiwany typ pliku '" + input + "' Wybierz ponownie.");
            }
        } while(!isFormatOk);
        return userFileTypeChoice;
    }

    private void printValues(){
        for(FileType fileType : FileType.values()){
            consolePrinter.printLine(fileType.name());
        }
    }
}
