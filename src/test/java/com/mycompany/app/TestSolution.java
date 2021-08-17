package com.mycompany.app;

import org.junit.Test;

import java.util.*;


import static org.junit.Assert.assertEquals;

public class TestSolution {

    @Test
    public void testOccurenceCount(){
        ArrayList<String> listOne = new ArrayList<>(Arrays.asList("This", "is", "a", "test","a", "is", "test"));
        StructureData testObject = new StructureData();
        testObject.setTextSection(listOne);
        testObject.setTextSectionsIntegerMapping(1);
        testObject.clearCumulativeTextSection();
        ArrayList<String> listTwo = new ArrayList<>(Arrays.asList("testing", "the", "cumulative", "words"));
        testObject.setTextSection(listTwo);
        testObject.setTextSectionsIntegerMapping(2);
        int expected = Solution.occurenceCount("a", testObject.getTextSectionIntegerMapping());
        assertEquals(expected, 2);
    }

    @Test
    public void testFindFrequencies(){
        ArrayList<String> listOne = new ArrayList<>(Arrays.asList("This", "is", "a", "test","a", "is", "test"));
        StructureData testObject = new StructureData();
        testObject.setTextSection(listOne);
        testObject.setTextSectionsIntegerMapping(1);
        testObject.clearCumulativeTextSection();
        ArrayList<String> listTwo = new ArrayList<>(Arrays.asList("testing", "the", "a", "cumulative", "words"));
        testObject.setTextSection(listTwo);
        testObject.setTextSectionsIntegerMapping(2);
        ArrayList<Integer> actual = Solution.findFrequencies("a", testObject.getTextSectionIntegerMapping());
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1,1,2));
        assertEquals(expected, actual);
    }



}
