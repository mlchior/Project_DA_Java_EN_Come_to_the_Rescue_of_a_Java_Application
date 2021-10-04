package com.hemebiotech.analytics;
/**
 * @author melchior crinier
 *
 *
 */


import java.util.HashMap;
import  java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;


/**
 *
 */
public class AnalyticsCounter {
	private String filepath;
	Map<String, Integer> mySymptoms;

	public AnalyticsCounter() {
		mySymptoms = new HashMap<String, Integer>();
	}
	public void run() {

		ISymptomReader readSymptom= new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");

		List<String> result = readSymptom.GetSymptoms();

//HashMap
		mySymptoms = countSymptoms(result);
//Treemap
		mySymptoms = SortSymptoms(mySymptoms);

		ISymptomsWriter filepath = new WriteSymptomsFileFromData("result.out");
		filepath.writeSymptoms(mySymptoms);



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

	public TreeMap<String, Integer> SortSymptoms( Map<String, Integer> mapEntry ){

		return mapEntry.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,
				Map.Entry::getValue,
				(oldValue, newValue)
						-> newValue,TreeMap::new));

	}


}