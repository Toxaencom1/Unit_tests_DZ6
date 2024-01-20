package com.taxah.dz6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class ComparisonList implements Iterable<Integer> {
    private List<Integer> list;

    public ComparisonList() {
        this.list = new ArrayList<>();
    }

    public ComparisonList(List<Integer> list) {
        this.list = list;
    }

    public void add(int el) {
        list.add(el);
    }

    public List<Integer> getList() {
        return list;
    }

    @Override
    public Iterator<Integer> iterator() {
        return list.iterator();
    }

    public Stream<Integer> stream() {
        return list.stream();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
