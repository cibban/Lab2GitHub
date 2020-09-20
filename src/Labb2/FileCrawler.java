package Labb2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class FileCrawler {

    // Initiera en global träffräknare.
    // (Jag skapade den för debug egentligen men det är ju onödigt att ta bort den. //P)
    static int hitCount = 0;

    public static void main(String[] args) {
            //Initiera variabler
            File initialPath = new File("./");
            Scanner userInput = new Scanner(System.in);
            String searchString;


            // Be användaren om en söksträng.
            System.out.println("Välkommen till filKryparen!");
            System.out.println();
            System.out.print("Skriv ett sökord: ");
            searchString = userInput.nextLine();
            System.out.println("-------");
            System.out.println();

        try {
            // Påbörja sökningen.
            crawlFileTree(initialPath, searchString);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Skriv ut en tom rad och antal träffar.
        System.out.println();
        System.out.println(hitCount + " filer hittades.");
    }

    public static void crawlFileTree(File filePath, String searchString) {

        try {
            // Om nästa sökväg i listan pekar på en katalog kallar funktionen
            // på sig själv och fortsätter nedåt.
            if (filePath.isDirectory()) {

                File[] folderContents = filePath.listFiles();
                for (File contentPath : folderContents) {
                    crawlFileTree(contentPath, searchString);
                }

            // Om nästa sökväg i listan är en fil, öppna filen och sök
            } else if (filePath.isFile()) {
                Scanner fileScan = new Scanner(filePath);

                // Läs in nästa rad.
                while(fileScan.hasNextLine()) {
                    fileScan.nextLine();

                    // Sök efter söksträngen i textraden.
                    // Vid träff, skriv ut filens sökväg, uppdatera räknaren
                    // stäng filen och återvänd.
                    if(searchString.equals(fileScan.findInLine(searchString))) {
                        System.out.println(filePath.getCanonicalPath());
                        hitCount++;
                        fileScan.close();
                        return;
                    }
                }
            }

            // Kontrollera om filen går att läsa.
            // Om inte, skriv till System.error.
            if(!filePath.canRead()) {
                System.err.println("Fel: Kan inte läsa " + filePath.getCanonicalPath());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

