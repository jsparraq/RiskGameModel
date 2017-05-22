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

    public void Die(){
        this.Type=null;
        this.ID=0;
        this.Value=0;
    }
    public void Die(String Type,int ID,int Value){
        this.Type=null;
        this.ID=0;
        this.Value=0;
    }
    
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
    
    public static void Rolls(Territory TAtaque,Territory TDefensa){
        int I;
        int ID=1;
        if(TAtaque.getArmy()>3){
            I=3;
        }else{
            I=TAtaque.getArmy()-1;
        }
        Die ATTACKS[]= new Die[I];
        for(int i =I-1; i>-1;i--){
          Die d = new Die();
          d.setType("ATTACK");
          d.setValue(random()); 
          d.setID(ID);
          ID++;
          ATTACKS[I]=d;
        }
        
    }
    
    private static int random(){
        return (int) ((Math.random()*6)+1);
    }
}
