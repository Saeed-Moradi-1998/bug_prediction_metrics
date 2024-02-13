package org.example;
import java.io.*;
import java.util.*;
import com.opencsv.CSVWriter;
import java.nio.file.Files;
import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.nio.file.Path;
import java.nio.file.Paths;
public class WriteToCSV {
    public static void writeToCSV(String projectName, String directoryPath) throws IOException {
        List<String> paths = JsonReader.jsonReader(projectName); //Writing all paths from src/checkstyle and src/hadoop.
        List<String> methods = JsonReader.findMethod(paths); //Extracting methods using the paths to the JSON files.
        List<String> McCabeValues = JavaParser.McCabeCalculator(methods); //Calculate McCabe using the methods extracted.
        List<String> SLOCValues = JavaParser.SLOCCalculator(methods); //Calculate the size of the methods using the methods extracted.
        List<String> readabilityValues = JavaParser.readabilityCalculator(methods); //Calculate the readability of the methods using the methods extracted.
        List<String> numberOfRevisionValues = JsonReader.numberOfRevision(paths); //Calculate the number of revisions using paths to the JSON files.

        String CSVFileName = projectName + ".csv";// Declaring the CSV file name based the project name.
        Path filePath = Paths.get(directoryPath, CSVFileName);
        try {
            // Check if the directory exists, create it if not
            if (!Files.exists(filePath.getParent())) {
                Files.createDirectories(filePath.getParent());
            }

            if (!Files.exists(filePath)) { // Checking if the file already exists. If not, create one.
                Files.createFile(filePath);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        List<String[]> dataList = new ArrayList<>();

        dataList.add(new String[]{"File Name,McCabe,SLOC,Readability,Number of Revisions"}); //Write the name of columns into a list.

        for (int i=0; i < paths.size(); i++){
            dataList.add(new String[]{paths.get(i), McCabeValues.get(i), SLOCValues.get(i), readabilityValues.get(i), numberOfRevisionValues.get(i)});
            //Reading corresponding values from each list to the aggregate list.
        }
        try(FileWriter fileWriter = new FileWriter((CSVFileName))) {
            for (String [] rowData : dataList){
                writeRow(fileWriter, rowData); //Writing into the CSV file row by row.
            }
        }

    }

    public static void writeRow(FileWriter writer, String [] rowData) throws IOException{ //This function adds each row to the corresponding CSV file.
        for (int i = 0; i < rowData.length; i++) {
            writer.append(rowData[i]);
            if (i != rowData.length - 1) {
                writer.append(","); //Separating values in each row.
            }
        }
        writer.append("\n");
    }
}
