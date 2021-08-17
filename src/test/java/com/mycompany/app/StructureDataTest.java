package com.mycompany.app;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class StructureDataTest {

    @Test
    public void testCumulativeTextSection(){
        ArrayList<String> listOne = new ArrayList<>(Arrays.asList("This", "is", "a", "test","a", "is", "test"));
        ArrayList<String> listTwo = new ArrayList<>(Arrays.asList("testing", "the", "cumulative", "words"));
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.addAll(listOne);
        expectedList.addAll(listTwo);
        StructureData testObject = new StructureData();
        testObject.textSection(listOne);
        testObject.textSection(listTwo);
        ArrayList<String> actualResult = testObject.getcumulativeTextSection();
        assertEquals(expectedList, actualResult);
    }

    @Test
    public void testCumulativeWordsWithoutDuplicates(){
        Set<String> expected = Stream.of("This", "is", "a", "test","a", "is", "test", "testing", "the", "cumulative", "words").collect(Collectors.toSet());
        ArrayList<String> listOne = new ArrayList<>(Arrays.asList("This", "is", "a", "test","a", "is", "test"));
        ArrayList<String> listTwo = new ArrayList<>(Arrays.asList("testing", "the", "cumulative", "words"));
        StructureData testObjectTwo = new StructureData();
        testObjectTwo.cumulativeWordsWithoutDuplicates(listOne);
        testObjectTwo.cumulativeWordsWithoutDuplicates(listTwo);
        assertEquals(expected, testObjectTwo.getCumulativeWordsWithoutDuplicates());
    }

    //tests 'setTextSectionsIntegerMapping()' and 'clearCumulativeTextSection()'
    @Test
    public void testTextSectionsIntegerMapping(){
        ArrayList<String> listOne = new ArrayList<>(Arrays.asList("This", "is", "a", "test","a", "is", "test"));
        StructureData testObjectThree = new StructureData();
        testObjectThree.textSection(listOne);
        testObjectThree.TextSectionsIntegerMapping(1);
        testObjectThree.clearCumulativeTextSection();
        ArrayList<String> listTwo = new ArrayList<>(Arrays.asList("testing", "the", "cumulative", "words"));
        testObjectThree.textSection(listTwo);
        testObjectThree.TextSectionsIntegerMapping(2);
        Map<Integer, ArrayList<String>> expected = Map.of(1, listOne, 2, listTwo);
        assertEquals(expected, testObjectThree.getTextSectionIntegerMapping());
    }

    @Test
    public void testCumulativeWordsWithDuplicates(){
        ArrayList<String> listOne = new ArrayList<>(Arrays.asList("This", "is", "a", "test","a", "is", "test"));
        ArrayList<String> listTwo = new ArrayList<>(Arrays.asList("testing", "the", "cumulative", "words"));
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("This", "is", "a", "test","a", "is", "test", "testing", "the", "cumulative", "words"));
        StructureData testObjectFour = new StructureData();
        testObjectFour.cumulativeWordsWithDuplicates(listOne);
        testObjectFour.cumulativeWordsWithDuplicates(listTwo);
        assertEquals(expected, testObjectFour.getcumulativeWordsWithDuplicates());
    }






}
