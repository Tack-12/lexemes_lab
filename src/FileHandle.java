import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandle {
    public static void createAndWriteFile(String content) {
        String filePath = "C:\\Java_Software_Development\\output.txt";
        try {
            File file = new File(filePath);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists. Overwriting content.");
            }

            try (FileWriter writer = new FileWriter(file)) {
                writer.write(content);
                System.out.println("Successfully wrote to the file.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

