package org.example;
import java.util.Scanner;
import java.io.IOException;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory name you want your CSV file to be stored: ");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the project name you want to evaluate: ");
        String projectName = scanner.nextLine();
        WriteToCSV.writeToCSV(projectName, directoryPath); //Calling the functions that calculate the metrics
        //for each project and write it into a CSV file.
        scanner.close();
        }
    }