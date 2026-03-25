import java.io.*;
import java.util.*;

/**
 * Handles Huffman encoding and decoding, including file I/O and debugging
 * utilities.
 */
public class HuffmanCoding {
    public HuffmanNode root;
    public Map<Character, String> encodingMap;

    public HuffmanCoding() {
        this.root = null;
        this.encodingMap = new HashMap<>();
    }

    /**
     * Builds the Huffman tree from a frequency map.
     */
    public void buildTree(Map<Character, Integer> freqMap) {
        // TODO: Implement Huffman tree building with lexicographical tie-breaking.
        PriorityQueue pq = new PriorityQueue();

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            pq.insert(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        while (pq.size() > 1) {
            HuffmanNode left = pq.extractMin();
            HuffmanNode right = pq.extractMin();

            HuffmanNode merged = new HuffmanNode(null, left.frequency + right.frequency, left, right);
            pq.insert(merged);
        }
        this.root = pq.extractMin();
    }

    /**
     * Generates the encoding map for all characters in the Huffman tree.
     */
    public Map<Character, String> generateEncodingMap() {
        // TODO: Implement code map generation from the Huffman tree.
        generateEncodingMapHelper(root, "");
        return encodingMap;
    }

    private void generateEncodingMapHelper(HuffmanNode node, String code) {
        // TODO: Recursive helper for encoding map generation.
        if (node == null)
            return;

        if (node.isLeaf()) {
            encodingMap.put(node.character, code);
            return;
        }
        generateEncodingMapHelper(node.left, code + "0");
        generateEncodingMapHelper(node.right, code + "1");
    }

    /**
     * Encodes the input file using the current encoding map and writes to a binary
     * file.
     * File format: [map][padding][data]
     */
    public void encodeFile(String inputFile, String outputFile) throws IOException {
        // TODO: Implement file encoding according to the assignment format.

        // Build tree and encoding map from input
        Map<Character, Integer> freqMap = buildFrequencyMap(inputFile);
        buildTree(freqMap);
        generateEncodingMap(); // after this function call, encodingMap should be populated

        // Encode the entire input into a bit string
        StringBuilder bitString = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            int c;
            while ((c = br.read()) != -1) {
                char character = (char) c;
                bitString.append(encodingMap.get(character));
            }
        }

    }

    /**
     * Decodes the binary file and writes the decoded text to outputFile.
     */
    public void decodeFile(String encodedFile, String outputFile) throws IOException {
        // TODO: Implement decoding from the binary file format.
    }

    /**
     * Builds a frequency map from the input text file.
     */
    public static Map<Character, Integer> buildFrequencyMap(String inputFile) throws IOException {
        // TODO: Implement frequency map builder for the input file.
        Map<Character, Integer> freqMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            int c;
            while ((c = br.read()) != -1) {
                char character = (char) c;
                freqMap.put(character, freqMap.getOrDefault(character, 0) + 1);
            }
        }
        return freqMap;
    }

    /**
     * Packs a string of '0' and '1' into a byte array.
     */
    public static byte[] packBits(String bitString) {
        // TODO: Implement bit packing utility.
        return null;
    }

    /**
     * Unpacks a byte array into a string of '0' and '1', up to nBits.
     */
    public static String unpackBits(byte[] data, int nBits) {
        // TODO: Implement bit unpacking utility.
        return null;
    }

    /**
     * Debug utility: Print the binary file as a string of '0' and '1' (excluding
     * header).
     * Reads only the data section (after header + padding byte).
     */
    public static void printBinaryFileAsBits(String encodedFile) throws IOException {
        // TODO: Implement debug print of the binary data in the file.
    }

    /**
     * Debug utility: Print the encoding map.
     */
    public void printEncodingMap() {
        // TODO: Print the encoding map for debugging/validation.
    }
}
