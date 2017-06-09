package dsd.controller.risk;

import dsd.view.risk.*;
import javax.swing.JFrame;
import dsd.model.risk.*;

/**
 *
 * @author UNC Risk Game Model
 */
public class ConquersNeighbourManager {
    
    /**
     * 
     * @param sessionstart
     * @return 
     */
    public static String Map(Session sessionstart){
        return "/dsd/view/images/" + sessionstart.getMap().getName() + ".png";
    } 
    
    /**
     * 
     * @param attack
     * @return 
     */
    public static String[] armies(Attack attack){
        int inicial = attack.getarmy();
        int Final = attack.getAttacker().getArmy();
        String[] armies = new String[Final - inicial];
        int j = 0;
        for (int i = inicial; i < Final; i++) {
            armies[j]= Integer.toString(i);
            j++;
        }
        return armies;
    }
    
    /**
     * 
     * @param attack
     * @param window
     * @param army
     * @param sessionstart 
     * @param playerstart 
     */
    public static void Button_Finish(Attack attack,JFrame window,String army,Session sessionstart,Player playerstart){
        Territory.conquers(attack, army, sessionstart,playerstart);
        window.setVisible(false);
        new Main_Interface(sessionstart,playerstart).setVisible(true);
    }
}
