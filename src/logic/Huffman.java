/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import cu.edu.cujae.ceis.tree.binary.BinaryTree;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Jorgito
 */
public class Huffman {
    private TreeHuffman treeHuffman;
    private LinkedList<NodeHuffman> listNodeHuffman;
    private String code;

    public Huffman() {
        treeHuffman = new TreeHuffman();
        listNodeHuffman = new LinkedList<>();
    }

    // gets
    public BinaryTree<NodeHuffman> getTree() {
        return treeHuffman;
    }

    public LinkedList<NodeHuffman> getListNodeHuffman() {
        return listNodeHuffman;
    }

    public String getCode() {
        return code;
    }

    //sets
    public void setTree(BinaryTree<NodeHuffman> tree) {
        this.treeHuffman = tree;
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
        Queue<NodeHuffman> queueHuffman = listNodeH;
        treeHuffman = linkedToTree(queueHuffman);
        
    
    
    
    
    
    
    
    
    
    
    }
    
    
    //para cobertir el String en un ArrayList de char
    private ArrayList<Character> stringToArray(String phrase){
        ArrayList<Character> listChar = new ArrayList<>();
        for (Character c : phrase.toCharArray()) {
            listChar.add(c);
        }
        
        return listChar;
    }
    
    //para convertir un ArrayList un una LinkedList ordenada de NodeHuffman
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
    
    //para insertar un una lista de NodeHuffman un NodeHuffman en su posicion ordenada
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
    
    //para hacer el arbol binario el codigo de Huffman
    private BinaryTree<NodeHuffman> linkedToTree(Queue<NodeHuffman> queueNodes){
        BinaryTree<NodeHuffman> tree = new BinaryTree<>();
        NodeHuffman aux1 = null;
        NodeHuffman aux2 = null;
        NodeHuffman root = null;
        while (queueNodes.size()>1) {
            aux1 = queueNodes.poll();
            aux2 = queueNodes.poll();
            root = new NodeHuffman(aux1.getFrequency()+aux2.getFrequency());
            
            
        }
        
    
        
        return tree;
    }
    
    
}
