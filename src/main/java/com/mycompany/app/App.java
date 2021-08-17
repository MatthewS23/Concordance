package com.mycompany.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class App 
{
    public static void main( String[] args ) throws FileNotFoundException
    {
        int textSectionFrequency = 1;

        // Read text from file thorough scanner:
        Scanner sc = null;
        try {
            File fileReceived = new File(args[0]);
            sc = new Scanner(fileReceived);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Object to Structure the date into a map to sort concurrences
        StructureData sortingObject = new StructureData();
        //Final Solution Object
        Solution implementSolution = new Solution();
        //Loop that will iteratively read the file until it does not contain a subsequent line
        while (sc.hasNextLine()) {

            //Grab individual line of the file as String Data Type
            String dataonfile = sc.nextLine();

            //cumulativeWordsWithDuplicates:
            String[] sectionArrayOfWords2 = dataonfile.split("\\s+");
            ArrayList<String> wordsList2 = new ArrayList<String>(Arrays.asList(sectionArrayOfWords2));
            sortingObject.cumulativeWordsWithDuplicates(wordsList2);

            //cumulativeWordsWithoutDuplicates:
            String[] sectionArrayOfWords3 = dataonfile.split("\\s+");
            ArrayList<String> wordsList3 = new ArrayList<String>(Arrays.asList(sectionArrayOfWords3));
            sortingObject.cumulativeWordsWithoutDuplicates(wordsList3);

            if (dataonfile.isBlank()) {

                //Map TextBlock to Integer
                sortingObject.TextSectionsIntegerMapping(textSectionFrequency);
                textSectionFrequency++;
                //clear TextSection
                sortingObject.clearCumulativeTextSection();
            }
            if (!sc.hasNext()) {
                //append final line to cumulative lines
                String[] sectionArrayOfWords = dataonfile.split("\\s+");
                ArrayList<String> wordsList = new ArrayList<String>(Arrays.asList(sectionArrayOfWords));
                sortingObject.textSection(wordsList);
                sortingObject.TextSectionsIntegerMapping(textSectionFrequency);
            } else {
                String[] sectionArrayOfWords = dataonfile.split("\\s+");
                ArrayList<String> wordsList = new ArrayList<String>(Arrays.asList(sectionArrayOfWords));
                sortingObject.textSection(wordsList);
            }
        }

        implementSolution.solution(sortingObject.getCumulativeWordsWithoutDuplicates(), sortingObject.getTextSectionIntegerMapping());
        implementSolution.finalSolution(implementSolution.getSolution());
        myToString(implementSolution.getFinalSolution());

    }

    //Prints the final solution, a TreeMap of Concordance Objects
    public static void myToString(TreeMap<String, Concordance> finalSolution) {
        for (Map.Entry<String, Concordance> entry : finalSolution.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
