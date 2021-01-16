package com.hcl.domain;

import java.io.File;
import java.util.*;

public class FileDAO implements DAO<File> {

    private static List<File> files = new ArrayList<>();

    @Override
    public List<File> getAll() {
        return files;
    }

    @Override
    public File get(int i) {
        return files.get(i);
    }

    @Override
    public void add(File file) {
        files.add(file);
    }

    @Override
    public void delete(File file) {
        files.remove(file);
    }
}
