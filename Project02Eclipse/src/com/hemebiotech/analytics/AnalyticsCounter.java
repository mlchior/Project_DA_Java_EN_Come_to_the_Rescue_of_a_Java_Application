package com.hemebiotech.analytics;
/**
 * @author melchior crinier
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;

public class AnalyticsCounter {
	Map<String, Integer> mySymptoms;
	public AnalyticsCounter() {
	mySymptoms = new HashMap<String, Integer>();
}

	public void run() {

		try {
			BufferedReader reader = new BufferedReader(new FileReader("Project02Eclipse/symptoms.txt"));
			String line = reader.readLine();


			while (line != null) {
				line = reader.readLine();

				if (mySymptoms.containsKey(line)) {
					int add = mySymptoms.get(line);
					add++;
					mySymptoms.put(line, add);
				} else {
					mySymptoms.put(line, 1);
				}
			}
			reader.close();


		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedWriter writer = null;

		try {
			writer = new BufferedWriter(new FileWriter("Project02Eclipse/src/result.out"));
			//ouvrir le writer.open
			//remettre en filewriter
			// treemap
			// une function pour lire une function pour trier une function pour ecrire les symptomes
			// get.symptoms de l'objet read date from file
			for (String k : mySymptoms.keySet()) {
				writer.write(k + ":" + mySymptoms.get(k) + "/n");
				writer.newLine();
				writer.flush();
				writer.close();
			}
			} catch (IOException e) {
			e.printStackTrace();
		}


			}

	}