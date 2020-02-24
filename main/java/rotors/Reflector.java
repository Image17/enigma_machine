package rotors;

import common.Utility;

public class Reflector {

	private char[] reflection;
	
	/*
	 * Initialize reflector with passed in alpha-set
	 */
	public Reflector(String input) {
		this.reflection = input.toCharArray();
	}
	
	/*
	 * Takes char and returns corresponding reflection
	 */
	public char translate(char c) {
		return reflection[Utility.charToIndex(c)];
	}
}