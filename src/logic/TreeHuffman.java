/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import cu.edu.cujae.ceis.tree.binary.BinaryTree;
import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import java.io.Serializable;

/**
 *
 * @author Jorgito
 */
public class TreeHuffman extends BinaryTree<NodeHuffman> implements Serializable{
    //private NodeHuffman root;
    private static final long serialVersionUID = -5918777617621318795L;
    
    public TreeHuffman(NodeHuffman nodeRoot){
        //super();
        root=nodeRoot;
    }
    
    public TreeHuffman(){
        //super();
        root=null;
    }

    
    public NodeHuffman getRoot() {
        return (NodeHuffman)root;
    }
    
    
    public void setRoot(NodeHuffman root) {
        this.root = root;
    }
    
    
    
    
    
    public void printTree(){
        printTree((NodeHuffman)root, "", true);
    }
    
    public void printTree(NodeHuffman node, String indent, boolean last){
        if(node!=null){
            System.out.print(indent);
            if(last){
                System.out.print("\\-- ");
                indent += "   ";
            }else{
                System.out.print("|-- ");
                indent += "|   ";
            }
            System.out.println(node.getFrequency()+"."+node.getInf());
            printTree(((NodeHuffman)node.getLeft()), indent, false);
            printTree(((NodeHuffman)node.getRight()), indent, true);
        
        }
    }
}
