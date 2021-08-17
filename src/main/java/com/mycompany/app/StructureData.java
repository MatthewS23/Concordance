package com.mycompany.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

//Structures the data such that a map can be created with integer values-
//-that correspond with a text section defined by a collection of strings seperated-
//- by a blank line on a file, the beginning of a file, or the end
public class StructureData {
    private ArrayList<String> textSection;
    private HashMap<Integer, ArrayList<String>> textSectionIntegerMapping;
    private Set<String> cumulativeWordsWithoutDuplicates;
    private ArrayList<String> cumulativeWordsWithDuplicates;

    public Set<String> getCumulativeWordsWithoutDuplicates(){
        return cumulativeWordsWithoutDuplicates;
    }

    //Receives an ArrayList of Strings that is read from a single line through main from a text file passed in
    //Cumulatively adds to a private instance ArrayList 'textSection,' for mapping an integer to a section of text
    public void setTextSection(ArrayList<String> currentLine) {

        if(getcumulativeTextSection() == null) {
            textSection = currentLine;
        }
        else {
            for(int i = 0; i < currentLine.size(); i ++) {
                textSection.add(currentLine.get(i));
            }
        }
    }

    //Receives an ArrayList of Strings that is read from a single line through main from a text file passed in
    //Cumulatively adds to a private instance Set 'cumulativeTextSectionWithoutDuplicates,' to find all words on the text file(duplicates excluded)
    public void setCumulativeWordsWithoutDuplicates(ArrayList<String> currentLine) {
        if(cumulativeWordsWithoutDuplicates == null){
            Set<String> conversion = currentLine.stream().collect(Collectors.toSet());
            this.cumulativeWordsWithoutDuplicates = conversion;
        }
        else{
            for(int i = 0; i < currentLine.size(); i++) {
                this.cumulativeWordsWithoutDuplicates.add(currentLine.get(i));
            }
        }

    }

    //receives an integer and sets the  that is mapped to a collection of text that is defined by a collection of strings seperated-
    //- by a blank line on a file, the beginning of file or the end
    //sets 'textSectionIntegerMapping' HashMap
    public void setTextSectionsIntegerMapping(int concordanceFrequency) {
        if(textSectionIntegerMapping == null){
            textSectionIntegerMapping = new HashMap<>();
        }
        this.textSectionIntegerMapping.put(concordanceFrequency, textSection);
    }

    //clears the textSection variable when a white space is found to distinguish
    //the textSection collections within the 'textSectionIntegerMapping' variable
    public void clearCumulativeTextSection() {
        ArrayList<String> emptyCollection = new ArrayList<String>();
        textSection = emptyCollection;
    }

    //stores a cumulative list of words containing duplicates
    public void setcumulativeWordsWithDuplicates(ArrayList<String> currentLine) {
        if(cumulativeWordsWithDuplicates == null) {
            this.cumulativeWordsWithDuplicates = currentLine;
        }
        else {
            for(int i = 0; i < currentLine.size(); i++) {
                this.cumulativeWordsWithDuplicates.add(currentLine.get(i));
            }
        }
    }

    public ArrayList<String>getcumulativeTextSection() {
        return textSection;
    }
    public HashMap<Integer, ArrayList<String>> getTextSectionIntegerMapping() {
        return textSectionIntegerMapping;
    }
    public ArrayList<String> getcumulativeWordsWithDuplicates(){
        return cumulativeWordsWithDuplicates;
    }
}
