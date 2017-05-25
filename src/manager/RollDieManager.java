/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import View.Main_Interface;
import javax.swing.JFrame;
import riskgamemodel.Session;

/**
 *
 * @author user
 */
public class RollDieManager {

    public static void Button_Finish(Session sessionstart, JFrame window) {
        window.setVisible(false);
        new Main_Interface(sessionstart).setVisible(true);
    }
}
