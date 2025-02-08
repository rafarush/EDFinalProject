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
public class NodeHuffman implements Serializable{
    private char inf;
    private int frequency;
    private String code;
    private static final long serialVersionUID = 1L;
    private NodeHuffman left;
    private NodeHuffman right;

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

    public NodeHuffman getLeft() {
        return left;
    }

    public NodeHuffman getRight() {
        return right;
    }

    public void setLeft(NodeHuffman left) {
        this.left = left;
    }

    public void setRight(NodeHuffman right) {
        this.right = right;
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
