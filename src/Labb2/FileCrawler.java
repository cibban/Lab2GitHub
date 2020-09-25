package Labb2;

import java.io.File;
import java.io.FileNotFoundException;
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

        // Påbörja sökningen.
        crawlFileTree(initialPath, searchString);

        // Skriv ut en tom rad och antal träffar.
        System.out.println();
        System.out.println(hitCount + " filer hittades.");
    }

    public static void crawlFileTree(File filePath, String searchString) {
        //Hämta filens absoluta sökväg.
        String absolutePath = filePath.getAbsolutePath();

        // Debug: System.out.println("Öppnar filen " + absolutePath);

        // Om filen/katalogen inte går att läsa, skriv felmeddelande till System.error
        // och återvänd.
        if (!filePath.canRead()){
            System.err.println("Filen går inte att läsa: " + absolutePath);
            return;
        }

        // Om nästa sökväg i listan pekar på en katalog kallar funktionen
        // på sig själv och fortsätter nedåt i filstrukturen.
        if (filePath.isDirectory()) {

            File[] folderContents = filePath.listFiles();
            if (folderContents != null) {
                for (File contentPath : folderContents) {
                    crawlFileTree(contentPath, searchString);
                }
            }

            // Om nästa sökväg i listan är en fil, öppna filen och sök
        } else if (filePath.isFile()) {
            try {
                Scanner fileScan = new Scanner(filePath);

                // Läs in nästa rad.
                while(fileScan.hasNextLine()) {

                    // Vid träff, skriv ut filens sökväg och uppdatera räknaren
                    if(searchString.equals(fileScan.findInLine(searchString))) {
                        System.out.println(absolutePath);
                        hitCount++;
                        break;
                    } else if (fileScan.hasNextLine()){
                        /* Jag är osäker på varför detta villkor behövs igen när vi ställer
                           det i while-loopen, men utan det kommer sökningar på t.ex. punkt
                           att kasta NoSuchElementException. --Patrik */
                        fileScan.nextLine();
                    }
                }

                // Stäng filen.
                // Debug: System.out.println("Stänger filen " + absolutePath);
                fileScan.close();
                System.err.println(absolutePath + " har ingen nästa rad.");

            } catch (FileNotFoundException fileNotFoundException) {
                System.err.println(absolutePath + " finns inte.");
            }
        }
    }
}

