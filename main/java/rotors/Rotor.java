package rotors;

import common.Utility;

public class Rotor {

	private char[] leftToRight = new char[Utility.MAX_ARRAY_SIZE];
	private char[] rightToLeft = new char[Utility.MAX_ARRAY_SIZE];
	private char[] alphaSet;
	private String a;
	private int position = 0;

	/*
	 * Store alpha-set for later rotations and initialize left to right and right to
	 * left wirings
	 */
	public Rotor(String input) {
		this.a = input;
		init();
	}

	private void init() {
		alphaSet = a.toCharArray();
		position = 0;
		for (int i = 0; i < Utility.MAX_ARRAY_SIZE; i++) {
			leftToRight[i] = (char) ((alphaSet[i] - 'A') + 65);
		}
		for (int i = 0; i <= 25; i++) {
			rightToLeft[(alphaSet[i] - 'A')] = Utility.indexToChar(i);
		}
	}

	/*
	 * Set initial state for the rotor viaimplementing the incrementing function
	 * Note: This is generally infefficient to do this iteratively, a single step
	 * solution would be a superior implementation
	 */
	public void set(int n) {
		//System.out.println(rightToLeft);
		init();
		for (int i = n; i > 0; i--) {
			inc();
		}
		//System.out.println(rightToLeft);
	}

	/*
	 * Increment current position and rebuild right to left wiring and return
	 * boolean value indicative of one full rotation
	 */
	public boolean inc() {
		position++;

		char first = alphaSet[0];
		System.arraycopy(alphaSet, 1, alphaSet, 0, alphaSet.length - 1);
		alphaSet[alphaSet.length - 1] = first;
		for (int i = 0; i < Utility.MAX_ARRAY_SIZE; i++) {
			rightToLeft[(alphaSet[i] - 'A')] = Utility.indexToChar(i);
		}

		if (position % Utility.MAX_ARRAY_SIZE == 0) {
			position = 0;
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Encode given char according to leftToRight wiring
	 */
	public char encodeLR(char c) {
		int index = ((c - 'A') + position) % Utility.MAX_ARRAY_SIZE;
		if (index % Utility.MAX_ARRAY_SIZE == 0 || index > 25 || index < 0) {
			index = 0;
		}
		return leftToRight[index];
	}

	public char encodeRL(char c) {
		int index = (c - 'A');

		return rightToLeft[index];
	}

}
