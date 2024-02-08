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
public class Configuracion extends javax.swing.JFrame {

    /**
     * Creates new form
     */
    Fuentes tipoFuente;
    public Configuracion() {
        initComponents();
        tipoFuente = new Fuentes();
        //cuerpo = new Fuentes();
        TituloC.setFont(tipoFuente.fuente(tipoFuente.CHERRY, 0, 58));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TituloC = new javax.swing.JLabel();
        BCantidad = new javax.swing.JButton();
        BSonido = new javax.swing.JButton();
        BTiempo = new javax.swing.JButton();
        BAcercaDe = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TituloC.setForeground(new java.awt.Color(255, 255, 255));
        TituloC.setText("CONFIGURACIÓN");
        getContentPane().add(TituloC, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, 80));

        BCantidad.setForeground(new java.awt.Color(255, 255, 255));
        BCantidad.setText("CANTIDAD DE PALABRAS");
        BCantidad.setBorderPainted(false);
        BCantidad.setContentAreaFilled(false);
        BCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCantidadActionPerformed(evt);
            }
        });
        getContentPane().add(BCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 200, 40));

        BSonido.setForeground(new java.awt.Color(255, 255, 255));
        BSonido.setText("SONIDO");
        BSonido.setBorderPainted(false);
        BSonido.setContentAreaFilled(false);
        getContentPane().add(BSonido, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 183, -1, 30));

        BTiempo.setForeground(new java.awt.Color(255, 255, 255));
        BTiempo.setText("TIEMPO DE RESPUESTA");
        BTiempo.setBorderPainted(false);
        BTiempo.setContentAreaFilled(false);
        getContentPane().add(BTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 170, 40));

        BAcercaDe.setForeground(new java.awt.Color(255, 255, 255));
        BAcercaDe.setText("ACERCA DE");
        BAcercaDe.setBorderPainted(false);
        BAcercaDe.setContentAreaFilled(false);
        getContentPane().add(BAcercaDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 100, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/botoncerrarsesion1.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Configuracion.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 457));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BCantidadActionPerformed

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
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Configuracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAcercaDe;
    private javax.swing.JButton BCantidad;
    private javax.swing.JButton BSonido;
    private javax.swing.JButton BTiempo;
    private javax.swing.JLabel TituloC;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
