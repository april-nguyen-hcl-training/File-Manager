package com.hcl.domain;

import com.hcl.util.Constants;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FileDAO implements DAO<File> {

    private static List<File> files;

    public FileDAO(){
        files = new ArrayList<>();
        Path path = Paths.get(Constants.filePath);
        if (path.toFile().exists()) {
            File directory = path.toFile();
            for (File file : directory.listFiles()) {
                if (file.isFile()) {
                    files.add(file);
                }
            }
        } else {
            path.toFile().mkdirs();
            System.out.println("Initialized directory!");
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
    public boolean delete(File file) {
        file.delete();
        return files.remove(file);
    }
}
