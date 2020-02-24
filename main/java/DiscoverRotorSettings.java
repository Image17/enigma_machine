import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import common.Utility;
import english.EnglishFrequency;
import rotors.EnigmaMachine;
import rotors.Reflector;
import rotors.Rotor;

public class DiscoverRotorSettings {

	public static void main(String[] args) throws IOException {
		int r1Pos = 0, r2Pos = 0, r3Pos = 0;
		Rotor r1, r2, r3;
		Reflector ref;
		EnglishFrequency ef = new EnglishFrequency();
		int runs = 17576;

		boolean matchFound = false;
		String result = "";
		String english = "";

		while (!matchFound && runs > 0) {
			--runs;
			r1 = new Rotor("QWERTYUIOPLKJHGFDSAZXCVBNM");
			r2 = new Rotor("ZAQWSXCDERFVBGTYHNMJUIKLOP");
			r3 = new Rotor("PLOKMIJNUHBYGVTFCRDXESZWAQ");
			ref = new Reflector("NPKMSLZTWQCFDAVBJYEHXOIURG");
			EnigmaMachine em = new EnigmaMachine(r1, r2, r3, ref);
			result = "";

			if (r1Pos == Utility.MAX_ARRAY_SIZE) {
				r1Pos = 0;
				r2Pos++;
				if (r2Pos == Utility.MAX_ARRAY_SIZE) {
					r2Pos = 0;
					r3Pos++;
				}
			}
			em.setState(r1Pos, r2Pos, r3Pos);

			BufferedReader br = null;
			String r = "";
			try {
				br = new BufferedReader(new FileReader("C:\\Users\\Gex\\Documents\\School\\encrypted.text"));
				String line;
				int linesToRead = 4, linesRead = 0;
				
				while ((line = br.readLine()) != null && linesToRead > linesRead) {
					linesRead++;					
					r += em.encodeLine(line) + "\n";					
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				br.close();
			}
			result = r;
			matchFound = ef.validEnglish(result, 3.0);
			if (matchFound) {
				matchFound = false;
				english += r1Pos + " " + r2Pos + " " + r3Pos + " " + result + "\n";
			}

			r1Pos++;
		}
		System.out.println(english);

	}
}