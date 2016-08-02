package com.isharipov.homework4_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Илья on 31.07.2016.
 */
public class CollectionUtils {
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<? extends T> newArrayList() {
        return new ArrayList<>();
    }

    public static <T> int indexOf(List<? extends T> source, T o) {
        return source.indexOf(o);
    }

    public static <T> List limit(List<? extends T> source, int size) {
        return source.subList(0, size - 1);
    }

    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }


    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }


    public static <T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }


    public static boolean containsAny(List c1, List c2) {
        return !Collections.disjoint(c1, c2);
    }


    public static <T extends Comparable<? super T>> List range(List<T> list, T min, T max) {
        List<T> dest = new ArrayList<>(list);
        List<T> result = new ArrayList<>();
        for (T elem : dest) {
            if ((elem.compareTo(min) == 1 || elem.compareTo(min) == 0) && ((elem.compareTo(max) == -1 || elem.compareTo(max) == 0))) {
                result.add(elem);
            }
        }
        Collections.sort(result);
        return result;
    }

    public static <T> List range(List<T> list, T min, T max, Comparator<T> comparator) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            int minCmp = comparator.compare(t, min);
            int maxCmp = comparator.compare(t, max);

            if ((minCmp == 0 || minCmp == 1) && (maxCmp == -1) || maxCmp == 0) {
                result.add(t);
            }
        }
        return result;
    }
}

