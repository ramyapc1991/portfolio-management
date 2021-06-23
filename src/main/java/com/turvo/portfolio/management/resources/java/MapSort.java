package com.turvo.portfolio.management.resources.java;

import java.util.*;
import java.util.stream.Collectors;

public class MapSort {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1","Mysore");
        map.put("2","Hubli");
        map.put("3","Bangalore");

        Map<String, String> sortedByCount = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2) -> e1, LinkedHashMap::new));
        System.out.println(sortedByCount);
        //Map<String, String> sortedMap = sortByValue(map);

        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    private static Map<String, String> sortByValue(Map<String, String> map) {
        Map<String, String> sort = new LinkedHashMap<>();
        Collection<String> entry = map.values();
        List<String> arr = Arrays.asList(entry.toArray(new String[0]));
        Collections.sort(arr);
        for(String s:arr){
            for(String str: map.values()){
                if(s.equalsIgnoreCase(str)){
                    sort.put(getKey(map, s), s);
                }
            }
        }

        return sort;
    }

    private static String getKey(Map<String, String> map, String value) {
        String key ="";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                key = entry.getKey();
            }
        }
        return key;
    }
}
