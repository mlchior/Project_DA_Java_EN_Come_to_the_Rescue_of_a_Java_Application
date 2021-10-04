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
import java.io.Writer;
import java.io.File;
import static java.lang.System.out;

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

			for (String clé : mySymptoms.keySet()) {
				if (clé != null){
					System.out.println(clé);
					System.out.println(mySymptoms.get(clé));
				}}

		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			File fichier = new File("result.out");


			FileWriter filewriter = new FileWriter(fichier, true);
			BufferedWriter out = new BufferedWriter(filewriter);

			for (String clé : mySymptoms.keySet())if (clé != null){ {
				out.write(clé + ":" + mySymptoms.get(clé));
				out.newLine();
				out.flush();
			}}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}