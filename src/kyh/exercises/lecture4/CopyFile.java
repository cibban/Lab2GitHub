package kyh.exercises.lecture4;

import java.io.File;
import java.io.FileWriter;

/*
 Kopiera en fil till en annan
 */

// Javadoc:
// https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/io/File.html
// https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/io/FileWriter.html

public class CopyFile {
    public static void main(String[] args) {
        try {
            // Sätt upp vilka filer vi vill läsa och skriva
            File fromFile = new File("CJL.txt");
            FileWriter toFile = new FileWriter("CJL_copy.txt");
            
            // Så länge fromFile har en rad:
            // Läs raden från fromFile
            // Skriv raden till toFile

            // Stäng fromFile
            // Stäng toFile

            System.out.println("Successfully copied the file.");
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }
    }
}
