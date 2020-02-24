package common;

/*
 * Class to hold common values and methods to avoid code duplication
 */
public class Utility {
	
	/*
	 * Size of English alphabet
	 */
	public static final int MAX_ARRAY_SIZE = 26;
	
	/*
	 * Java char manipulation that takes an alphabetical index and converts
	 * to corresponding member of the alphabet
	 */
	public static char indexToChar(int index) {
		return (char)(index + 65);
	}
	
	/*
	 * Java char manipulation that takes a character and derives the corresponding
	 * alphabetical index
	 */
	public static int charToIndex(char c) {
		return (c - 'A');
	}

}
