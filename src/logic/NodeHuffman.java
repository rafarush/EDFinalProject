/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import java.io.Serializable;

/**
 *
 * @author Jorgito
 */
public class NodeHuffman extends BinaryTreeNode<NodeHuffman> implements Serializable{
    private char inf;
    private int frequency;
    private String code;
    private static final long serialVersionUID = -1037498727893069131L;

    public NodeHuffman(char inf, int frequency) {
        super();
        setInf(inf);
        setFrequency(frequency);
        code = null;
    }
    
    public NodeHuffman( int frequency) {
        super();
        //info = null;
        inf = '•';
        setFrequency(frequency);
        code = null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
