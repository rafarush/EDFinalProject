/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

/**
 *
 * @author Jorgito
 */
public class NodeHuffman {
    private char info;
    private int frequency;

    public NodeHuffman(char info, int frequency) {
        setInfo(info);
        setFrequency(frequency);
    }

    public char getInfo() {
        return info;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setInfo(char info) {
        this.info = info;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
    
    public int compareTo(NodeHuffman node){
        return frequency-node.getFrequency();
    }
}
