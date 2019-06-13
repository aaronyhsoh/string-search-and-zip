import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

/**
 * A new instance of HuffmanCoding is created for every run. The constructor is
 * passed the full text to be encoded or decoded, so this is a good place to
 * construct the tree. You should store this tree in a field and then use it in
 * the encode and decode methods.
 */
public class HuffmanCoding {

	private Node huffmanTree;
	private HashMap<Character, String> encodingTable = new HashMap<>();

	/**
	 * This would be a good place to compute and store the tree.
	 */
	public HuffmanCoding(String text) {
		// TODO fill this in.
		Map<Character, Integer> frequencyMap = new HashMap<>();
		int textLength = text.length();

		for (int i = 0; i < textLength; i++) {
			char character = text.charAt(i);
			if (!frequencyMap.containsKey(character)) {
				frequencyMap.put(character, 1);
			}
			else {
				int newFreq = frequencyMap.get(character) + 1;
				frequencyMap.replace(character, newFreq);
			}
		}

		PriorityQueue<Node> queue = new PriorityQueue<>();

		Iterator iterator = frequencyMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Character, Integer> pair = (Map.Entry<Character, Integer>) iterator.next();
			Node node = new Node(null, null, pair.getKey(), pair.getValue());
			queue.add(node);
		}

		while (queue.size() > 1) {
			Node node1 = queue.poll();
			Node node2 = queue.poll();
			Node parent = new Node(node1, node2, '\t', node1.getFrequency() + node2.getFrequency());
			queue.add(parent);
		}
		huffmanTree = queue.poll();
		System.out.println("firstNode: "+ huffmanTree);
		codeTable(huffmanTree);

		//Iterator iterator1 = encodingTable.entrySet().iterator();

		/*
		while (iterator1.hasNext()) {
			Map.Entry<Character, String> pair = (Map.Entry<Character, String>) iterator1.next();
			System.out.println(pair.getKey() + " : " + pair.getValue() + "\n");
		}
		*/

		//System.out.println("Hashmap.size() : " + frequencyMap.size());

	}

	/**
	 * Take an input string, text, and encode it with the stored tree. Should
	 * return the encoded text as a binary string, that is, a string containing
	 * only 1 and 0.
	 */
	public String encode(String text) {
		// TODO fill this in.

		String encodedText = "";
		System.out.println("text.length(): " + text.length());
		for (int i = 0; i < text.length(); i++) {
			String characterCode = encodingTable.get(text.charAt(i));
			System.out.println(text.charAt(i));
			encodedText = encodedText.concat(characterCode);
		}
		System.out.println("THISHERE: \n" + encodedText + "\nTHISEND");

		return encodedText;
	}

	/**
	 * Take encoded input as a binary string, decode it using the stored tree,
	 * and return the decoded text as a text string.
	 */
	public String decode(String encoded) {
		// TODO fill this in.
		StringBuilder decodedText = new StringBuilder();
		Node currentBit = huffmanTree;
		int index = 0;
		//System.out.println(currentBit.getLeft());
		//System.out.println(currentBit.getRight());
		while (index < encoded.length()) {
			if (encoded.charAt(index) == '0') {
				if (currentBit.getLeft() != null) {
					currentBit = currentBit.getLeft();
				}
				else {
					decodedText.append(currentBit.getCharacter());
					currentBit = huffmanTree;
					index--;
				}
			}
			else {
				if (currentBit.getRight() != null) {
					currentBit = currentBit.getRight();
				}
				else {
					decodedText.append(currentBit.getCharacter());
					currentBit = huffmanTree;
					index--;
				}
			}
			index++;
            if (index == encoded.length()) {
                decodedText.append(currentBit.getCharacter());
            }
		}
        System.out.println("EncondedText: " + encoded);
		System.out.print("decodedText: " + decodedText.toString());
		return decodedText.toString();

	}

	/**
	 * The getInformation method is here for your convenience, you don't need to
	 * fill it in if you don't wan to. It is called on every run and its return
	 * value is displayed on-screen. You could use this, for example, to print
	 * out the encoding tree.
	 */
	public String getInformation() {
		return "";
	}

	public void codeTable(Node node) {
		//System.out.println(node.getCharacter());
		if (node.getLeft() != null) {
			String currentCode = node.getCode();
			node.getLeft().setCode(currentCode.concat("0"));
			encodingTable.put(node.getLeft().getCharacter(), node.getLeft().getCode());
			codeTable(node.getLeft());
		}
		if (node.getRight() != null) {
			String currentCode = node.getCode();
			node.getRight().setCode(currentCode.concat("1"));
			encodingTable.put(node.getRight().getCharacter(), node.getRight().getCode());
			codeTable(node.getRight());
		}
		encodingTable.put(node.getCharacter(), node.getCode());
	}
}
