package com.hcl.filemanager;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.hcl.filemanager.FileManager.find;

public class UserView {

    private static Scanner scan = new Scanner(System.in);

    public static void options() {
        Print.header("USER OPTIONS");
        System.out.println(
            "1) Add a file\n" +
            "2) Delete a file\n" +
            "2) Search for a file\n" +
            "4) Back to main options\n"
        );
        select();
    }

    private static void select() {
        System.out.println("Enter 1, 2, 3, or 4: ");
        String input = scan.nextLine();
        switch (input) {
            case "1":
                add();
                break;
            case "2":
                delete();
                break;
            case "3":
                search();
                break;
            case "4":
                MainView.options();
                break;
            default:
                System.out.println("Invalid Input, Please Try Again!");
        }
        select();
    }

    private static void add() {
        Print.header("ADD FILE");
        System.out.println("Enter file path: ");
        String inputPath = scan.nextLine();
        if (validPath(inputPath)) {
            Path sourcePath = Paths.get(inputPath);
            if (sourcePath.toFile().exists())
            {
                File source = sourcePath.toFile();
                if (FileManager.add(source) != false) {
                    System.out.println(source.getName() + " was added!");
                    options();
                } else {
                    System.out.println("Error in adding: " + source.getName() + ". Please try again!");
                }
            }
            else {
                System.out.println("Error: File does not exist, please try again!");
            }
        } else {
            System.out.println("File path not valid, please try again!");
        }
        add();
    }

    private static void delete() {
        Print.header("DELETE FILE");

        List<File> files = new ArrayList<>(FileManager.getAll());
        if (files.isEmpty()) {
            System.out.println("No files in directory to delete!");
            options();
        }

        System.out.println("Enter file name to delete (case sensitive): ");
        String input = scan.nextLine();
        if (FileManager.delete(input) != false) {
            System.out.println(input + " was deleted!");
            options();
        } else {
            System.out.println("Error in deleting: " + input + ". Please try again!");
            delete();
        }
    }

    private static void search() {
        Print.header("SEARCH FOR FILE");
        System.out.println("Enter file name to search for (case sensitive): ");
        String input = scan.nextLine();
        File file = FileManager.find(input, true);
        if (file != null) {
            System.out.println(file.getName() + " was found!");
        } else {
            System.out.println(file.getName() + " was NOT found!");
        }
        options();
    }

    private static boolean validPath(String path) {
        Pattern pathPattern = Pattern.compile("^(([a-zA-Z]:)|((\\\\|/){1,2}\\w+)\\$?)((\\\\|/)(\\w[\\w ]*.*))+\\.([a-zA-Z0-9]+)$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pathPattern.matcher(path);
        boolean matchFound = matcher.find();
        if (matchFound) {
            return true;
        } else {
            return false;
        }
    }
}
