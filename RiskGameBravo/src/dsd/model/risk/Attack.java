package dsd.model.risk;


/**
 * @author UNC_Risk Game Model
 */
public class Attack {
    private int army;
    private int ID;
    private Die[] Attacks;
    private Die[] Defense;
    private Territory attacker;
    private Territory defender;
    
    
    /**
     * This method is the constructor of Attack class
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
        ID = id;
        
    }
    
    /**
     * This method is the constructor of Attack class
     * @param Attacker
     * @param Defender 
     */
    public Attack(Territory Attacker,Territory Defender){
        attacker = Attacker;
        defender = Defender;
    }
    
    /**
     * This method set the value of the army 
     * @param value 
     */
    public void setarmy(int value){
        this.army = value;
    }
    
    /**
     * This method sets the value of the army of the attack
     * @return The army of the attack
     */
    public int getarmy(){
        return army;
    }
    
    /**
     * This method creates an Attack and returns an attack
     * @param TAtaque
     * @param TDefensa
     * @return 
     */
    public static Attack Declares(Territory TAtaque,Territory TDefensa){
        Attack attack = new Attack(TAtaque,TDefensa);
        return attack;
    }
    
    /**
     * This method set the value of the Attacks  of the attack(the dies in the attack).
     * @param dice 
     */
    public void setAttacks(Die[] dice){
        Attacks = dice;
    }
    
    /**
     * This method returns the Attacks of the attack (the dies in the attack)
     * @return The array of dice of the attacker territory
     */
    public Die[] getAttacks(){
        return Attacks;
    }
    
    /**
     * This method set the defense of the attack
     * @param dice  
     */
    public void setDefense(Die[] dice){
        Defense = dice;
    }
    
    /**
     * This method get the defense  of the attack
     * @return The array of dice of the defender territory
     */
    public Die[] getDefense(){
        return Defense;
    }
    
    /**
     * This method gets the attacker of the attack
     * @return The attacker territory
     */
    public Territory getAttacker(){
        return attacker;
    }
    
    /**
     * This method get the defender of the attack
     * @return The defender territory
     */
    public Territory getDefender(){
        return defender;
    }
}
