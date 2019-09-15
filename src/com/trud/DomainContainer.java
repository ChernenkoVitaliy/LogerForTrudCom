package com.trud;

import java.io.*;
import java.util.*;

/*Just class wich read from file all domens*/

public class DomainContainer {
    private List<String> domains = new ArrayList<>();
    private static final String pathToFile = "C:\\Users\\unknown\\Desktop\\loger\\domens.txt";


    public void readFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(pathToFile));
            String line;
            while ((line = reader.readLine()) != null) {
                domains.add(line);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getDomains() {
        return Collections.unmodifiableList(domains);
    }

    public static String getPathToFile() {
        return pathToFile;
    }
}
