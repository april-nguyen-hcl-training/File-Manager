package com.hcl.filemanager;

import java.io.File;
import java.util.*;

public class MainView {

    public static void welcome() {
        Print.header("WELCOME");
        System.out.println(
            "Application: File Manager\n" +
            "Developer: April Nguyen\n"
        );
    }

    public static void options() {
        Print.header("MAIN OPTIONS");
        System.out.println(
            "1) Show files in ascending order\n" +
            "2) Add, Delete, or Search for file\n" +
            "3) Close application\n"
        );
        select();
    }

    private static void select() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter 1, 2, or 3: ");
        String input = scan.nextLine();
        switch (input) {
            case "1":
                show();
                break;
            case "2":
                UserView.options();
                break;
            case "3":
                close();
                break;
            default:
                System.out.println("Invalid Input, Please Try Again!");
        }
        select();
    }

    private static void show() {
        Print.header("FILES");
        List<File> files = new ArrayList<>(FileController.getAll());
        Collections.sort(files);
        for (File file : files) {
            System.out.println(file.getName());
        }
        options();
    }

    private static void close() {
        Print.header("GOODBYE!");
        System.exit(0);
    }
}