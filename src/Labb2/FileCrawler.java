package Labb2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class FileCrawler {
    public static void main(String[] args) {
        try {
            File startingFolder = new File("./testData/");

            System.out.println("Hej och välkommen till filKryparen! " + startingFolder.getCanonicalPath());
            System.out.println("Startsökväg: " + startingFolder.getCanonicalPath());
            Scanner searchString = new Scanner(System.in);
            System.out.println("Sökord: ");
            System.out.println("-------");
            System.out.println();

            printInfo(startingFolder, searchString);

        } catch (Exception e) {
            System.out.println("Oops");
        }
    }

    public static void printInfo(File file, String string) {
        // Om det är en vanlig fil: Skriv ut namnet på filen
        // Om det är en mapp: Skriv ut sökvägen på mappen, och gå in i mappen

        if (file.isFile()) {
            Scanner sc = null;
            try {
                sc = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            while(sc.hasNextLine()){
                sc.nextLine();
                if(sc.findInLine(string) != null){
                    System.out.println("Fil: " + file.getName());
                    return;
                }

            }

        }
    }
}
