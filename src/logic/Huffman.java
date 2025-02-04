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
    public TreeHuffman getTree() {
        return treeHuffman;
    }

    public LinkedList<NodeHuffman> getListNodeHuffman() {
        return listNodeHuffman;
    }

    public String getCode() {
        return code;
    }

    //sets
    /*
    public void setTree(BinaryTree<NodeHuffman> tree) {
        this.treeHuffman = tree;
    }
    */


    public void setListNodeHuffman(LinkedList<NodeHuffman> listNodeHuffman) {
        this.listNodeHuffman = listNodeHuffman;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    public void huffmanCode (String phrase){
        
        //LinkedList<NodeHuffman> listNodeH = new LinkedList();
        //stringToArray(phrase);
        //listNodeHuffman = charToNode(stringToArray(phrase));
        //listNodeHuffman = listNodeH;
        
        listNodeHuffman = charToNode(stringToArray(phrase));
        Queue<NodeHuffman> queueHuffman = listNodeHuffman;
        treeHuffman = linkedToTree(queueHuffman);
        
        treeHuffman.printTreet(); 
    
    
    
    
    
    
    
    
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
    private LinkedList<NodeHuffman> charToNode(ArrayList<Character> listChar){
        LinkedList<NodeHuffman> listNodeH = new LinkedList();
        //Iterator<Character> iterator = listChar.iterator();
        int cont;        
        int tam=listChar.size();
        for(int i=0; i<tam;i++){
            cont = 1;
            
            for(int e=i+1;e<tam;e++){
                if(listChar.get(i)==listChar.get(e)){
                    //System.out.println(listChar.get(i));
                    //tam--;
                    cont++;
                    listChar.remove(e);
                    tam=listChar.size();
                }
            }
            NodeHuffman node = new NodeHuffman((char) listChar.get(i),cont);
            listNodeH = insertAndOrder(listNodeH, node);
        }
        
        return listNodeH;
    }
    
    //para insertar un una lista de NodeHuffman un NodeHuffman en su posicion ordenada
    private LinkedList<NodeHuffman> insertAndOrder(LinkedList<NodeHuffman> listNodeH, NodeHuffman node){
        //System.err.println(node.getFrequency());
        if(listNodeH.isEmpty())
            listNodeH.add(node);
        else{
            boolean val = false;
            int i=0;
            
            Iterator<NodeHuffman> iterator = listNodeH.iterator();
            while (!val && iterator.hasNext()) {
                if (((NodeHuffman)iterator.next()).compareTo(node)>=0){
                    val=true;
                    listNodeH.add(i, node);
                }
                i++;
            }
            if(!val)
                listNodeH.add(i, node);
        }
        return listNodeH;
    }
    
    //para hacer el arbol binario el codigo de Huffman
    private TreeHuffman linkedToTree(Queue<NodeHuffman> queueNodes){
        
        // VERIFICAR Q SI LA COLA ES D @ ELEMENTOS NO SE ROMPA
        
        NodeHuffman aux1;
        NodeHuffman aux2;
        NodeHuffman root;

        while (queueNodes.size()>1) {
            aux1 = queueNodes.poll();
            System.out.println(aux1.getInf()+ "--" + aux1.getFrequency());
            
            aux2 = queueNodes.poll();
            System.out.println(aux2.getInf()+ "--" + aux2.getFrequency());
            
            root = new NodeHuffman(aux1.getFrequency()+aux2.getFrequency());
            System.out.println(root.getInf()+ "--" + root.getFrequency());
            
            root.setLeft(aux1);
            root.setRight(aux2);
            LinkedList<NodeHuffman> linkedAux = new LinkedList<>(queueNodes);
            linkedAux = insertAndOrder(linkedAux, root);
            queueNodes = linkedAux;
        }
        aux1 = queueNodes.poll();
        
        System.out.println(aux1);
        TreeHuffman tree = new TreeHuffman(aux1);
        //tree.setRoot(aux1);
        
        return tree;
    }
    
    
}
