
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    public static void main(String[] args) {
        String filePath = "dictionary.txt"; // Replace with your file path

        if (doesFileExist(filePath)) {
            readAndPrintDictionary(filePath);
        } else {
            System.out.println("File does not exist at the given path.");
        }
    }

    // Method to check if the file exists at the given path
    public static boolean doesFileExist(String path) {
        File file = new File(path);
        return file.exists();
    }

    // Method to read and print the dictionary from the file
    public static void readAndPrintDictionary(String path) {
        Map<String, String[]> dictionary = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("-", 2);
                if (parts.length >= 2) {
                    String word = parts[0].trim();
                    String[] meanings = parts[1].split(",");
                    for (int i = 0; i < meanings.length; i++) {
                        meanings[i] = meanings[i].trim();
                    }
                    dictionary.put(word, meanings);
                }
            }

            // Print the dictionary
            for (Map.Entry<String, String[]> entry : dictionary.entrySet()) {
                System.out.println(entry.getKey());
                for (String meaning : entry.getValue()) {
                    System.out.println(meaning);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
