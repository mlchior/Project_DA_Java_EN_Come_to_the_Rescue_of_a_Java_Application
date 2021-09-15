package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class WriteSymptoms {
  private String filepath;
    // s = result.out
        public WriteSymptoms(String filepath) {
            this.filepath = filepath ;

        }
        public void blueSymptoms(Map<String, Integer> mySymptoms) {
            try {

                File file = new File(filepath);

                FileWriter filewriter = new FileWriter(file, false);
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
   


