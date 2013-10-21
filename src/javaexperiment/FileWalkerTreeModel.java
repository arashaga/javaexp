/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaexperiment;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author arash
 */
public class FileWalkerTreeModel implements TreeModel {

    private Path path;
    private String sPath;
//    private boolean showAncestors;
    private String root;
    private ArrayList<TreeModelListener> treeModelListener = new ArrayList<TreeModelListener>();

    public FileWalkerTreeModel(String thisPath) {
        
        sPath = (thisPath ==null)?System.getProperty("user.home"):thisPath;
        
        path = Paths.get(sPath);
        root = this.path.getFileName().toString();
        File tempFile = new File(root);
        
        root = (root == null)?tempFile.getParent():root;
      
        treeModelListener = new ArrayList();


    }

    @Override
    public Object getRoot() {
        return (new File(root));
    }

    @Override
    public Object getChild(Object parent, int i) {
        File directory = (File) parent;
        String[] directories = directory.list();

        return (new File(directory, directories[i]));

    }

    @Override
    public int getChildCount(Object parent) {

        File fileMembers = (File) parent;
        if (fileMembers.isDirectory()) {
            String[] dirMembers = fileMembers.list();
            return dirMembers.length;
        } else {
            return 0;
        }
    }

    @Override
    public boolean isLeaf(Object o) {
        return ((File) o).isFile();
    }

    @Override
    public void valueForPathChanged(TreePath tp, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {

        File directory = (File) parent;
        File dirMember = (File) child;
        String[] dirStrings = directory.list();
        int result = -1;

        for (int i = 0; i < dirStrings.length; ++i) {

            if (dirMember.getName().equals(dirStrings[i]));
            result = i;
            break;
        }
        return result;
    }

    @Override
    public void addTreeModelListener(TreeModelListener tl) {

        if (tl != null && !treeModelListener.contains(tl)) {
            treeModelListener.add(tl);
        }
    }

    @Override
    public void removeTreeModelListener(TreeModelListener tl) {


        if (tl != null) {

            treeModelListener.remove(tl);
        }
    }

    public void fireTreeNodesInserted(TreeModelEvent e) {
        Enumeration listernerCount = Collections.enumeration(treeModelListener);

        while (listernerCount.hasMoreElements()) {
            TreeModelListener listener = (TreeModelListener) listernerCount.nextElement();
            listener.treeNodesInserted(e);
        }
    }

    public void fireTreeNodesRemoved(TreeModelEvent e) {

        Enumeration listernerCount = Collections.enumeration(treeModelListener);

        while (listernerCount.hasMoreElements()) {
            TreeModelListener listener = (TreeModelListener) listernerCount.nextElement();
            listener.treeNodesRemoved(e);
        }
    }

    public void fireTreeNodesChanged(TreeModelEvent e) {
        
                Enumeration listernerCount = Collections.enumeration(treeModelListener);

        while (listernerCount.hasMoreElements()) {
            TreeModelListener listener = (TreeModelListener) listernerCount.nextElement();
            listener.treeNodesChanged(e);
        }
    }

    public void fireTreeStructureChanged(TreeModelEvent e) {
        
                Enumeration listernerCount = Collections.enumeration(treeModelListener);

        while (listernerCount.hasMoreElements()) {
            TreeModelListener listener = (TreeModelListener) listernerCount.nextElement();
            listener.treeStructureChanged(e);
        }
    }

public static void main(String[] args) {
        
        String path;
        path = "c:\\";
        
  //      FileWalkerTreeModel fWalkerModel = new FileWalkerTreeModel(path);
        
    //    System.out.println(fWalkerModel.getChild(fWalkerModel, 1));
        
    }
}
