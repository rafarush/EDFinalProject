/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import cu.edu.cujae.ceis.tree.binary.BinaryTree;
import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;

/**
 *
 * @author Jorgito
 */
public class TreeHuffman extends BinaryTree<NodeHuffman>{
    //private NodeHuffman root;
    
    
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
    
    
    
    
    
    public void printTreet(){
        printTreet((NodeHuffman)root, "", true);
    }
    
    public void printTreet(NodeHuffman node, String indent, boolean last){
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
            printTreet(((NodeHuffman)node.getLeft()), indent, false);
            printTreet(((NodeHuffman)node.getRight()), indent, true);
        
        }
    }
}
