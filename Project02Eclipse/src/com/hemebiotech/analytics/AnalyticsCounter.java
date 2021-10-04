package com.hemebiotech.analytics;
/**
 * @author melchior crinier
 */


import java.io.BufferedWriter;
import java.io.FileWriter;
import  java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.io.File;


public class AnalyticsCounter {
	private String filepath;
	Map<String, Integer> mySymptoms;

	public AnalyticsCounter() {
		mySymptoms = new HashMap<String, Integer>();
	}

	public Map<String, Integer> countSymptoms(List<String> result){
		Map <String, Integer> symptoms = new HashMap<String, Integer>();
		for (String Element: result) {
			if (symptoms.containsKey(Element)) {
				int add = symptoms.get(Element);
				add++;
				symptoms.put(Element, add);
			} else {
				symptoms.put(Element, 1);
			}
		}
		return symptoms;
	}

	public void run() {
		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");

		List<String> result = readSymptomDataFromFile.GetSymptoms();


		mySymptoms = countSymptoms(result);



		try {
			File fichier = new File("result.out");
			//writer = new BufferedWriter(new FileWriter(fishier));

			FileWriter filewriter = new FileWriter(fichier, false);
			BufferedWriter out = new BufferedWriter(filewriter);

			for (String clé : mySymptoms.keySet()){
				if (clé != null){
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