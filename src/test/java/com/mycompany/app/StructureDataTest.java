package com.mycompany.app;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class StructureDataTest {

    @Test
    public void testSetCumulativeTextSection(){
        ArrayList<String> listOne = new ArrayList<>(Arrays.asList("This", "is", "a", "test","a", "is", "test"));
        ArrayList<String> listTwo = new ArrayList<>(Arrays.asList("testing", "the", "cumulative", "words"));
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.addAll(listOne);
        expectedList.addAll(listTwo);
        StructureData testObject = new StructureData();
        testObject.setTextSection(listOne);
        testObject.setTextSection(listTwo);
        ArrayList<String> actualResult = testObject.getcumulativeTextSection();
        assertEquals(expectedList, actualResult);
    }

    @Test
    public void testSetCumulativeWordsWithoutDuplicates(){
        Set<String> expected = Stream.of("This", "is", "a", "test","a", "is", "test", "testing", "the", "cumulative", "words").collect(Collectors.toSet());
        ArrayList<String> listOne = new ArrayList<>(Arrays.asList("This", "is", "a", "test","a", "is", "test"));
        ArrayList<String> listTwo = new ArrayList<>(Arrays.asList("testing", "the", "cumulative", "words"));
        StructureData testObjectTwo = new StructureData();
        testObjectTwo.setCumulativeWordsWithoutDuplicates(listOne);
        testObjectTwo.setCumulativeWordsWithoutDuplicates(listTwo);
        assertEquals(expected, testObjectTwo.getCumulativeWordsWithoutDuplicates());
    }

    //tests 'setTextSectionsIntegerMapping()' and 'clearCumulativeTextSection()'
    @Test
    public void testSetTextSectionsIntegerMapping(){
        ArrayList<String> listOne = new ArrayList<>(Arrays.asList("This", "is", "a", "test","a", "is", "test"));
        StructureData testObjectThree = new StructureData();
        testObjectThree.setTextSection(listOne);
        testObjectThree.setTextSectionsIntegerMapping(1);
        testObjectThree.clearCumulativeTextSection();
        ArrayList<String> listTwo = new ArrayList<>(Arrays.asList("testing", "the", "cumulative", "words"));
        testObjectThree.setTextSection(listTwo);
        testObjectThree.setTextSectionsIntegerMapping(2);
        Map<Integer, ArrayList<String>> expected = Map.of(1, listOne, 2, listTwo);
        assertEquals(expected, testObjectThree.getTextSectionIntegerMapping());
    }

    @Test
    public void testSetCumulativeWordsWithDuplicates(){
        ArrayList<String> listOne = new ArrayList<>(Arrays.asList("This", "is", "a", "test","a", "is", "test"));
        ArrayList<String> listTwo = new ArrayList<>(Arrays.asList("testing", "the", "cumulative", "words"));
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("This", "is", "a", "test","a", "is", "test", "testing", "the", "cumulative", "words"));
        StructureData testObjectFour = new StructureData();
        testObjectFour.setcumulativeWordsWithDuplicates(listOne);
        testObjectFour.setcumulativeWordsWithDuplicates(listTwo);
        assertEquals(expected, testObjectFour.getcumulativeWordsWithDuplicates());
    }






}
