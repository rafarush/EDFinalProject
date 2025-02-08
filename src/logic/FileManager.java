/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;
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
                
                byte[] content = Convert.toBytes(huff.getPhrase()); // Phrase
                file.writeInt(content.length);
                file.write(content);
                content = Convert.toBytes(huff.getCode()); // Code
                file.writeInt(content.length);
                file.write(content);
                content = Convert.toBytes(huff.getTree()); // Tree
                file.writeInt(content.length);
                file.write(content);
                content = Convert.toBytes(huff.getListNodeHuffman()); // TreeNode list
                file.writeInt(content.length);
                file.write(content);
                file.close();
                System.out.println("File saved successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static Huffman loadFile() throws ClassNotFoundException{
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Load file");
        //Huffman huff = null;
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
            try (RandomAccessFile file = new RandomAccessFile(fileToLoad, "r")) {
                // Leer el contenido binario del archivo
                byte[] phrase = new byte [(int) file.readInt()];
                file.read(phrase);
                huff.setPhrase((String)Convert.toObject(phrase));
                byte[] code = new byte [(int) file.readInt()];
                file.read(code);
                huff.setCode((String)Convert.toObject(code));
                byte[] tree = new byte [(int) file.readInt()];
                file.read(tree);
                TreeHuffman th = (TreeHuffman) Convert.toObject(tree);
                huff.setTree(th);
                byte[] nodeList = new byte [(int) file.readInt()];
                file.read(nodeList);
                huff.setListNodeHuffman((LinkedList<NodeHuffman>) Convert.toObject(nodeList));
                file.close();
                System.out.println("\nFile loaded successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return huff;
    }
    
    ///////////////////
    /*
    public void compress (TreeHuffman t) throws IOException{
        RandomAccessFile random = new RandomAccessFile(ficheroHuffman, "rw");
        byte [] byteHuffman = Convert.toBytes(t);
        random.writeLong(byteHuffman.length);
        random.write(byteHuffman);

        random.close();
			
    }
	
    public TreeHuffman decompress () throws IOException, ClassNotFoundException {
            RandomAccessFile random = new RandomAccessFile(ficheroHuffman, "rw");
            byte [] byteHuffman = new byte[(int) random.readLong()];
            random.read(byteHuffman);
            TreeHuffman t = (TreeHuffman) Convert.toObject(byteHuffman);

            random.close();

            return t ;
    }
    */
}
