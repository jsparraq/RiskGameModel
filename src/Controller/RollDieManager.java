/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Conquers_neighbour_Interface;
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

    public static void start(Attack attack,Roll_Dice_Interface window){
        Die.Rolls(attack);
        javax.swing.JLabel label;
        for (int i = 0; i < attack.getAttacks().length; i++) {
            switch (i) {
                case 0:
                    label = window.Attack_1();
                    break;
                case 1:
                    label = window.Attack_2();
                    break;
                default:
                    label = window.Attack_3();
                    break;
            }
            label.setVisible(true);
            label.setText("Die " + (i + 1) + " attack " + attack.getAttacks()[i].getValue());
        }
        
        for (int i = 0; i < attack.getDefense().length; i++) {
            switch (i) {
                case 0:
                    label = window.Defense_1();
                    break;
                default:
                    label = window.Defense_2();
                    break;
            }
            label.setVisible(true);
            label.setText("Die " + (i + 1) + " defense " + attack.getDefense()[i].getValue());
        }
    }
    public static void Button_Finish(Session sessionstart,Attack attack ,JFrame window) {
        window.setVisible(false);
        if(attack.getDefender().getArmy() == 0){
            new Conquers_neighbour_Interface(sessionstart,attack).setVisible(true);
        }else{
            new Main_Interface(sessionstart).setVisible(true);
        }
    }
}
