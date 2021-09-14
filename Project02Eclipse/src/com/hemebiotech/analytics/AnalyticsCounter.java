package com.hemebiotech.analytics;
/**
 * @author melchior crinier
 */

import javax.xml.bind.Element;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import  java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.io.Writer;
import java.io.File;
import static java.lang.System.out;

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

		/*for (String Element : result)
			System.out.println(Element);
		for (int count=0;count<result.size();count++)
		{

			System.out.println(result.get(count));

		}*/


/*
	try {


			BufferedReader reader = new BufferedReader("result");
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
// PARCOURirS LE SET
		//parcours la liste de sympthom et ajouter les symptoms dans ma has map.
			for (String clé : mySymptoms.keySet()) {
				if (clé != null){
				System.out.println(clé);
				System.out.println(mySymptoms.get(clé));
			}}

		} catch (IOException e) {
			e.printStackTrace();
		}*/

		try {
/*public void writer (){*/

			File fichier = new File("result.out");
			//writer = new BufferedWriter(new FileWriter(fishier));

			FileWriter filewriter = new FileWriter(fichier, false);
			BufferedWriter out = new BufferedWriter(filewriter);
			//ouvrir le writer.open
			//remettre en filewriter
			// treemap
			// une function pour lire une function pour trier une function pour ecrire les symptomes
			// get.symptoms de l'objet read date from file
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