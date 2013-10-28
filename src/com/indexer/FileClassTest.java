/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indexer;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author arash
 */
public class FileClassTest {

    private Path path;
    private String pathName;

    public FileClassTest(Path path) {

        this.path = path;
        this.pathName = path.toString();

    }

    public File[] returnFiles() {

        File file = new File(this.pathName);

        return file.listFiles();

    }

    public static void main(String[] args) {

        Path p = Paths.get("c:\\");
        FileClassTest fCT = new FileClassTest(p);

        File[] files = fCT.returnFiles();
        for (File file : files) {

            if (file.isDirectory()) {
                System.out.println("Directory: " + file.getName() + "\n");
            } else {
                System.out.println("File: " + file.getName() + "\n");
            }
        }

    }
}
