package com.hcl.filemanager;

import com.hcl.domain.FileDAO;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileController {

    private static FileDAO fileDAO = new FileDAO();

    public static List<File> getAll() {
        return fileDAO.getAll();
    }

    public static void add(String source) {
        File sourceFile = new File(source);
    }

    public static void delete() {

    }

    public static void get() {

    }

}
