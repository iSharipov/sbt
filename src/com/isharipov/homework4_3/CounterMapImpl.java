package com.isharipov.homework4_3;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user007 on 30.07.2016.
 */
public class CounterMapImpl<E> implements CounterMap<E> {

    private Map<E, Integer> map = new HashMap<>();
    private int counter = 1;

    @Override
    public void add(E o) {
        if (map.containsKey(o)) {
            map.put(o, map.get(o) + 1);
        } else {
            map.put(o, counter);
        }
    }

    @Override
    public void addAll(CounterMap<E> source) {
        for (Map.Entry<E, Integer> entry : source.getMap().entrySet()) {
            this.add(entry.getKey());
        }
    }

    @Override
    public int getCount(E o) {
        return map.get(o) == null ? 0 : map.get(o);
    }

    @Override
    public int remove(E o) {
        Integer c = map.remove(o);
        return c == null ? 0 : c;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Map<E, Integer> getMap() {
        return map;
    }

    @Override
    public Map<E, Integer> toMap() {
        return getMap();
    }

    @Override
    public Map<E, Integer> toMap(Map<E, Integer> destination) {
        destination.putAll(map);
        return destination;
    }
}
