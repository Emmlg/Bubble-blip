/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Tipografias.Fuentes;

/**
 *
 * @author yired
 */
public class ModoClasico extends javax.swing.JFrame {

    /**
     * Creates new form ModoClasico
     */
    Fuentes tipoFuente;
    public ModoClasico() {
        initComponents();
        tipoFuente = new Fuentes();
        //cuerpo = new Fuentes();
        LTexto1.setFont(tipoFuente.fuente(tipoFuente.CHERRY, 0, 27));
        LTexto2.setFont(tipoFuente.fuente(tipoFuente.CHERRY, 0, 27));
        LTexto3.setFont(tipoFuente.fuente(tipoFuente.CHERRY, 0, 27));
        BLetraSalir.setFont(tipoFuente.fuente(tipoFuente.NINE, 0, 40));
        BLetraMenu.setFont(tipoFuente.fuente(tipoFuente.NINE, 0, 40));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LTexto1 = new javax.swing.JLabel();
        LTexto2 = new javax.swing.JLabel();
        LTexto3 = new javax.swing.JLabel();
        BLetraSalir = new javax.swing.JButton();
        BLetraMenu = new javax.swing.JButton();
        BotonMenu = new javax.swing.JButton();
        BotonSalir = new javax.swing.JButton();
        LCorazon = new javax.swing.JLabel();
        BSonido = new javax.swing.JButton();
        BPausa = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        LFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LTexto1.setForeground(new java.awt.Color(0, 74, 173));
        LTexto1.setText("Presta atención al");
        getContentPane().add(LTexto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 70, 250, 30));

        LTexto2.setForeground(new java.awt.Color(0, 74, 173));
        LTexto2.setText("audio y selecciona");
        getContentPane().add(LTexto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 110, 230, 30));

        LTexto3.setForeground(new java.awt.Color(0, 74, 173));
        LTexto3.setText("la palabra correcta");
        getContentPane().add(LTexto3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 150, 250, 30));

        BLetraSalir.setForeground(new java.awt.Color(31, 19, 71));
        BLetraSalir.setText("SALIR");
        BLetraSalir.setBorderPainted(false);
        BLetraSalir.setContentAreaFilled(false);
        BLetraSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLetraSalirActionPerformed(evt);
            }
        });
        getContentPane().add(BLetraSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 720, 130, 60));

        BLetraMenu.setForeground(new java.awt.Color(31, 19, 71));
        BLetraMenu.setText("MENÚ");
        BLetraMenu.setActionCommand("MENÙ");
        BLetraMenu.setBorderPainted(false);
        BLetraMenu.setContentAreaFilled(false);
        BLetraMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLetraMenuActionPerformed(evt);
            }
        });
        getContentPane().add(BLetraMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 720, 130, 60));

        BotonMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/botonMY_60x142.png"))); // NOI18N
        BotonMenu.setBorderPainted(false);
        BotonMenu.setContentAreaFilled(false);
        getContentPane().add(BotonMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 720, 150, 60));

        BotonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/botonSalirY_60x142.png"))); // NOI18N
        BotonSalir.setBorderPainted(false);
        BotonSalir.setContentAreaFilled(false);
        getContentPane().add(BotonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 720, 150, 60));

        LCorazon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/corazon50x50.png"))); // NOI18N
        getContentPane().add(LCorazon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 50, 60));

        BSonido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/botonsonido2.png"))); // NOI18N
        BSonido.setBorderPainted(false);
        BSonido.setContentAreaFilled(false);
        getContentPane().add(BSonido, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 80, 60));

        BPausa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/BPausa60x60.png"))); // NOI18N
        BPausa.setBorderPainted(false);
        BPausa.setContentAreaFilled(false);
        getContentPane().add(BPausa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 720, 70, 60));
        getContentPane().add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 250, 30));

        LFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ModoClasico1400x800.png"))); // NOI18N
        getContentPane().add(LFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 800));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BLetraMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLetraMenuActionPerformed
        // TODO add your handling code here:
        
        MenuMain obj = new MenuMain();
        obj.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_BLetraMenuActionPerformed

    private void BLetraSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLetraSalirActionPerformed
        // TODO add your handling code here:
        
        MenuMain obj = new MenuMain();
        obj.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_BLetraSalirActionPerformed

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
            java.util.logging.Logger.getLogger(ModoClasico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModoClasico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModoClasico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModoClasico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModoClasico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BLetraMenu;
    private javax.swing.JButton BLetraSalir;
    private javax.swing.JButton BPausa;
    private javax.swing.JButton BSonido;
    private javax.swing.JButton BotonMenu;
    private javax.swing.JButton BotonSalir;
    private javax.swing.JLabel LCorazon;
    private javax.swing.JLabel LFondo;
    private javax.swing.JLabel LTexto1;
    private javax.swing.JLabel LTexto2;
    private javax.swing.JLabel LTexto3;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
