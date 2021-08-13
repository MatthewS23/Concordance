package com.mycompany.app;

import java.util.ArrayList;

public class Concordance {

    private int occurencesCount;
    private ArrayList<Integer> frequencies;

    public void setOccurencesCount(int occurencesCount) {
        this.occurencesCount = occurencesCount;
    }

    public void setFrequencies(ArrayList<Integer> frequencies) {
        this.frequencies = frequencies;
    }

    @Override
    public String toString() {
        return ("{ " + occurencesCount +
                ":" + frequencies + "}");
    }
}
