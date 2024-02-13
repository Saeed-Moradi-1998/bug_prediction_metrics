# Evaluating bug-prediction metrics and their correlation with one another.

## Introduction
This project used two publicly available projects, called "checkstyle" and "hadoop",
to evaluate the following bug-prediction metrics:\
McCabe (https://en.wikipedia.org/wiki/Cyclomatic_complexity) \
Source Lines Of Code (also known as SLOC) (https://en.wikipedia.org/wiki/Source_lines_of_code#:~:text=Source%20lines%20of%20code%20(SLOC,of%20the%20program's%20source%20code.) \
Readability (https://fellow.app/blog/engineering/the-complete-guide-to-readable-code/) \
Number of Revisions.

## Evaluation
There is a practical tool used to extract methods' history and lifecycle called CodeShovel (https://ieeexplore-ieee-org.uml.idm.oclc.org/document/9402063).
CodeShovel stores the entire information of all methods available on the repository of proejcts
as well as their actual source. this tool only works on Java-based projects.
Using CodeShovel, we extracted the source code of each methods. Afterwards, we evaluated the
aforementioned metrics. Finally, we calculated the correlation between each pair of metrics to
see how strongly they can predict each other.

##Project Structure
This project consists of two parts: The java section and the Python section. The java section
parses all the json files available in src directory (implemented on JsonReader.java). Then,
the methods are extracted and the number of revisions are calculated (implemented on 
JsonReader.java). Afterward, the methods are passed to functions that calcuate other three
metrics, all of which available on JavaParser.java. \
Finally, all the values are written into a CSV file with their corresponding file name. \
The python file (Correlation.py), evaluated the correlation coefficients and p_values of all
possible pairs within the metrics. The output is written on a JSON file called final_result.json.

## Requirements
There is a JAR file called read-tse=1.0.0.jar that should be imported as a dependency.
Aside from that, all the modules used on the project should be built through maven build 
system prior to execution.

## Setup

Simply run Main.java in your IDE.

## User inputs
The JSON files should be in /src with the name of each project. (src/checkstyle and src/hadoop)
The user is asked to enter the name of the project and the directory at which the csv file
will be stored. \
Note: If you attempt to write on a directory that is inside the project, you might face an
AccessDenied error. Make sure to either choose a directory outside the project or change
access mode of your directory by the following command: \
chmod +w /path/to/your/directory.