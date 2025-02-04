/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;

/**
 *
 * @author Jorgito
 */
public class NodeHuffman extends BinaryTreeNode<NodeHuffman>{
    private char inf;
    private int frequency;

    public NodeHuffman(char inf, int frequency) {
        super();
        setInf(inf);
        setFrequency(frequency);
    }
    
    public NodeHuffman( int frequency) {
        super();
        //info = null;
        setFrequency(frequency);
    }
    
    

    public char getInf() {
        return inf;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setInf(char inf) {
        this.inf = inf;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
    
    public int compareTo(NodeHuffman node){
        return frequency-node.getFrequency();
    }
}
