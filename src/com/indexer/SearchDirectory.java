/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indexer;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

/**
 *
 * @author arash
 */
public class SearchDirectory implements FileVisitor {
    
    
    public void Search (Path file){
        
        Path path = file.getFileName();
        BasicFileAttributes attr = Files.readAttributes(path, null, los)
    }

    @Override
    public FileVisitResult preVisitDirectory(Object t, BasicFileAttributes bfa) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FileVisitResult visitFile(Object t, BasicFileAttributes bfa) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FileVisitResult visitFileFailed(Object t, IOException ioe) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FileVisitResult postVisitDirectory(Object t, IOException ioe) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
