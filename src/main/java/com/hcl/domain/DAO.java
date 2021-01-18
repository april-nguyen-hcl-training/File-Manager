package com.hcl.domain;

import java.util.List;

public interface DAO<T> {
    List<T> getAll();
    T get(int i);
    boolean add(T t);
    boolean delete(T t);
}
