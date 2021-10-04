package com.hemebiotech.analytics;
/**
 * @author melchior crinier
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

import java.util.Map;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	private static int anxietyCount = 0;

	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("Project02Eclipse/symptoms.txt"));
		String line = reader.readLine();

		Map<String, Integer> mySymptoms = new HashMap<String, Integer>();


		while (line != null ) {

			if (mySymptoms.containsKey(line)){
				int add=mySymptoms.get(line);
				add++;
				mySymptoms.put(line, add);
			} else  {
				mySymptoms.put(line,1);
			}
			line = reader.readLine();

		}
		for (String k : mySymptoms.keySet()){
			System.out.println(k);
			System.out.println(mySymptoms.get(k));
		}


		FileWriter writer = new FileWriter("Project02Eclipse/src/result.out");
				writer.close();
	}
}