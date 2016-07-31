package com.isharipov.homework3;

import java.util.*;

/**
 * Created by Илья on 29.07.2016.
 */
public class Solution {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        List<Map<Integer, Integer>> list = new ArrayList<>();
        Integer counter = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < counter; i++) {
            String[] s = scanner.nextLine().split(" ");
            Map<Integer, Integer> map = new HashMap<>();
            if (s.length < 2) {
                map.put(Integer.parseInt(s[0]), null);
            } else {
                map.put(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
            }
//            list.add(map);

//            for (Map<Integer, Integer> m : list) {
                for (Map.Entry entry : map.entrySet()) {
                    if (entry.getKey().equals(1)) {
                        l.add((Integer) entry.getValue());
                    }else if(entry.getKey().equals(2)){
                        Integer min = Collections.min(l);
                        l.remove(min);
                        System.out.println(min);
                    }
//                }
            }
        }

//        Iterator<Map<Integer, Integer>> iter = list.iterator();
//        while (iter.hasNext()) {
//            Map<Integer, Integer> next = iter.next();
//            for (Map.Entry entry : next.entrySet()) {
//                if (entry.getValue() == null) {
//
//                    iter.remove();
//                }
//            }
//        }
//        List<Integer> l = new ArrayList<>();
//        for (Map<Integer, Integer> m : list) {
//            for (Map.Entry entry : m.entrySet()) {
//                if (entry.getKey().equals(1)) {
//                    l.add((Integer) entry.getValue());
//                }else if(entry.getKey().equals(2)){
//                    Integer min = Collections.min(l);
//                    l.remove(min);
//                    System.out.println(min);
//                }
//            }
//        }

//        for (Integer m : l) {
//            System.out.println(m);
//        }
    }
}
