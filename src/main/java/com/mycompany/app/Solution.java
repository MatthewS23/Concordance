package com.mycompany.app;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    private HashMap<String, Concordance > solution;
    private TreeMap<String, Concordance> finalSolution;

    //Constructs the final solution into a Hashmap of:
    // key: individual words received through 'cumulativeWordsWithoutDuplicates'
    // value: Concordance object with word totals and frequencies
    public void solution(Set<String> cumulativeWordsWithoutDuplicates, HashMap<Integer, ArrayList<String>> textSectionIntegerMapping){
        solution = new HashMap<String, Concordance>();
        List<String> conversion = cumulativeWordsWithoutDuplicates.stream().collect(Collectors.toList());
        for(int i = 0; i < cumulativeWordsWithoutDuplicates.size(); i++){
            int count = occurenceCount(conversion.get(i), textSectionIntegerMapping);
            ArrayList<Integer> frequencies = findFrequencies(conversion.get(i), textSectionIntegerMapping);
            Concordance instance = new Concordance();
            instance.setOccurencesCount(count);
            instance.setFrequencies(frequencies);
            solution.put(conversion.get(i).toLowerCase(), instance);
        }
    }

    //Puts solution into alphabetical order
    public void finalSolution(HashMap<String, Concordance > finalSolution){
        this.finalSolution = new TreeMap<>();
        this.finalSolution.putAll(getSolution());
    }

    //Receives the Map of integers mapped to text sections and a single word
    //Returns the total amount of times the word occurs
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
    //Receives the Map of integers mapped to text sections and a single word
    //Returns an ArrayList of frequencies the word occur in textSections
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

    public HashMap<String, Concordance> getSolution() {
        return solution;
    }
    public  TreeMap<String, Concordance> getFinalSolution() {
        return finalSolution;
    }
}
