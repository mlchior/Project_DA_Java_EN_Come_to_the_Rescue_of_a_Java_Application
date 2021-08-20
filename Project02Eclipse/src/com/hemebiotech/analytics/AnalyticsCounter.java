package com.hemebiotech.analytics;
/**
 * @author melchior crinier
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;

public class AnalyticsCounter {

	public static void main(String args[]) throws IOException {

		try {
			BufferedReader reader = new BufferedReader (new FileReader("Project02Eclipse/symptoms.txt"));
			String line = reader.readLine();

			Map<String, Integer> mySymptoms = new HashMap<String, Integer>();

			while (line != null) {
				line = reader.readLine();

				if (mySymptoms.containsKey(line)){
						int add=mySymptoms.get(line);
						add++;
						mySymptoms.put(line, add);
					} else  {
						mySymptoms.put(line,1);
					}

				}
				reader.close();

				for (String k : mySymptoms.keySet()){
					System.out.println(k);
					System.out.println(mySymptoms.get(k));
				}


		} catch (IOException e) {
			e.printStackTrace();
		}
	}




	/**	FileWriter writer = new FileWriter("Project02Eclipse/src/result.out");

		writer.close();*/
	}
