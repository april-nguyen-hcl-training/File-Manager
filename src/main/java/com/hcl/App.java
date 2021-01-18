package com.hcl;

import com.hcl.domain.FileDAO;
import com.hcl.filemanager.FileManager;
import com.hcl.filemanager.MainView;

public class App 
{
    public static void main( String[] args ) {
        new FileManager();
        MainView.welcome();
        MainView.options();
    }
}
