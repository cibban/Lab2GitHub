package kyh.lectures;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Lecture4 {

    public static void printFile(String content) {
        File file = new File("CJL.txt");
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(content);
            fw.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void readFile() {
        File file = new File("CJL.txt");
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        printFile("Varför är den gode dum?");
    }
}
