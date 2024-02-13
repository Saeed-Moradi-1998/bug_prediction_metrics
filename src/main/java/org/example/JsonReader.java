
package org.example;

import java.io.*;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;


public class JsonReader {
    public static List<String> jsonReader(String projectName) throws IOException {
        String directoryPath;
        if (projectName.equals("hadoop")) { // Declare the path into which the function should look to find the JSON files.
            directoryPath = "src/hadoop";
        } else {
            directoryPath = "src/checkstyle";
        }
        List<String> paths = new ArrayList<>();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    paths.add(directory + "/" + file.getName()); // Finding the path for all the files in src/checkstyle and src/hadoop
                }
            }
        }
        return paths;

    }

    public static List<String> findMethod(List<String> paths) throws IOException {
        List<String> methods = new ArrayList<>();
        String trimmedValue = "";
        Boolean flag = false;
        for (String path : paths) {
            JsonObject myobject = new Gson().fromJson(new FileReader(path), JsonObject.class); // Open the JSON files and cast it to a JsonObject.
            JsonObject changeHistoryDetails = (JsonObject) myobject.get("changeHistoryDetails"); // Extract all the subsection of changeHistoryDetails.
            Boolean sourceMethod = false;
            for (String keys : changeHistoryDetails.keySet()) { // Iterate through the keys to find "type".
                JsonObject details = (JsonObject) changeHistoryDetails.get(keys);
                for (var entry : details.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue().toString();
                    if (key.equals("type") && value.equals("\"Yintroduced\"")) { // Checking if the key is "type" and the value is referring to the
                        // first time a function is used.
                        sourceMethod = true;
                    }
                    if (key.equals("actualSource") && sourceMethod.equals(true)) {

                        trimmedValue = value.substring(1, value.length() - 1).replace("\\n", "\n").replace("\\\"", "\"");
                        // Trimming the value by getting rid of newlines and extra backslashes.
                        methods.add(trimmedValue); // Adding the values to a list.
                    }
                }
            }
        }
        while (methods.size() < paths.size()){ // There was one file without any method.
            methods.add("Extra_Variable");
        }

        return methods;
    }

    public static List<String> numberOfRevision(List<String> paths) throws IOException {
        List<String> listOfNumberOfRevisions = new ArrayList<>();
        int number_of_revisions = 0;
        Boolean flag = false;
        for (String path : paths) {
            JsonObject myobject = new Gson().fromJson(new FileReader(path), JsonObject.class);
            JsonObject changeHistoryShort = (JsonObject) myobject.get("changeHistoryShort"); // Extract all the subsection of changeHistoryShort.
            for (var entry : changeHistoryShort.entrySet()) {
                String value = entry.getValue().toString();
                if (value.equals("\"Yfilerename\"") || value.equals("\"Ymovefromfile\"")) {
                    // If either of these happened, there might have been a revision.
                    flag = true; // Set a flag to confirm one of these values are present in our JSON file.
                }
                if (flag && value.equals("\"Ybodychange\"")){ // If flag is true and Ybodychange is observed, that's definitely a revision.
                    number_of_revisions++;
                    flag = false;
                }
            }
            listOfNumberOfRevisions.add(String.valueOf(number_of_revisions));
            number_of_revisions = 0; //Setting the value to 0 to recalculate from the top of the loop.
        }
        return listOfNumberOfRevisions;
    }
}

