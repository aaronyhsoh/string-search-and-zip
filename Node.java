import java.util.Objects;

public class Node implements Comparable<Node> {
    private Node left;
    private Node right;
    private char character;
    private int frequency;
    private String code;

    public Node(Node left, Node right, char character, int frequency) {
        this.left = left;
        this.right = right;
        this.character = character;
        this.frequency = frequency;
        this.code = "";
    }

    public int getFrequency() {
        return this.frequency;
    }

    public char getCharacter() {
        return this.character;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public Node getLeft() {
        return this.left;
    }

    public Node getRight() {
        return this.right;
    }

    @Override
    public String toString() {
        return "character: " + character + "\nfrequency: " + frequency + "\ncode: " + this.code + "\nleft: " + left + "\nright: " + right;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Node node = (Node) obj;
        return Integer.compare(node.getFrequency(), frequency) == 0
                && Objects.equals(character, node.getCharacter());
    }

    @Override
    public int hashCode() {
        return Objects.hash(character, frequency, left, right);
    }

    @Override
    public int compareTo(Node node) {
        if (this.getFrequency() > node.getFrequency()) {
            return 1;
        }
        else if (this.getFrequency() < node.getFrequency()) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
