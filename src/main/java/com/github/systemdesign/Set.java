package com.github.systemdesign;

public interface Set<V> {
    void add(V value);
    boolean contains(V value);
    void remove(V value);
}
