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
    private Character inf;
    private int frequency;

    public NodeHuffman(char info, int frequency) {
        setInfo(info);
        setFrequency(frequency);
    }
    
    public NodeHuffman( int frequency) {
        info = null;
        setFrequency(frequency);
    }
    
    

    public char getInf() {
        return inf;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setInfo(char info) {
        this.inf = inf;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
    
    public int compareTo(NodeHuffman node){
        return frequency-node.getFrequency();
    }
}
