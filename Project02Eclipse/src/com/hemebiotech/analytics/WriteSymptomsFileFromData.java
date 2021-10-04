package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;


public class WriteSymptomsFileFromData implements ISymptomsWriter {
    private String filepath;

    public WriteSymptomsFileFromData(String filepath) {this.filepath = filepath; }

    @Override
    public void writeSymptoms(Map<String, Integer> mySymptoms) {
        try {

            File file = new File(filepath);

            FileWriter filewriter = new FileWriter(file, false);
            BufferedWriter out = new BufferedWriter(filewriter);


            for (String key : mySymptoms.keySet()){
                if (key != null){
                    out.write(key + ":" + mySymptoms.get(key));
                    out.newLine();
                    out.flush();
                }}
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
