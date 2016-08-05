package com.isharipov.homework4_3;

import java.util.Map;

/**
 * Created by user007 on 30.07.2016.
 */
public interface CounterMap<E> {

    void add(E e);

    int getCount(E e);

    int remove(E e);

    int size();

    void addAll(CounterMap<? extends E> source);

    Map<E, Integer> getMap();

    Map<E, Integer> toMap();

    Map<E, Integer> toMap(Map<E, Integer> destination);
}
