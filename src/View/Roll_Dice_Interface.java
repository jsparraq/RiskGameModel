/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import manager.RollDieManager;
import riskgamemodel.Attack;
import riskgamemodel.Session;
import riskgamemodel.Territory;

/**
 *
 * @author andre
 */
public class Roll_Dice_Interface extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    Session sessionstart;
    Attack attack;

    public Roll_Dice_Interface(Session session,Attack attack) {
        sessionstart = session;
        this.attack = attack;
        initComponents();
        Die_Value_Attack_1.setVisible(false);
        Die_Value_Attack_2.setVisible(false);
        Die_Value_Attack_3.setVisible(false);
        Die_Value_Defense_1.setVisible(false);
        Die_Value_defense_2.setVisible(false);
        RollDieManager.start(attack, this);
        this.setLocationRelativeTo(null);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Logo_Risk = new javax.swing.JLabel();
        Die_Value_Attack_1 = new javax.swing.JLabel();
        Die_Value_Attack_2 = new javax.swing.JLabel();
        Die_Value_Attack_3 = new javax.swing.JLabel();
        Die_Value_Defense_1 = new javax.swing.JLabel();
        Die_Value_defense_2 = new javax.swing.JLabel();
        Button_Finish = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logo_Risk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/RISK-LOGO_EMEA.png"))); // NOI18N
        getContentPane().add(Logo_Risk, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, -1, -1));

        Die_Value_Attack_1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        Die_Value_Attack_1.setForeground(new java.awt.Color(255, 255, 255));
        Die_Value_Attack_1.setText("Die 1 Attack    5");
        getContentPane().add(Die_Value_Attack_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        Die_Value_Attack_2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        Die_Value_Attack_2.setForeground(new java.awt.Color(255, 255, 255));
        Die_Value_Attack_2.setText("Die 2 Attack    3");
        getContentPane().add(Die_Value_Attack_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, -1));

        Die_Value_Attack_3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        Die_Value_Attack_3.setForeground(new java.awt.Color(255, 255, 255));
        Die_Value_Attack_3.setText("Die 3 Attack    1");
        getContentPane().add(Die_Value_Attack_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 160, 30));

        Die_Value_Defense_1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        Die_Value_Defense_1.setForeground(new java.awt.Color(255, 255, 255));
        Die_Value_Defense_1.setText("Die 1 Defense    6");
        getContentPane().add(Die_Value_Defense_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, -1, -1));

        Die_Value_defense_2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        Die_Value_defense_2.setForeground(new java.awt.Color(255, 255, 255));
        Die_Value_defense_2.setText("Die 2 Defense    1");
        getContentPane().add(Die_Value_defense_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, -1, -1));

        Button_Finish.setText("Finish");
        Button_Finish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_FinishActionPerformed(evt);
            }
        });
        getContentPane().add(Button_Finish, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 320, 120, 40));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blue-hd-wallpapers-20.jpg"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_FinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_FinishActionPerformed
        RollDieManager.Button_Finish(sessionstart, this);
    }//GEN-LAST:event_Button_FinishActionPerformed

    public javax.swing.JLabel Attack_1(){
        return Die_Value_Attack_1;
    }
    
    public javax.swing.JLabel Attack_2(){
        return Die_Value_Attack_2;
    }
    
    public javax.swing.JLabel Attack_3(){
        return Die_Value_Attack_3;
    }
  
    public javax.swing.JLabel Defense_1(){
        return Die_Value_Defense_1;
    }
    
    public javax.swing.JLabel Defense_2(){
        return Die_Value_defense_2;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton Button_Finish;
    private javax.swing.JLabel Die_Value_Attack_1;
    private javax.swing.JLabel Die_Value_Attack_2;
    private javax.swing.JLabel Die_Value_Attack_3;
    private javax.swing.JLabel Die_Value_Defense_1;
    private javax.swing.JLabel Die_Value_defense_2;
    private javax.swing.JLabel Logo_Risk;
    // End of variables declaration//GEN-END:variables
}
