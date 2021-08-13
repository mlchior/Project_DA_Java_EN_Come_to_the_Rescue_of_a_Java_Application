package com.hemebiotech.analytics;
	/**
* @author melchior crinier
		*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;

public class AnalyticsCounterBrouillon{
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

		// si mon symptoms est deja present dans la liste
			//if mySymptoms.containsKey(line)




		// Read symptoms.txt
		// Get each line
		// if line = ("mySymptoms",nombre) alors ("mySymptoms", nombre ++ )
		// if line || ("mySymptoms" create ("newMySymptoms",1)
		// boucle until line !=null
		// utiliser treemap
		// Ordonner ma liste par ordre a alphabetique TreeMap
/*
		mySymptoms = new TreeMap<String, Integer>((Map)mySymptoms);


		mySymptoms.put("headache",0);
		mySymptoms.put("anxiety",0);
		mySymptoms.put("rash",0);
		System.out.println(mySymptoms.get("headache"));
		mySymptoms.put("anxiety", 2);

		int add = mySymptoms.get("anxiety");
		add++;
		mySymptoms.put("anxiety", add);
*/


/*
		while (line == null) {

			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headacheCount++;
				System.out.println("headache: " + headacheCount);
			}
			else if (line.equals("rash")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}
			else if (line.equals("anxiety")) {
				anxietyCount++;}



			line = reader.readLine();	// get another symptom

			}
	// tttry et catch comme sur readSymptomsDataFromfile  reader.close

*/
		// next generate output
		FileWriter writer = new FileWriter("Project02Eclipse/src/result.out");
		/*
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.write("anxiety: " + anxietyCount + "\n");*/
		writer.close();
	}
}
