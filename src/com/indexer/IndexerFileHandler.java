/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indexer;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author arash
 */
public class IndexerFileHandler {
    
    
    Map<String, String> files = new HashMap<>();
    
    
    
    
    public void IndexerFileHandler(){
        
    }
    public void listFilesForFolder(final File folder) {
    for (final File fileEntry : folder.listFiles()) {
        if (fileEntry.isDirectory()) {
            listFilesForFolder(fileEntry);
        } else {
            System.out.println(fileEntry.getName());
        }
    }
}
}
