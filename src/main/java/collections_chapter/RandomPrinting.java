package collections_chapter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class RandomPrinting {

    private static final long AVERAGE_LINE_SIZE = 30;
    private List<String> lines;
    private int linesNumber;
    private final String filePath;
    private static final Random random = new Random();

    public RandomPrinting(String filePath) throws IOException {
        this.filePath = filePath;
        initList();
        takeLines();
    }

    private void takeLines() throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.forEach(e -> {
                lines.add(e);
                linesNumber++;
            });
        }
    }

    private void initList() {
        lines = new ArrayList<>(((int) (new File(filePath).length() / AVERAGE_LINE_SIZE) * 2));
    }

    public void printRandomLines(int number) {
        while (number-- > 0) {
            System.out.println(lines.get(random.nextInt(linesNumber - 1)));
        }
    }
}
