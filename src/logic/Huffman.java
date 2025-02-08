/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Jorgito
 */
public class Huffman implements Serializable{
    private TreeHuffman treeHuffman;
    private LinkedList<NodeHuffman> listNodeHuffman;
    private String phrase;
    private String code;
    private static final long serialVersionUID = 1L;

    public Huffman() {
        treeHuffman = new TreeHuffman();
        listNodeHuffman = new LinkedList<>();
        //listCharacterCode = new LinkedList<>();
    }

    
    
    // gets
    public TreeHuffman getTree() {
        return treeHuffman;
    }

    public String getPhrase() {
        return phrase;
    }

    public LinkedList<NodeHuffman> getListNodeHuffman() {
        return listNodeHuffman;
    }

    public String getCode() {
        return code;
    }

    //sets
    
    public void setTree(TreeHuffman tree) {
        this.treeHuffman.setRoot(tree.getRoot());
    }
    

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }


    public void setListNodeHuffman(LinkedList<NodeHuffman> listNodeHuffman) {
        this.listNodeHuffman = listNodeHuffman;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    public void huffmanCode (String phrase){
        setPhrase(phrase);
        //LinkedList<NodeHuffman> listNodeH = new LinkedList();
        //stringToArray(phrase);
        //listNodeHuffman = charToNode(stringToArray(phrase));
        //listNodeHuffman = listNodeH;
        
        listNodeHuffman = charToNode(stringToArray(phrase));
        Queue<NodeHuffman> queueHuffman = new LinkedList<>(listNodeHuffman);
        treeHuffman = linkedToTree(queueHuffman); 
        
        listNodeHuffman=linkedCode();
        
        code=treeToCode(stringToLinked(phrase));
    
    
    
    
    
    
    }
    
    // para buscar el codigo de codigo de la frase
    public String treeToCode(LinkedList<Character> phrase){
        String codeH="";
        Iterator<Character> iterator=phrase.iterator();
        
        while (iterator.hasNext()) {
            codeH=codeH+charToCode(iterator.next());
        }
        return codeH;
    }
    
    private String charToCode(Character character){
        String code="";
        Iterator<NodeHuffman> iterator = listNodeHuffman.iterator();
        boolean val=false;
        while (iterator.hasNext() && !val) {
            NodeHuffman aux = iterator.next();
            if(character.equals(aux.getInf())){
                val=true;
                code=aux.getCode();
            }
        }
        
        return code;
    }
    
    
    
    
    //para buscar el codigo de cada caracter
    private LinkedList<NodeHuffman> linkedCode(){
        LinkedList<NodeHuffman> listNode = new LinkedList<>();
        NodeHuffman root = treeHuffman.getRoot();
        if(((Character)root.getInf()).equals('•')){
            listNode.addAll(linkedCode("00",((NodeHuffman)root.getLeft())));
            listNode.addAll(linkedCode("01",((NodeHuffman)root.getRight())));
        }else{
            root.setCode("0");
            listNode.add(root);
        }
        return listNode;
    }
    
    private LinkedList<NodeHuffman> linkedCode(String code, NodeHuffman node){
        LinkedList<NodeHuffman> listNode = new LinkedList<>();
        if(((Character)node.getInf()).equals('•')){
            listNode.addAll(linkedCode(code+"0",((NodeHuffman)node.getLeft())));
            listNode.addAll(linkedCode(code+"1",((NodeHuffman)node.getRight())));
        }else{
            node.setCode(code);
            listNode.add(node);
        }
        
        
        return listNode;
    }
    
    //para convertir el String en un LinkedList de char
    private LinkedList<Character> stringToLinked(String phrase){
        LinkedList<Character> listChar = new LinkedList<>();
        for (Character c : phrase.toCharArray()) {
            listChar.add(c);
        }
            
        return listChar;
    }
    
    //para convertir el String en un ArrayList de char
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
                if(listChar.get(i).equals(listChar.get(e))){
                //if(listChar.get(i)==listChar.get(e)){
                    //System.out.println(listChar.get(i));
                    //tam--;
                    cont++;
                    listChar.remove(e);
                    tam=listChar.size();
                    e--;
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
            aux2 = queueNodes.poll();
            root = new NodeHuffman(aux1.getFrequency()+aux2.getFrequency());
            
            root.setLeft(aux1);
            root.setRight(aux2);
            
            LinkedList<NodeHuffman> linkedAux = new LinkedList<>(queueNodes);
            linkedAux = insertAndOrder(linkedAux, root);
            queueNodes = linkedAux;
        }
        TreeHuffman tree = new TreeHuffman();
        if(queueNodes.size()!=0){
            aux1 = queueNodes.poll();
            tree.setRoot(aux1);
        }
        return tree;
    }
    
    
}
