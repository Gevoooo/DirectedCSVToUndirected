package com.group.directedcsvtoundirected;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author Gevoooo
 */
public class main {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("./"));
        File inputFile = null;
        String fileName = "";
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            inputFile = fileChooser.getSelectedFile();
            fileName = fileChooser.getName(fileChooser.getSelectedFile());
        }
        try {
            FileReader fileReader = new FileReader(inputFile);
            CSVReader csvReader = new CSVReader(fileReader);
            String[] nextRecord;
            
            FileWriter outputFile = new FileWriter(new File("./" + fileName + "_Undirected.csv"));
            CSVWriter csvWriter = new CSVWriter(outputFile);
            
            while ((nextRecord = csvReader.readNext()) != null) {
                String[] flippedRecord = {nextRecord[1], nextRecord[0]};
                csvWriter.writeNext(nextRecord);
                csvWriter.writeNext(flippedRecord);
            }
            csvWriter.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
