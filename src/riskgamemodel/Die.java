/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riskgamemodel;

/**
 *
 * @author Sebastian
 */
public class Die {

    private String Type;
    private int ID;
    private int Value;

    public void setType(String value) {
        this.Type = value;
    }

    public String getType() {
        return Type;
    }

    public void setID(int value) {
        this.ID = value;
    }

    public int getID() {
        return ID;
    }

    public void setValue(int value) {
        this.Value = value;
    }

    public int getValue() {
        return Value;
    }
}
