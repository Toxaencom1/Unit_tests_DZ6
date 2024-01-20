package com.taxah;

import com.taxah.dz6.ComparisonList;
import com.taxah.dz6.ListComparerService;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(runDemonstrateApp());
    }

    public static String runDemonstrateApp() {
        ComparisonList first = new ComparisonList(Arrays.asList(8, 9, 3, 4, 5));
        ComparisonList second = new ComparisonList(Arrays.asList(1, 2, 3, 4, 6));
        ListComparerService lcs = new ListComparerService(first, second);
        return lcs.compareAverageGrades();
    }
}