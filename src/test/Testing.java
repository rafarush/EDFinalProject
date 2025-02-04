/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import cu.edu.cujae.ceis.tree.Tree;
import cu.edu.cujae.ceis.tree.binary.BinaryTree;
import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;

/**
 *
 * @author rgarc
 */
public class Testing {
    private BinaryTree<String> tree;
    private BinaryTreeNode<String> nodeA;
    private BinaryTreeNode<String> nodeB;
    private BinaryTreeNode<String> nodeC;
    private BinaryTreeNode<String> nodeD;
    
    public Testing() {
        
        nodeA = new BinaryTreeNode("A");
        nodeB = new BinaryTreeNode("B");
        nodeC = new BinaryTreeNode("C");
        nodeD = new BinaryTreeNode("D");
        
        nodeA.setLeft(nodeB);
        nodeA.setRight(nodeC);
        tree = new BinaryTree(nodeA);
        
        
        System.out.println(tree);
        
    }
    
    public Tree<String> getTree(){
        return this.tree;
    }
}
