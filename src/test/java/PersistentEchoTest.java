import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.*;

public class PersistentEchoTest {

    @Test
    public void checkGettingStringFromArgs() {
        String[] arr = {"test1", "test2", "test3"};
        PersistentEcho persistentEcho = new PersistentEcho();
        assertEquals("test1 test2 test3", persistentEcho.getStringFromArgs(arr));
    }

    @Test
    public void checkSavingProperty() throws IOException {
        String fileName = "PersistentEcho.txt";
        String prop = "PERSISTENTECHO";
        String value = "test";
        Properties properties = new Properties();
        PersistentEcho persistentEcho = new PersistentEcho();
        persistentEcho.saveProperty(fileName, prop, value);
        assertTrue(new File(fileName).exists());
        try (FileInputStream in = new FileInputStream(fileName)) {
            properties.load(in);
            assertEquals(value, properties.getProperty(prop));
        }
    }

    @Test
    public void checkGettingExistingProperty() throws IOException {
        String fileName = "PersistentEcho.txt";
        String prop = "PERSISTENTECHO";
        String value = "test1";
        PersistentEcho persistentEcho = new PersistentEcho();
        Properties properties = new Properties();
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            properties.setProperty(prop, value);
            properties.store(out, prop);
        }
        assertEquals(value, persistentEcho.getProperty(fileName, prop));
    }

    @Test
    public void checkGettingNonExistingProperty() throws IOException {
        String fileName = "PersistentEcho.txt";
        String prop = "PERSISTENTECHO";
        String prop2 = "PERSISTENTECHO2";
        String value = "test1";
        PersistentEcho persistentEcho = new PersistentEcho();
        Properties properties = new Properties();
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            properties.setProperty(prop, value);
            properties.store(out, prop);
        }
        assertNull(persistentEcho.getProperty(fileName, prop2));
    }
}
