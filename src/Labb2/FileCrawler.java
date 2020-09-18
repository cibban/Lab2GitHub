package Labb2;

import java.io.File;
import java.util.Scanner;


public class FileCrawler {

    // Initiera träffräknare.
    static int hitCount = 0;

    public static void main(String[] args) {
            //Initiera variabler
            File initialPath = new File("./testData/");
            Scanner userInput = new Scanner(System.in);
            String searchString;


            // Be användaren om en söksträng.
            System.out.println("Välkommen till filKryparen!");
            System.out.print("Skriv in ett sökord: ");
            searchString = userInput.nextLine();
            System.out.println("-------");
            System.out.println();

        try {
            // Påbörja sökningen.
            crawlFileTree(initialPath, searchString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println(hitCount + " filer hittades.");
    }

<<<<<<< HEAD
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
                    // Vid träff, skriv ut filens sökväg och uppdatera räknaren.
                    if(searchString.equals(fileScan.findInLine(searchString))) {
                        System.out.println(filePath.getCanonicalPath());
                        hitCount++;
                        return;
                    }
=======
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
>>>>>>> 3410aa076ff780b43f2dde721db1ba1b811d1df5
                }
            }

<<<<<<< HEAD
            // Kontrollera om filen går att läsa.
            // Om inte, skriv till System.error.
            if(!filePath.canRead()) {
                System.err.println("Fel: Kan inte läsa " + filePath.getCanonicalPath());
            }
        } catch (Exception e) {
            e.printStackTrace();
=======
            }

>>>>>>> 3410aa076ff780b43f2dde721db1ba1b811d1df5
        }
    }
}

