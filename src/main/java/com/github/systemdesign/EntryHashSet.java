package com.github.systemdesign;

import java.util.Objects;

public class EntryHashSet<V> implements Set<V>{

    class Entry<V> {
        final V value;
        Entry<V> next;

        public Entry(V value) {
            this.value = value;
            this.next = null;
        }
    }
    private final int MAX_LEN = 100000;
    private Entry<V>[] set;

    public EntryHashSet() {
        set = new Entry[MAX_LEN];
    }

    @Override
    public void add(V value) {
        int hash = value.hashCode();
        int index = hash % MAX_LEN;
        Entry<V> bucket = set[index];
        if(Objects.isNull(bucket)) {
            set[index] = new Entry<>(value);
        } else {
            boolean valuePresent = false;
            while(bucket.next != null) {
                if(bucket.value.equals(value)) {
                    valuePresent = true;
                    break;
                }
                bucket = bucket.next;
            }
            if(!valuePresent)
                bucket.next = new Entry<>(value);
        }
    }

    @Override
    public boolean contains(V value) {
        int hash = value.hashCode();
        int index = hash % MAX_LEN;
        Entry<V> bucket = set[index];
        while(Objects.nonNull(bucket)) {
            if(bucket.value.equals(value))
                return true;
            bucket = bucket.next;
        }
        return false;
    }

    @Override
    public void remove(V value) {
        int hash = value.hashCode();
        int index = hash % MAX_LEN;
        Entry<V> bucket = set[index];
        Entry<V> prev = null;
        while(Objects.nonNull(bucket)) {
            if(bucket.value.equals(value)) {
                // Remove element
                if(prev == null)
                    set[index] = bucket.next;
                else
                    prev.next = bucket.next;
            }
            prev = bucket;
            bucket = bucket.next;
        }
    }
}
