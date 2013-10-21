/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaexperiment;

import java.awt.List;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.tree.DefaultMutableTreeNode;


/**
 *
 * @author arash
 */
public class FileWalkerTest implements FileVisitor<Path> {

    //  HashMap<Object, Object> fileAttributes;
    
    //private String sPath;
    private Path root;

    
    public ArrayList<Path> getChild() {
        
        return child;
    }
    private ArrayList<Path> child;

    public Path fGetRoot() {
        return root;
    }

 
    public Path path;

    public Path getPath() {
        return path;
    }

    private DefaultMutableTreeNode top;
    public HashMap<Path, Path> data;
    private BasicFileAttributes attr;

//    FileWalkerTest(Path path) {
//
//    HashMap<Path, Path> data;
//    private BasicFileAttributes attr;    }

   public FileWalkerTest(String path) {
        data = new HashMap<>();
        this.path = Paths.get(path);
        
    }

    
    

    public BasicFileAttributes Search(Path file) {

        // fileAttributes = new HashMap();
        //   Path name = file.getFileName();

//        try {
//           this.attr = Files.readAttributes(file, BasicFileAttributes.class);
//           // fileAttributes = (HashMap<String, Object>) Files.readAttributes(file, "*");
//        } catch (IOException e) {
//            System.err.println(e.getMessage() + e.getLocalizedMessage() + e.getClass());
//        }


        // BasicFileAttributeView bfView = name.getFileAttributeView(BasicFileAttributeView.class);
        // fileAttributes = (HashMap<String, Object>) Files.readAttributes(name,"*");

        return attr;

    }

    @Override
    public FileVisitResult preVisitDirectory(Path t, BasicFileAttributes bfa) throws IOException {
        System.out.format("\n-Directory %s%n", t);
         root = t.getRoot();
         
        System.out.format("%s%n",t.getParent());
        if(t.getParent()!= null && t.getParent() != root) {
         //  this.child[] = t.getParent();
            top = new DefaultMutableTreeNode(root.toString());
            
            child.add(t);
        }
        
        top.add(top);
        data.put(t.getFileName(), t);
        return FileVisitResult.CONTINUE;
    }
    
    public DefaultMutableTreeNode getTop(){
        
        return top;
    }

    @Override
    public FileVisitResult visitFile(Path t, BasicFileAttributes bfa) throws IOException {
//        if (bfa.isDirectory()) {
//            System.out.format("\n-Directory %s%n", t);
//        } else if (bfa.isRegularFile()) {
//            System.out.format("\n--File: %s", t);
//
//        }
       
        
        System.out.format("\n--File: %s", t);
        data.put(t.getFileName(), t);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path t, IOException ioe) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path t, IOException ioe) throws IOException {
        return FileVisitResult.CONTINUE;

    }
}
class Main {

    private static BasicFileAttributes sResult;

    public static void main(String[] args) throws IOException {
        
        
        String path = "C:\\test";
//
        FileWalkerTest fWalker = new FileWalkerTest(path);
        Files.walkFileTree(fWalker.path, fWalker);
       // HashMap<Path data = fWalker.data;
        
        System.out.println(fWalker.getChild());
        System.out.println("\n Root: "+ fWalker.fGetRoot());
        
       //Path path = ...;
       // Files.walkFileTree(path, fWalker);
        
//
//        sResult = fWalker.Search(path);
//
//
//
//
//        System.out.println("creation Time" + sResult.creationTime() + "\n");
//        System.out.println("File Key: " + sResult.fileKey() + "\n");
//        System.out.println("Get Class: " + sResult.getClass() + "\n");
//        System.out.println("isRegularFile: " + sResult.isRegularFile() + "\n");
//        System.out.println("isSymbolicLink: " + sResult.isSymbolicLink() + "\n");
//        System.out.println("lastAccessTime: " + sResult.lastAccessTime() + "\n");
//        System.out.println("lastModifiedTime: " + sResult.lastModifiedTime() + "\n");
//        System.out.println("size: " + sResult.size() + "\n");
//

//        Iterator iterator = sResult.keySet().iterator();
//
//        while (iterator.hasNext()) {
//            String key = iterator.next().toString();
//            String value = sResult.get(key).toString();
//
//            System.out.println(key + " " + value);
//        }
//
    }
}