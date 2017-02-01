package com.kpn.set;

public interface Set<D> {
    Set<D> add(D object);

    Set<D> remove(D object);

    int size();

    boolean equals(Set<D> otherSet);

    boolean contains(D object);
    
    SetIterator<D> iterator();

    Set<D> union(Set<D> otherSet);

    Set<D> intersection(Set<D> otherSet);
}
