/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Tipografias.Fuentes;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EMmanuel
 */
public class StartAddWord extends javax.swing.JFrame {

    DefaultTableModel modelo;
    /**
     * Creates new form InicioMain
     */
    Fuentes tipoFuente;
  //  public  String[] wSpansh ; 
        
  //  public  String[] wIngles ;

    public StartAddWord() {
        initComponents();
        
        tipoFuente = new Fuentes();
        //cuerpo = new Fuentes();
        Subtitulo.setFont(tipoFuente.fuente(tipoFuente.CHERRY, 0, 50));
        btncomenzar.setFont(tipoFuente.fuente(tipoFuente.NINE, 0, 35));
        btnañadir.setFont(tipoFuente.fuente(tipoFuente.NINE, 0, 30));
      //   wSpansh = new String[tabla.getRowCount()+1];
      //   wIngles = new String[tabla.getRowCount()+1];
    }
    
    public void limpiarTF(){
        JTFpe.setText("");
        JTFpi.setText("");
    }
    
    public void openMenu(){
        
        MenuMain obj = new MenuMain();
        obj.setVisible(true);
        dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Subtitulo = new javax.swing.JLabel();
        Español = new javax.swing.JLabel();
        Ingles = new javax.swing.JLabel();
        JTFpe = new javax.swing.JTextField();
        JTFpi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btncomenzar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnañadir = new javax.swing.JButton();
        JLfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Subtitulo.setForeground(new java.awt.Color(0, 74, 173));
        Subtitulo.setText("Ingresa tus palabras aquí");
        Subtitulo.setName(""); // NOI18N
        getContentPane().add(Subtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, -1, -1));

        Español.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        Español.setForeground(new java.awt.Color(23, 159, 235));
        Español.setText("Español");
        getContentPane().add(Español, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, -1, -1));

        Ingles.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        Ingles.setForeground(new java.awt.Color(23, 159, 235));
        Ingles.setText("Inglés");
        getContentPane().add(Ingles, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 180, -1, -1));

        JTFpe.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        JTFpe.setBorder(null);
        getContentPane().add(JTFpe, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 390, 50));

        JTFpi.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        JTFpi.setBorder(null);
        JTFpi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFpiActionPerformed(evt);
            }
        });
        getContentPane().add(JTFpi, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 220, 390, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/iconcontrolinicio5.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 100, 70));

        btncomenzar.setForeground(new java.awt.Color(23, 159, 235));
        btncomenzar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/botonS_60x142.png"))); // NOI18N
        btncomenzar.setText("COMENZAR");
        btncomenzar.setBorderPainted(false);
        btncomenzar.setContentAreaFilled(false);
        btncomenzar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btncomenzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncomenzarActionPerformed(evt);
            }
        });
        getContentPane().add(btncomenzar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 550, 140, 70));

        tabla.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Palabras en español", "Palabras en inglés"
            }
        ));
        tabla.setRowHeight(30);
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 930, 180));

        btnañadir.setBackground(new java.awt.Color(204, 255, 255));
        btnañadir.setText("AÑADIR");
        btnañadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnañadirActionPerformed(evt);
            }
        });
        getContentPane().add(btnañadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, -1, -1));

        JLfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Inicio1137x650.png"))); // NOI18N
        getContentPane().add(JLfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JTFpiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFpiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFpiActionPerformed

    private void btncomenzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncomenzarActionPerformed
       
       MusicPlayer.playMusic("/Music/SonidoBoton.wav");
        limpiarTF();
        
        boolean verificar = JTFpe.getText().equals("") || JTFpi.getText().equals("") ;
        
       
        if (verificar && tabla.getRowCount()>=1){

        String[] wSpansh = new String[tabla.getRowCount()];
        
        String[] wIngles = new String[tabla.getRowCount()];

        for(int i=0;i<tabla.getRowCount(); i++){
    
        wSpansh[i] = (String) tabla.getValueAt(i,0);
        
        wIngles[i] = (String) tabla.getValueAt(i,1);
     
        } 
        
        openMenu();
        ModoClasico.wUser = wIngles;
        ModoReto.wUser = wIngles;
        ModoReto.wUserSpanish = wSpansh;
        
        
        }else{
            
             JOptionPane.showMessageDialog(this, "Tienes que llenar los campos correspondientes");
        }
        
    }//GEN-LAST:event_btncomenzarActionPerformed

    private void btnañadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnañadirActionPerformed
       
        MusicPlayer.playMusic("/Music/SonidoBoton.wav");
        
        if (JTFpe.getText().equals("") || JTFpi.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Asegurate de llenar los campos requeridos");
            
        }else{
            String datos[] = {JTFpe.getText(), JTFpi.getText()};
            
            DefaultTableModel tblModel = (DefaultTableModel) tabla.getModel();
            
            tblModel.addRow(datos);
        }
        
        limpiarTF();
        
    }//GEN-LAST:event_btnañadirActionPerformed

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
            java.util.logging.Logger.getLogger(StartAddWord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartAddWord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartAddWord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartAddWord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartAddWord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Español;
    private javax.swing.JLabel Ingles;
    private javax.swing.JLabel JLfondo;
    private javax.swing.JTextField JTFpe;
    private javax.swing.JTextField JTFpi;
    private javax.swing.JLabel Subtitulo;
    private javax.swing.JButton btnañadir;
    private javax.swing.JButton btncomenzar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
