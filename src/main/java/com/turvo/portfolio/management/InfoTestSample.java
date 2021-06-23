package com.turvo.portfolio.management;

import java.util.Arrays;
import java.util.List;

public class InfoTestSample {
    public static void main(String[] args) {
        String[] a = {"abcdef", "adegh", "a"};
        System.out.println(solution(a));
    }
    public static String solution(String[] a) {
        // Type your solution here
        int size = a.length;
        if (size == 0)
            return "";

        if (size == 1)
            return a[0];

        Arrays.sort(a);

        int end = Math.min(a[0].length(), a[size-1].length());

        int i = 0;
        while (i < end && a[0].charAt(i) == a[size-1].charAt(i) )
            i++;

        String pre = a[0].substring(0, i);
        if(pre == null)
            return "";
        return pre;
    }

}
