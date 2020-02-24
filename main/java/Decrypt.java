import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import rotors.EnigmaMachine;
import rotors.Reflector;
import rotors.Rotor;

public class Decrypt {
	
	public static void main(String[] args) throws IOException {
		Rotor r1 = new Rotor("QWERTYUIOPLKJHGFDSAZXCVBNM");
		Rotor r2 = new Rotor("ZAQWSXCDERFVBGTYHNMJUIKLOP");
		Rotor r3 = new Rotor("PLOKMIJNUHBYGVTFCRDXESZWAQ");
		Reflector ref = new Reflector("NPKMSLZTWQCFDAVBJYEHXOIURG");
		EnigmaMachine em = new EnigmaMachine(r1, r2, r3, ref);
		em.setState(19, 17, 11);

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\Gex\\Documents\\School\\encrypted.text"));
			
			String line;
			char[] lineToDecode;
			String r = "";
			int linesToRead =4, linesRead = 0;
		    while ((line = br.readLine()) != null) {
		    	linesRead++;
		    	 lineToDecode = line.toCharArray();
		    	 for (char c: lineToDecode) {
		    		 if (Character.isLetter(c) && Character.isUpperCase(c)) {
		    			 r += em.encode(c);
		    		 }
		    		 else {
		    			 r += c;
		    		 }
		    	 }
		    	 r += "\n";
		    }
		    System.out.println(r);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	    
		finally {
			br.close();
		}
		
	}

}
