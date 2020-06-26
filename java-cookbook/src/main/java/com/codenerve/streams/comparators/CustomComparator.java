package com.codenerve.streams.comparators;

import java.util.Comparator;

public class CustomComparator implements Comparator<String> {

    /*
        Sorts by the number of occurrences of the character 'e' in any given string
     */
    @Override
    public int compare(String string, String string2) {
        long stringCount = string.chars().filter(ch -> ch == 'e').count();
        long secondStringCount = string2.chars().filter(ch -> ch == 'e').count();
        return Long.compare(secondStringCount, stringCount);
    }
}