import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class PersistentEcho {

    public String getStringFromArgs(String... args) {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(args).forEach(e -> stringBuilder.append(e).append(" "));
        return stringBuilder.toString().trim();
    }

    public void saveProperty(String fileName, String prop, String value) throws IOException {
        Properties properties = new Properties();
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            properties.setProperty(prop, value);
            properties.store(out, prop);
        }
    }

    public String getProperty(String fileName, String prop) throws IOException {
        Properties properties = new Properties();
        try (FileInputStream in = new FileInputStream(fileName)) {
            properties.load(in);
            return properties.getProperty(prop);
        }
    }

    public static void main(String[] args) {
        PersistentEcho persistentEcho = new PersistentEcho();
        String prop = "PERSISTENTECHO";
        String fileName = "PersistentEcho.txt";
        String outPut = "";
        try {
            if (args.length > 0) {
                outPut = persistentEcho.getStringFromArgs(args);
                persistentEcho.saveProperty(fileName, prop, outPut);
            } else {
                String value = System.getenv(prop);
                if (value != null) {
                    outPut = value;
                    persistentEcho.saveProperty(fileName, prop, value);
                } else {
                    value = persistentEcho.getProperty(fileName, prop);
                    outPut = value != null ? value : String.format("There is no property %s in file", prop);
                }
            }
        } catch (IOException e) {
            System.out.println("Can not read the file");
        } finally {
            if (!outPut.isEmpty()) {
                System.out.println(outPut);
            }
        }
    }
}