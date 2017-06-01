
package riskgamemodel;
import java.util.Arrays;
/**
 * @author Sebastian
 */
public class Die implements Comparable<Die>{

    private String Type;
    private int ID;
    private int Value;

    public void Die(){
        
    }
    
    /**
     * 
     * @param Type
     * @param ID
     * @param Value 
     */
    public void Die(String Type,int ID,int Value){
        this.Type = Type;
        this.ID = ID;
        this.Value = Value;
    }
    
    /**
     * 
     * @param value 
     */
    public void setType(String value) {
        this.Type = value;
    }

    /**
     * 
     * @return 
     */
    public String getType() {
        return Type;
    }

    /**
     * 
     * @param value 
     */
    public void setID(int value) {
        this.ID = value;
    }

    /**
     * 
     * @return 
     */
    public int getID() {
        return ID;
    }

    /**
     * 
     * @param value 
     */
    public void setValue(int value) {
        this.Value = value;
    }

    /**
     * 
     * @return 
     */
    public int getValue() {
        return Value;
    }
    
    /**
     * 
     * @param attack 
     */
    public static void Rolls(Attack attack){
        int I;
        int J;
        int ID=1;
        if(attack.getAttacker().getArmy()>3){
            I=3;
        }else{
            I=attack.getAttacker().getArmy()-1;
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
         if(attack.getDefender().getArmy()>1){
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
               int ar = attack.getDefender().getArmy();
               attack.getDefender().setArmy(ar-1);
            }else{
               int ar = attack.getAttacker().getArmy();
               attack.getAttacker().setArmy(ar-1);
            }
        }
        Die[] dice = new Die[I];
        for (int i = 0; i < ATTACKS.length; i++) {
            dice[i] = ATTACKS[i];
        }
        attack.setAttacks(dice);
        Die[] dice1 = new Die[J];
        for (int i = 0; i < DEFENSE.length; i++) {
            dice1[i] = DEFENSE[i];
        }
        attack.setDefense(dice1);  
        attack.setarmy(I);
    }
    
    private static int random(){
        return (int) ((Math.random()*6)+1);
    }
    
    /**
     * 
     * @param o
     * @return 
     */
    @Override
    public int compareTo(Die o) {
            if (Value > o.Value) {
                return -1;
            }
            if (Value < o.Value) {
                return 1;
            }
            return 0;
        }
}
