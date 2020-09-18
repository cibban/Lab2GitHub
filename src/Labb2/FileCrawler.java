package Labb2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class FileCrawler {
    public static void main(String[] args) {
        try {
            File startingFolder = new File("./testData/");

            System.out.println("Starting Path: " + startingFolder.getCanonicalPath());
            System.out.println("Contains: " + Arrays.toString(startingFolder.list()));
            System.out.println("-------");
            System.out.println();

            printInfo(startingFolder);
        } catch (Exception e) {
            System.out.println("Oops");
        }
    }

    public static void printInfo(File file) {
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
                        if(sc.findInLine("Vatten") != null){
                            System.out.println("Fil: " + file.getName());
                            return;
                        }

                    }
        } else if (file.isDirectory()) {
            try {
                System.out.println("Mapp: " + file.getCanonicalPath());

                File[] folderContents = file.listFiles();
                for (int i = 0; i < folderContents.length; i++) {
                    File f = folderContents[i];
                    printInfo(f);
                }

            } catch (Exception e) {
                System.out.println("Oops");
            }
        }
    }
}
