package rotors;

public class EnigmaMachine {

	private Rotor r1;
	private Rotor r2;
	private Rotor r3;
	private Reflector ref;

	/*
	 * Constructor for setting each rotor and the reflector with the passed in
	 * alpha-set
	 */
	public EnigmaMachine(Rotor r1, Rotor r2, Rotor r3, Reflector ref) {
		this.r1 = r1;
		this.r2 = r2;
		this.r3 = r3;
		this.ref = ref;
	}

	/*
	 * Set intial states of each rotor
	 */
	public void setState(int r1Pos, int r2Pos, int r3Pos) {
		r1.set(r1Pos);
		r2.set(r2Pos);
		r3.set(r3Pos);
		

	}
	
	public String encodeLine(String s) {
		String rv = "";
		for (char c : s.toCharArray()) {
			if (Character.isLetter(c) && Character.isUpperCase(c)) {
				rv += encode(c);
			} else {
				rv += c;
			}
		}
		//rv += "\n";
		return rv;
	}
	
	/*
	 * Encode a character by passing through each rotor left to right then
	 * translating against the reflector before traveling back through each rotor
	 * right to left
	 */
	public char encode(char c) {
		char rv = r1.encodeRL(r2.encodeRL(r3.encodeRL(ref.translate(r3.encodeLR(r2.encodeLR(r1.encodeLR(c)))))));

		incrementRotors();

		return rv;
	}
	


	/*
	 * Increment rotor positions If a rotor has made on complete rotation then we
	 * will permit the following rotor to rotate
	 */
	private void incrementRotors() {
		if (r1.inc()) {
			if (r2.inc()) {
				if (r3.inc()) {
				}
			}

		}
	}

}
