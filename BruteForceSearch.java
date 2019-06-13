public class BruteForceSearch {
    private char[] patternArray;
    private int patternLength;
    private char[] textArray;
    private int textLength;

    public BruteForceSearch(String pattern, String text) {
        this.patternArray = pattern.toCharArray();
        this.patternLength = pattern.length();
        this.textArray = text.toCharArray();
        this.textLength = text.length();
    }

    public int search() {
        boolean found;
        for (int i = 0; i <= this.textLength - this.patternLength; i++) {
            found = true;
            for (int j = 0; j < this.patternLength; j++) {
                if (this.patternArray[j] != this.textArray[i + j]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }

        return -1;
    }
}
