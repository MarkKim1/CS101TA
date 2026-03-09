import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Example usage and demonstration
        // To test, create a text file input.txt with some content.
        String inputFile = "input.txt";
        String encodedFile = "encoded.bin";
        String decodedFile = "decoded.txt";
        HuffmanCoding hc = new HuffmanCoding();
        try {
            // Encode
            hc.encodeFile(inputFile, encodedFile);
            System.out.println("Encoding complete.");
            hc.printEncodingMap();
            // Print the encoded binary file as bits (debug)
            System.out.print("Encoded file bits: ");
            HuffmanCoding.printBinaryFileAsBits(encodedFile);
            // Decode
            hc.decodeFile(encodedFile, decodedFile);
            System.out.println("Decoding complete.");
            // Show padding for verification
            // (For demonstration, open encodedFile and read the padding byte)
            try (FileInputStream fis = new FileInputStream(encodedFile)) {
                int numChars = fis.read();
                for (int i = 0; i < numChars; i++) {
                    fis.read(); // char
                    int len = fis.read();
                    int bytesNeeded = (len + 7) / 8;
                    for (int j = 0; j < bytesNeeded; j++)
                        fis.read();
                }
                int padding = fis.read();
                System.out.println("Padding bits: " + padding);
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
