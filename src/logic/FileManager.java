/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import logic.Convert;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author rgarc
 */
public class FileManager {
    
    public static void saveFile(Huffman huff){
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save File");

        // Filtrar para mostrar solo archivos específicos (opcional)
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Binary File", "dat");
        fileChooser.setFileFilter(filter);

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            System.out.println("Save file as: " + fileToSave.getAbsolutePath());
            
            if (!fileToSave.getAbsolutePath().endsWith(".dat")) {
                fileToSave = new File(fileToSave + ".dat");
            }

            // Aquí puedes añadir el código para guardar el archivo
            //try (FileOutputStream fos = new FileOutputStream(fileToSave)) {
            try (RandomAccessFile file = new RandomAccessFile(fileToSave, "rw")) {
                // Contenido binario a guardar en el archivo
                
                byte[] content = Convert.toBytes(huff); // Ejemplo de binario
                //file.writeInt(content.length);
                file.write(content);
                System.out.println("File saved successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static Huffman loadFile() throws ClassNotFoundException{
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Load file");
        Huffman huff = null;

        // Filtrar para mostrar solo archivos con la extensión .dat (opcional)
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de datos", "dat");
        fileChooser.setFileFilter(filter);

        int userSelection = fileChooser.showOpenDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToLoad = fileChooser.getSelectedFile();
            huff = new Huffman();
            System.out.println("Load file: " + fileToLoad.getAbsolutePath());

            // Aquí puedes añadir el código para leer el archivo binario
            try (RandomAccessFile file = new RandomAccessFile(fileToLoad, "rw")) {
                // Leer el contenido binario del archivo
                byte[] contenido = {};
                file.readFully(contenido);
                huff = (Huffman) Convert.toObject(contenido);
                //System.out.println("File content: ");
                /*for (byte b : contenido) {
                    System.out.printf("%02x ", b);
                }*/
                //String test = (String) Convert.toObject(contenido);
                //System.out.println(test);
                System.out.println("\nFile loaded successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return huff;
    }
    
}
