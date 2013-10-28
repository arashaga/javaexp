/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indexer;

import java.awt.Component;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author arash
 */
class FileTreeCellRenderer extends DefaultTreeCellRenderer {

    private static final long serialVersionUID = -7799441088157759804L;

    private FileSystemView fileSystemView;

    private JLabel label;

    FileTreeCellRenderer() {
        label = new JLabel();
        label.setOpaque(true);
        fileSystemView = FileSystemView.getFileSystemView();
    }

    @Override
    public Component getTreeCellRendererComponent(
        JTree tree,
        Object value,
        boolean selected,
        boolean expanded,
        boolean leaf,
        int row,
        boolean hasFocus) {

        
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;
        
        //we have to do this so the code doesn't break when userobject is null
        if(node.getUserObject() == null) {
            label.setText("Choose a folder");
            
        }else{
            //user boject is the type string and cannot be cast to nio
        String fileName = (String) node.getUserObject();
        Path path = Paths.get(fileName);
        File file = path.toFile();
      
   
        label.setIcon(fileSystemView.getSystemIcon(file));
        label.setText(fileSystemView.getSystemDisplayName(file));
        label.setToolTipText(file.getPath());

//        if (selected) {
//            label.setBackground(backgroundSelectionColor);
//            label.setForeground(textSelectionColor);
//        } else {
//            label.setBackground(backgroundNonSelectionColor);
//            label.setForeground(textNonSelectionColor);
//        }

        }
        return label;
    }
}
