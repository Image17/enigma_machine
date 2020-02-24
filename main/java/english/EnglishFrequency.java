package english;

import common.Utility;

public class EnglishFrequency {

	private static final int ERRORS_ALLOWED = 12;
	private static double[] engLetterFreq = {8.1,1.6,3.2,3.6,12.3,2.3,1.6,5.1,7.2,0.1,0.5,4.0,7.2,2.2,7.9,2.3,0.2,6.,6.6,9.6,3.1,0.9,2.0,0.2,1.9,0.1};
	private static int[] engLetterDerivation = {10,50,30,30,10,30,50,20,15,100,80,30,20,30,20,30,100,30,20,15,30,60,40,100,40,100};

	/*
	 * Determine is passed in String matches English signature
	 * multiplier argument is used to adjust the deviation allowed
	 * from English signature
	 */
	public boolean validEnglish(String s, double multiplier) {
		int[] frequency = new int[Utility.MAX_ARRAY_SIZE];
		int errorCount = 0;
		s = s.replaceAll("\\s+", "").toUpperCase();
		double length = s.length();
		boolean validEnglish = true;
		
		for (char c : s.toCharArray()) {
			if (Character.isLetter(c)) {
				frequency[Utility.charToIndex(c)] += 1;
			}
			
		}

		for (int i = 0; i < Utility.MAX_ARRAY_SIZE; i++) {
			double freq = (frequency[i]/length)*100;
			double freqExp = engLetterFreq[i];
			double deviation = multiplier * (engLetterDerivation[i]/100.0);
			double lowerBound = freqExp - deviation;
			double upperBound = freqExp + deviation;
			
			if (!(freq < upperBound && freq > lowerBound)) {
				++errorCount;
			}
		}
		
		if (errorCount > ERRORS_ALLOWED) {
			validEnglish = false;
		}
		return validEnglish;
	}
}