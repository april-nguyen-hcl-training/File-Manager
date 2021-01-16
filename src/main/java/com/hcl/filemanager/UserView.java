package com.hcl.filemanager;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String source = scan.nextLine();
        if (validPath(source)) {
            FileController.add(source);
        } else {
            System.out.println("File path not valid, please try again!");
        }
    }

    private static void delete() {

    }

    private static void search() {

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
