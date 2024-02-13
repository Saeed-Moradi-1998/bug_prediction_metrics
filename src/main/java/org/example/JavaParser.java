package org.example;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.*;
import raykernel.apps.readability.code.Function;
import raykernel.apps.readability.eval.PortableEvaluator;

import java.util.ArrayList;
import java.util.List;

public class JavaParser {
    public static List <String> McCabeCalculator(List <String> methods) {
        MethodDeclaration mt;
        String McCabeValue;
        int average = 0;
        int sum = 0;
        List <String> McCabeValues = new ArrayList<>();
        for (String method : methods) {
            try {
                mt = StaticJavaParser.parseMethodDeclaration(method); //Parse each method to use feature of SaticJavaParser for finding statements.
                McCabeValue = String.valueOf(mt.findAll(IfStmt.class).size() //Adding the number of occorunce of each of these statements to
                        // each other to calculate McCabe.
                        + mt.findAll(WhileStmt.class).size()
                        + mt.findAll(SwitchStmt.class).size()
                        + mt.findAll(ForEachStmt.class).size()
                        + mt.findAll(DoStmt.class).size()
                        + mt.findAll(CatchClause.class).size());
                McCabeValues.add(McCabeValue); //Adding the value to a list that contains McCabe of all the functions.

            } catch (Exception e) {
            }
        }
        for (String value : McCabeValues){
            sum += Integer.parseInt(value); //Flling missing values with the average of all values.(They are negligible).
        }
        average = sum/McCabeValues.size();
        while (McCabeValues.size() < methods.size()){
            McCabeValues.add(String.valueOf(average));
        }
        return McCabeValues;
    }

    public static List<String> SLOCCalculator(List <String> methods){
        List<String> SLOCValues = new ArrayList<>();
        String [] linesOfMethods;
        Integer lineCounter;
        int sum = 0;
        int average = 0;
        String shortComment = "//";
        String longCommentStart = "/*";
        String longCommentEnd = "*/";
        Integer commentCounter;
        boolean flag = false;
        Integer i = 1;
        for (String method : methods) {
            try {
                commentCounter = 0;
                linesOfMethods = method.split("\\n"); //Spliting the methods with new lines to calculate the size of the whole method.
                lineCounter = linesOfMethods.length;

                String[] listOfLines = linesOfMethods;
                for (String line : listOfLines){
                    line = line.replaceAll("\\s", ""); // Removing whitespaces to be able to detect comment lines.
                    if (line.startsWith(shortComment)){// When whitespaces are removed, if a line starts with the commenting
                        // characters, then the line is a comment.
                        commentCounter++;
                    }
                    else if (line.startsWith(longCommentStart)){ // When having a multiline comment, all the following lines are
                        // comments as long as the ending character for comments is not observed.
                        commentCounter++;
                        flag = true;
                    }
                    else if(line.startsWith((longCommentEnd)) && flag){ // This counts lines as comments as long as they are within a comment block.
                        commentCounter++;
                        flag = false;
                    }
                    else{
                        if (flag){
                            commentCounter++;
                        }
                    }
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            lineCounter = lineCounter - commentCounter;// Subtracting the number of comments from the whole size of the method.
            SLOCValues.add(String.valueOf(lineCounter));
        }
        for (String value : SLOCValues){
            sum += Integer.parseInt(value); //Filling the missing values with the average of all values.
        }
        average = sum/SLOCValues.size();
        while (SLOCValues.size() < methods.size()){
            SLOCValues.add(String.valueOf(average));
        }
        return SLOCValues;
    }


    public static List<String> readabilityCalculator (List <String> methods) {
        List <String> readabilityValues = new ArrayList<>();
        double sum = 0;
        double average = 0;
        for (String method : methods){
            Function function = new Function(method);
            PortableEvaluator portableEvaluator = new PortableEvaluator();
            readabilityValues.add(String.valueOf(portableEvaluator.getReadability(function))); // Calling the function in the JAR file to calculate the readability.
        }
        for (String value : readabilityValues){
            sum += Double.parseDouble(value);
        }
        average = sum/readabilityValues.size();
        while (readabilityValues.size() < methods.size()){
            readabilityValues.add(String.valueOf(average)); //Filling the missing values with the average of all values (the impact is negligible.
        }
    return readabilityValues;
    }
}
