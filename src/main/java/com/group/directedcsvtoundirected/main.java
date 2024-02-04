package com.group.directedcsvtoundirected;

import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author Gevoooo
 */
public class main {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("./"));
        File inputFile = null;
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            inputFile = fileChooser.getSelectedFile();
        }
        
        try {
            FileReader fileReader = new FileReader(inputFile);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
