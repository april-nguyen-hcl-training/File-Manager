package com.hcl.filemanager;

import com.hcl.domain.FileDAO;
import com.hcl.util.Constants;

import java.io.*;
import java.util.Collections;
import java.util.List;

public class FileManager {

    private static FileDAO fileDAO;

    public FileManager() {
        fileDAO = new FileDAO();
    }

    public static List<File> getAll() {
        return fileDAO.getAll();
    }

    public static boolean add(File source) {
        if (find(source.getName(), false) != null) {
            System.out.println("File with the same name already exists!");
            return false;
        }
        File dest = new File(Constants.filePath + source.getName());

        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {

            byte[] buffer = new byte[1024];
            int length;

            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
        } catch (FileNotFoundException fnf) {
            System.out.println("Error: File not Found!");
            return false;
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        return fileDAO.add(dest);
    }

    public static boolean delete(String input) {
        File file = find(input, true);
        if (file != null) {
            return fileDAO.delete(file);
        } else {
            System.out.println("File Not Found or Wrong File Name!");
            return false;
        }
    }

    public static File find(String name, boolean caseSensitive) {
        if (caseSensitive) {
            File fileToFind = new File(Constants.filePath + name);
            int index = fileDAO.getAll().indexOf(fileToFind);
            if (index != -1) {
                return fileDAO.get(index);
            }
        } else {
            for (File file : fileDAO.getAll()) {
                if (file.getName().equalsIgnoreCase(name)) {
                    return file;
                }
            }
        }
        return null;
    }
}
