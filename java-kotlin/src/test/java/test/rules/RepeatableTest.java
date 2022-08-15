package test.rules;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;

class FileWriter {
    public void writeFile(String fileName, String fileContent) {
        Path path = Paths.get(fileName);
        byte[] strToBytes = fileContent.getBytes();

        if (Files.exists(path)) {
            throw new RuntimeException("You cannot do this!");
        }

        try {
            Files.write(path, strToBytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class NotRepeatableTest {
    FileWriter writer;

    @BeforeEach
    public void setup() {
        writer = new FileWriter();
    }

    @Test
    public void should_writeWhenContentIsEmpty() {
        writer.writeFile("fileName.txt", "");
    }

    @Test
    public void should_writeWhenContentIsNotEmpty() {
        writer.writeFile("fileName.txt", "Content");
    }

}

class RepeatableTest {
    FileWriter writer;

    @BeforeEach
    public void setup() {
        writer = new FileWriter();
    }

    @AfterEach
    public void tearDown() {
        File folder = new File(".");
        for (File f : folder.listFiles()) {
            if (f.getName().endsWith(".test")) {
                f.delete(); // may fail mysteriously - returns boolean you may want to check
            }
        }
    }

    @Test
    public void should_writeWhenContentIsEmpty() {
        writer.writeFile("fileName.test", "");
    }

    @Test
    public void should_writeWhenContentIsNotEmpty() {
        writer.writeFile("fileName.test", "Content");
    }

}
