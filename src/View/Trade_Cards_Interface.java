/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Image;
import java.awt.Toolkit;
import riskgamemodel.Player;

/**
 *
 * @author andre
 */
public class Trade_Cards_Interface extends javax.swing.JFrame {

    Player playerstart;
    /**
     * Creates new form Interfaz
     */
    public Trade_Cards_Interface() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public Trade_Cards_Interface(Player player) {
        playerstart = player;
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/icon.png"));
        return retValue;
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
        Button_Finish = new javax.swing.JButton();
        Text = new javax.swing.JLabel();
        Trade_Card_1 = new javax.swing.JComboBox();
        Trade_Card_2 = new javax.swing.JComboBox<>();
        Trade_Card_3 = new javax.swing.JComboBox<>();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(370, 280));
        setResizable(false);
        setSize(new java.awt.Dimension(560, 430));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logo_Risk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/RISK-LOGO_EMEA.png"))); // NOI18N
        getContentPane().add(Logo_Risk, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 220, 130));

        Button_Finish.setText("Finish");
        Button_Finish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_FinishActionPerformed(evt);
            }
        });
        getContentPane().add(Button_Finish, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 80, 40));

        Text.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        Text.setForeground(new java.awt.Color(255, 255, 255));
        Text.setText("Select your cards");
        getContentPane().add(Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 180, 30));

        Trade_Card_1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Card 2", "Card 1", "Card 3", "Card 4" }));
        Trade_Card_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Trade_Card_1ActionPerformed(evt);
            }
        });
        getContentPane().add(Trade_Card_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 210, -1));

        Trade_Card_2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Card 1", "Card 2", "Card 3", "Card 4" }));
        Trade_Card_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Trade_Card_2ActionPerformed(evt);
            }
        });
        getContentPane().add(Trade_Card_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 210, -1));

        Trade_Card_3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Card 3", "Card 2", "Card 1", "Card 4" }));
        getContentPane().add(Trade_Card_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 210, -1));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blue-hd-wallpapers-20.jpg"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Trade_Card_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Trade_Card_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Trade_Card_1ActionPerformed

    private void Trade_Card_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Trade_Card_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Trade_Card_2ActionPerformed

    private void Button_FinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_FinishActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Button_FinishActionPerformed

        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Trade_Cards_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Trade_Cards_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Trade_Cards_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Trade_Cards_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Trade_Cards_Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton Button_Finish;
    private javax.swing.JLabel Logo_Risk;
    private javax.swing.JLabel Text;
    private javax.swing.JComboBox Trade_Card_1;
    private javax.swing.JComboBox<String> Trade_Card_2;
    private javax.swing.JComboBox<String> Trade_Card_3;
    // End of variables declaration//GEN-END:variables
}
