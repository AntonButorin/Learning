import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class ListOfNumbers {

    private Vector<Integer> vector;

    public ListOfNumbers() {
        vector = new Vector<>();
    }

    public Vector<Integer> getVector() {
        return vector;
    }

    public void writeList() {
        PrintWriter out = null;

        try {
            System.out.println("Entering try statement");
            out = new PrintWriter(new FileWriter("OutFile.txt"));

            for (int i = 0; i < vector.size(); i++)
                out.println("Value at: " + i + " = " + vector.get(i));
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: " +
                    e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }

    public void readList(String path) {
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNext()) {
                String text = scanner.next();
                if (text.matches("\\d+")) {
                    System.out.println(text);
                    vector.add(Integer.valueOf(text));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

