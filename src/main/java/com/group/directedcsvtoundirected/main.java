package com.group.directedcsvtoundirected;

import com.opencsv.CSVReader;
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
            CSVReader csvReader = new CSVReader(fileReader);
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                for (String cell : nextRecord) {
                    System.out.print(cell + "\t");
                }
                System.out.println("");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
