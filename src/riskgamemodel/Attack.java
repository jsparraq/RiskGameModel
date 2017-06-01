package riskgamemodel;


/**
 * @author UNC_Risk Game Model
 */
public class Attack {
    private int army;
    private Die[] Attacks;
    private Die[] Defense;
    private Territory attacker;
    private Territory defender;
    
    /**
     * 
     * @param id
     * @param Army
     * @param Dicesattacks
     * @param Dicesdefence
     * @param Attacker
     * @param Defender 
     */
    public Attack(int id, int Army, Die[] Dicesattacks, Die[] Dicesdefence,Territory Attacker,Territory Defender){
        army = Army;
        Attacks = Dicesattacks; 
        Defense = Dicesdefence;
        attacker = Attacker;
        defender = Defender;
    }
    
    /**
     * 
     * @param Attacker
     * @param Defender 
     */
    public Attack(Territory Attacker,Territory Defender){
        attacker = Attacker;
        defender = Defender;
    }
    
    /**
     * 
     * @param value 
     */
    public void setarmy(int value){
        this.army = value;
    }
    
    /**
     * 
     * @return 
     */
    public int getarmy(){
        return army;
    }
    
    /**
     * 
     * @param TAtaque
     * @param TDefensa
     * @return 
     */
    public static Attack Declares(Territory TAtaque,Territory TDefensa){
        Attack attack = new Attack(TAtaque,TDefensa);
        return attack;
    }
    
    /**
     * 
     * @param dice 
     */
    public void setAttacks(Die[] dice){
        Attacks = dice;
    }
    
    /**
     * 
     * @return 
     */
    public Die[] getAttacks(){
        return Attacks;
    }
    
    /**
     * 
     * @param dice 
     */
    public void setDefense(Die[] dice){
        Defense = dice;
    }
    
    /**
     * 
     * @return 
     */
    public Die[] getDefense(){
        return Defense;
    }
    
    /**
     * 
     * @return 
     */
    public Territory getAttacker(){
        return attacker;
    }
    
    /**
     * 
     * @return 
     */
    public Territory getDefender(){
        return defender;
    }
}
