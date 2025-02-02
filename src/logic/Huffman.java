/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import cu.edu.cujae.ceis.tree.binary.BinaryTree;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Jorgito
 */
public class Huffman {
    private BinaryTree<NodeHuffman> tree;
    private LinkedList<NodeHuffman> listNodeHuffman;
    private String code;

    public Huffman() {
        tree = new BinaryTree<>();
        listNodeHuffman = new LinkedList<>();
    }

    // gets
    public BinaryTree<NodeHuffman> getTree() {
        return tree;
    }

    public LinkedList<NodeHuffman> getListNodeHuffman() {
        return listNodeHuffman;
    }

    public String getCode() {
        return code;
    }

    //sets
    public void setTree(BinaryTree<NodeHuffman> tree) {
        this.tree = tree;
    }

    public void setListNodeHuffman(LinkedList<NodeHuffman> listNodeHuffman) {
        this.listNodeHuffman = listNodeHuffman;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    public void huffmanCode (String phrase){
        
        LinkedList<NodeHuffman> listNodeH = new LinkedList();
        listNodeH = charToNode(stringToArray(phrase));
        
    
    
    
    
    
    
    
    
    
    
    }
    
    private ArrayList<Character> stringToArray(String phrase){
        ArrayList<Character> listChar = new ArrayList<>();
        for (Character c : phrase.toCharArray()) {
            listChar.add(c);
        }
        
        return listChar;
    }
    
    private LinkedList<NodeHuffman> charToNode(ArrayList listChar){
        LinkedList<NodeHuffman> listNodeH = new LinkedList();
        //Iterator<Character> iterator = listChar.iterator();
        int cont;
        //int pos=0;
        Character aux;
        int tam=listChar.size();
        for(int i=0; i<tam;i++){
            cont = 1;
            
            for(int e=i;e<tam;e++){
                if(listChar.get(i)==listChar.get(e)){
                    tam--;
                    cont++;
                    listChar.remove(e);
                }
            }
            NodeHuffman node = new NodeHuffman((char) listChar.get(i),cont);
            listNodeH = insertAndOrder(listNodeH, node);
        }
        return listNodeH;
    }
    
    
    private LinkedList<NodeHuffman> insertAndOrder(LinkedList<NodeHuffman> listNodeH, NodeHuffman node){
        if(listNodeH.isEmpty())
            listNodeH.add(node);
        else{
            boolean val = false;
            int i=0;
            Iterator<NodeHuffman> iterator = listNodeH.iterator();
            while (!val && iterator.hasNext()) {
                if (iterator.next().compareTo(node)>=0){
                    val=true;
                    listNodeH.add(i, node);
                }
                i++;
            }
        }
        return listNodeH;
    }
    
    
}
