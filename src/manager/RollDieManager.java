/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import View.Main_Interface;
import View.Roll_Dice_Interface;
import javax.swing.JFrame;
import riskgamemodel.Attack;
import riskgamemodel.Die;
import riskgamemodel.Session;
import riskgamemodel.Territory;

/**
 *
 * @author user
 */
public class RollDieManager {

    public static void start(Territory TAtaque,Territory TDefensa,Attack attack,Roll_Dice_Interface window){
        Die.Rolls(TAtaque, TDefensa, attack);
        int attacks_number = 0;
        int defense_number = 0;
        for (int i = 0; i < attack.getDice().length; i++) {
            if(attack.getDice()[i].getType().equals("ATTACK")){
                attacks_number++;
            }else if(attack.getDice()[i].getType().equals("DEFENSE")){
                attacks_number++;
            }
        }
        
    }
    public static void Button_Finish(Session sessionstart, JFrame window) {
        window.setVisible(false);
        new Main_Interface(sessionstart).setVisible(true);
    }
}
