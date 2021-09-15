package com.hemebiotech.analytics;
/**
 * @author melchior crinier
 */


import  java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


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

//mySymptoms liste des symptoms avec le count
		mySymptoms = countSymptoms(result);


/*appeler rla function qui rnevoi une treemap


*  */
		WriteSymptoms fichier = new WriteSymptoms("result.out");
		fichier.blueSymptoms(mySymptoms);



			}

	}