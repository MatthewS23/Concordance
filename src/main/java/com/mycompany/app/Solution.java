package com.mycompany.app;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    private HashMap<String, Concordance > finalSolution;
    private TreeMap<String, Concordance> finalSolutionSorted;

    public void setFinalSolution(Set<String> cumulativeWordsWithoutDuplicates, HashMap<Integer, ArrayList<String>> textSectionIntegerMapping){
        finalSolution = new HashMap<String, Concordance>();
        List<String> conversion = cumulativeWordsWithoutDuplicates.stream().collect(Collectors.toList());
        for(int i = 0; i < cumulativeWordsWithoutDuplicates.size(); i++){
            int count = occurenceCount(conversion.get(i), textSectionIntegerMapping);
            ArrayList<Integer> frequencies = findFrequencies(conversion.get(i), textSectionIntegerMapping);
            Concordance instance = new Concordance();
            instance.setOccurencesCount(count);
            instance.setFrequencies(frequencies);
            finalSolution.put(conversion.get(i).toLowerCase(), instance);
        }
    }

    public void sortFinalSolution(HashMap<String, Concordance > finalSolution){
        finalSolutionSorted = new TreeMap<>();
        finalSolutionSorted.putAll(getFinalSolution());
    }

    public static int occurenceCount(String word, HashMap<Integer, ArrayList<String>> textSectionIntegerMapping){
        int count = 0;

        for(Map.Entry<Integer, ArrayList<String>> entry : textSectionIntegerMapping.entrySet()){
            for(int y = 0; y <entry.getValue().size(); y++){
                if(entry.getValue().get(y).equals(word)) {
                    count += 1;
                }
            }
        }
        return count;
    }

    public static ArrayList<Integer> findFrequencies(String word, HashMap<Integer, ArrayList<String>> textSectionIntegerMapping){
        ArrayList<Integer> frequencies = new ArrayList<>();
        for(Map.Entry<Integer, ArrayList<String>> entry : textSectionIntegerMapping.entrySet()){
            for(int y = 0; y <entry.getValue().size(); y++){
                if(entry.getValue().get(y).equals(word)){
                    frequencies.add(entry.getKey());
                }
            }
        }
        return frequencies;
    }

    public HashMap<String, Concordance> getFinalSolution() {
        return finalSolution;
    }
    public  TreeMap<String, Concordance> getFinalSolutionSorted() {
        return finalSolutionSorted;
    }
}
