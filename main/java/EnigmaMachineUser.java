import rotors.EnigmaMachine;
import rotors.Reflector;
import rotors.Rotor;

public class EnigmaMachineUser {
	
	public static void main(String[] args) {
		
		Rotor r1 = new Rotor("QWERTYUIOPLKJHGFDSAZXCVBNM");
		Rotor r2 = new Rotor("ZAQWSXCDERFVBGTYHNMJUIKLOP");
		Rotor r3 = new Rotor("PLOKMIJNUHBYGVTFCRDXESZWAQ");
		Reflector ref = new Reflector("NPKMSLZTWQCFDAVBJYEHXOIURG");
		EnigmaMachine em = new EnigmaMachine(r1, r2, r3, ref);
		
		String s = "AAAAAAAAAAAAAAAAAAAAAAAAAAA";
		System.out.println(s);
		
		em.setState(5, 9, 14);
		String encodedS = em.encodeLine(s);
		System.out.println(encodedS);
		
		em.setState(5, 9, 14);
		String decodedS = em.encodeLine(encodedS);
		System.out.println(decodedS);
	}

}
