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

    public void setType(String type_new) {
        this.Type = type_new;
    }

    public String getType() {
        return Type;
    }

    public void setID(int id_new) {
        this.ID = id_new;
    }

    public int getID() {
        return ID;
    }

    public void setValue(int value_new) {
        this.Value = value_new;
    }

    public int getValue() {
        return Value;
    }
}
