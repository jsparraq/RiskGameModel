/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riskgamemodel;
import java.util.Arrays;
/**
 *
 * @author Sebastian
 */
public class Die implements Comparable<Die>{

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
    
    public static void Rolls(Territory TAtaque,Territory TDefensa,Attack attack){
        int I;
        int J;
        int ID=1;
        if(TAtaque.getArmy()>3){
            I=3;
        }else{
            I=TAtaque.getArmy()-1;
        }
        Die ATTACKS[] = new Die[I];
        for(int i =I-1; i>-1;i--){
          Die d = new Die();
          d.setType("ATTACK");
          d.setValue(random()); 
          d.setID(ID);
          ID++;
          ATTACKS[i]=d;
        }
        Arrays.sort(ATTACKS);
        
        
        
         if(TDefensa.getArmy()>1){
            J=2;
        }else{
            J=1;
        }
        Die DEFENSE[]= new Die[J];
        for(int i =J-1; i>-1;i--){
          Die d = new Die();
          d.setType("DEFENSE");
          d.setValue(random()); 
          d.setID(ID);
          ID++;
          DEFENSE[i]=d;
        }
        Arrays.sort(DEFENSE);
        int MENOR;
        if(J<I){
           MENOR=J; 
        }else{
            MENOR=I;
        }
        
        for(int i=0;i<MENOR;i++){
            if(ATTACKS[i].getValue()>DEFENSE[i].getValue()){
               int ar = TDefensa.getArmy();
               TDefensa.setArmy(ar-1);
            }else{
               int ar = TAtaque.getArmy();
               TAtaque.setArmy(ar-1);
            }
        }
         
        for (int i = 0; i < ATTACKS.length; i++) {
            System.out.println("Attack: "+(i+1)+" "+ ATTACKS[i].Value);
        }
         for (int i = 0; i < DEFENSE.length; i++) {
            System.out.println("Defense: "+(i+1)+" "+ DEFENSE[i].Value);
        }
        
    }
    
    private static int random(){
        return (int) ((Math.random()*6)+1);
    }
    @Override
    public int compareTo(Die o) {
            if (Value < o.Value) {
                return -1;
            }
            if (Value > o.Value) {
                return 1;
            }
            return 0;
        }
}
