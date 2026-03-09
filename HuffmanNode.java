/**
 * Represents a node in the Huffman tree.
 * Leaf nodes have a non-null character; internal nodes have character == null.
 */
public class HuffmanNode {
    public Character character; // null for internal nodes
    public int frequency;
    public HuffmanNode left;
    public HuffmanNode right;

    public HuffmanNode(Character character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }

    public HuffmanNode(Character character, int frequency, HuffmanNode left, HuffmanNode right) {
        this.character = character;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    public boolean compare(HuffmanNode other) {
        if (this.character.equals(other.character)) {
            return this.frequency < other.frequency;
        }
        return this.character < other.character;
    }

    /**
     * Returns the leftmost leaf character in the subtree rooted at this node.
     * Used for tie-breaking in the priority queue.
     */
    public char getLeftmostLeafChar() {
        // TODO: Implement this method according to the assignment specification.

        return '\0';
    }

    public boolean isLeaf() {
        // TODO: Implement this method according to the assignment specification.
        return false;
    }
}
