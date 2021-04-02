package com.company.normal;

class MyHashSet {
    /**
     * Initialize your data structure here.
     */
    boolean[] hash;

    public MyHashSet() {
        hash = new boolean[1000005];
    }

    public void add(int key) {
        hash[key] = true;
    }

    public void remove(int key) {
        hash[key] = false;
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        return hash[key];
    }
}
