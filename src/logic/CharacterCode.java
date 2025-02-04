/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

/**
 *
 * @author Jorgito
 */
public class CharacterCode {
    private Character character;
    private String code;

    public CharacterCode(Character character, String code) {
        setCharacter(character);
        setCode(code);
    }

    public Character getCharacter() {
        return character;
    }

    public String getCode() {
        return code;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    
    
}
