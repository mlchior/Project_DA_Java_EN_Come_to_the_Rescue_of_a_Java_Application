package com.hemebiotech.analytics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteSymptoms {
    FileWriter writer = new FileWriter("result.out");
            for( String clé : mySymptoms.keySet()){
        if (clé != null){
            out.write(clé + ":" + mySymptoms.get(clé));
            out.newLine();
            out.flush();
    }
    public WriteSymptoms() throws IOException {
    }
}


