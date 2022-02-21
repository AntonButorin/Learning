import java.io.*;
import java.util.Scanner;

public class CountCharacter {
    protected String path;
    protected String letter;

    public CountCharacter(String letter, String path) {
        if (letter.length() != 1) {
            throw new IllegalArgumentException("There is no one character");
        }
        this.letter = letter;
        this.path = path;
    }

    public static void validConsole(String[] args) {
        if (args.length != 1 && args[0].length() != 1) {
            throw new IllegalArgumentException("There is no one character");
        }
    }

    public int count() {
        int count = 0;
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(path)))) {
            while (scanner.hasNextLine()) {
                while (scanner.findInLine(letter) != null) {
                    count++;
                }
                scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return count;
    }
}
