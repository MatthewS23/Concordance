package com.mycompany.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

public class StructureData {
    private ArrayList<String> cumulativeTextSection;
    private HashMap<Integer, ArrayList<String>> textSectionIntegerMapping;
    private Set<String> cumulativeWordsWithoutDuplicates;
    private ArrayList<String> cumulativeWordsWithDuplicates;

    public Set<String> getCumulativeWordsWithoutDuplicates(){
        return cumulativeWordsWithoutDuplicates;
    }

    public void setCumulativeTextSection(ArrayList<String> currentLine) {

        if(getcumulativeTextSection() == null) {
            cumulativeTextSection = currentLine;
        }
        else {
            for(int i = 0; i < currentLine.size(); i ++) {
                cumulativeTextSection.add(currentLine.get(i));
            }
        }
    }

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

    public void setTextSectionsIntegerMapping(int concordanceFrequency) {
        if(textSectionIntegerMapping == null){
            textSectionIntegerMapping = new HashMap<>();
        }
        this.textSectionIntegerMapping.put(concordanceFrequency, cumulativeTextSection);
    }

    public void clearCumulativeTextSection() {
        ArrayList<String> emptyCollection = new ArrayList<String>();
        cumulativeTextSection = emptyCollection;
    }

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
        return cumulativeTextSection;
    }
    public HashMap<Integer, ArrayList<String>> getTextSectionIntegerMapping() {
        return textSectionIntegerMapping;
    }
    public ArrayList<String> getcumulativeWordsWithDuplicates(){
        return cumulativeWordsWithDuplicates;
    }
}
