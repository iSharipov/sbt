package com.isharipov.homework3;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int counter = Integer.parseInt(scanner.nextLine());
        NavigableMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < counter; i++) {
            int op = scanner.nextInt();
            int i1;
            if (op == 1) {
                i1 = scanner.nextInt();
                if (map.containsKey(i1)) {
                    map.put(i1, map.get(i1) + 1);
                } else {
                    map.put(i1, 1);
                }
            } else if (op == 2) {
//                Map.Entry<Integer, Integer> min = Collections.min(map.entrySet(), new Comparator<Map.Entry<Integer, Integer>>() {
//                    @Override
//                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                        return o1.getKey().compareTo(o2.getKey());
//                    }
//                });
                Map.Entry<Integer, Integer> min = map.firstEntry();
                Integer value = min.getValue();
                Integer key = min.getKey();
                if (value == 1) {
                    map.remove(min.getKey());
                } else {
                    map.replace(min.getKey(), --value);
                }
                System.out.println(key);
            }
        }
    }
}