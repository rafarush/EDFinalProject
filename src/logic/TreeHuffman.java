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
    
    public TreeHuffman(BinaryTreeNode<NodeHuffman> nodeRoot){
        super();
        root=nodeRoot;
    }
    
    public TreeHuffman(){
        super();
    }
    
}
