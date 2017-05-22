/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author andre
 */
public class Place_army_Interface extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    public Place_army_Interface() {
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
        Button_finish = new javax.swing.JButton();
        Territory = new javax.swing.JComboBox();
        Map = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logo_Risk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/RISK-LOGO_EMEA.png"))); // NOI18N
        getContentPane().add(Logo_Risk, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, -1, -1));

        Button_finish.setText("Finish");
        getContentPane().add(Button_finish, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, 110, -1));

        Territory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Territory 1", "Territory 2" }));
        Territory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TerritoryActionPerformed(evt);
            }
        });
        getContentPane().add(Territory, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, 130, -1));

        Map.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Map.jpg"))); // NOI18N
        getContentPane().add(Map, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blue-hd-wallpapers-20.jpg"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TerritoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TerritoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TerritoryActionPerformed

     
 
     
    


    
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
            java.util.logging.Logger.getLogger(Place_army_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Place_army_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Place_army_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Place_army_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Place_army_Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton Button_finish;
    private javax.swing.JLabel Logo_Risk;
    private javax.swing.JLabel Map;
    private javax.swing.JComboBox Territory;
    // End of variables declaration//GEN-END:variables
}
