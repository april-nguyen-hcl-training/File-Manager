package com.hcl.domain;

import com.hcl.util.Constants;

import java.io.File;
import java.util.*;

public class FileDAO implements DAO<File> {

    private static List<File> files;

    public FileDAO(){
        files = new ArrayList<>();
        for (File file : new File(Constants.directoryPath).listFiles()) {
            if (file.isFile()) {
                files.add(file);
            }
        }
    }

    @Override
    public List<File> getAll() {
        return files;
    }

    @Override
    public File get(int i) {
        return files.get(i);
    }

    @Override
    public boolean add(File file) {
        return files.add(file);
    }

    @Override
    public boolean delete(File file) { return files.remove(file); }
}
