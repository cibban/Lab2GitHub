package Labb2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class FileCrawler {

    // Initiera en global träffräknare.
    // (Jag skapade den för debug egentligen men det är ju onödigt att ta bort den. //P)
    static int hitCount = 0;

    public static void main(String[] args) throws IOException {
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

    public static void crawlFileTree(File filePath, String searchString) throws IOException {
        // Om filen/katalogen inte går att läsa, skriv felmeddelande till System.error.
        if (!filePath.canRead()) System.err.println("Det går inte att läsa filen " + filePath.getCanonicalPath());


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
            Scanner fileScan;
                fileScan = new Scanner(filePath);

            // Läs in nästa rad.
            while(fileScan.hasNextLine()) {

                // Vid träff, skriv ut filens sökväg och uppdatera räknaren
                if(searchString.equals(fileScan.findInLine(searchString))) {
                    try {
                        System.out.println(filePath.getCanonicalPath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    hitCount++;
                    return;
                }
                fileScan.nextLine();
            }
            // Stäng filen.
            fileScan.close();
        }
    }
}

