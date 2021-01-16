package com.hcl.domain;

import java.util.List;

public interface DAO<T> {
    List<T> getAll();
    T get(int i);
    void add(T t);
    void delete(T t);
}
