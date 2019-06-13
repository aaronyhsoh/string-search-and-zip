import java.util.ArrayList;

/**
 * A new KMP instance is created for every substring search performed. Both the
 * pattern and the text are passed to the constructor and the search method. You
 * could, for example, use the constructor to create the match table and the
 * search method to perform the search itself.
 */
public class KMP {
	private char[] patternArray;
	private int patternLength;
	private char[] textArray;
	private int textLength;
	private int[] KMPMatchTable;

	public KMP(String pattern, String text) {
		// TODO maybe fill this in.
		this.patternArray = pattern.toCharArray();
		this.patternLength = pattern.length();
		this.textArray = text.toCharArray();
		this.textLength = text.length();
		this.KMPMatchTable = buildMatchTable();
	}

	private int[] buildMatchTable() {
		int[] matchTable = new int[this.patternLength];
		int j = 0;
		int pos = 2;
		matchTable[0] = -1;
		matchTable[1] = 0;

		while (pos < this.patternLength) {
			if (this.patternArray[pos - 1] == this.patternArray[j]) {
				matchTable[pos] = j + 1;
				pos++;
				j++;
			}
			else if (j > 0) {
				j = matchTable[j];
			}
			else {
				matchTable[pos] = 0;
				pos++;
			}
		}

		return matchTable;
	}

	/**
	 * Perform KMP substring search on the given text with the given pattern.
	 * 
	 * This should return the starting index of the first substring match if it
	 * exists, or -1 if it doesn't.
	 */
	public int search() {
		// TODO fill this in.
		int k = 0;
		int i = 0;

		/*
		for (int x = 0; x < this.KMPMatchTable.length; x++) {
			System.out.println(this.KMPMatchTable[x]);
		}
		*/

		while(k + i < this.textLength) {
			if (this.patternArray[i] == this.textArray[k + i]) {
				i++;
				if (i == this.patternLength) {
					return k;
				}
			}
			else if (this.KMPMatchTable[i] == -1) {
				k += i + 1;
				i = 0;
			}
			else {
				k += i - this.KMPMatchTable[i];
				i = this.KMPMatchTable[i];
			}
		}

		return -1;
	}
}
