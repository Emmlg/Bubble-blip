/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControlReadF;
import Tipografias.Fuentes;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

/**
 *
 * @author abiga
 */
public class ModoReto extends javax.swing.JFrame{

    /**
     * Creates new form ModoReto
     */
    
    Fuentes tipoFuente;
    
    StartAddWord wordStart;
    ControlReadF rdF;
    JLabel[] lb; 
    public static String[] wUser;
    public static String[] wUserSpanish;
    boolean status;
    int nextWord;
    int width ; 
    int height;
    int scoreTotal;
    int wordUsuarioC;
    int speed;
    int correctWordsC;
   
    
    FondoPanel fondo = new FondoPanel();
    
public ModoReto() {
    
    this.setContentPane(fondo);
    initComponents();
    tipoFuente= new Fuentes();
    //Fuente texto de instrucciones

    MensajeError.setFont(tipoFuente.fuente(tipoFuente.NINE, 0, 25));
    //Fuente texto botones
    btnsalir.setFont(tipoFuente.fuente(tipoFuente.NINE, 0, 40));
    btniniciar.setFont(tipoFuente.fuente(tipoFuente.NINE, 0, 40));

   // wUser = new String[]{"speak","read","snow","car","believe"}; //palabras del usuario
   // wUserSpanish = new String[]{"hablar","leer","nieve","carro","creer"}; //palabras del usuario
    width = this.getWidth()-200;
    height = this.getHeight()-400;
    status = true;
    rdF = new ControlReadF();
    nextWord =0;
    wordUsuarioC = wUser.length;  
    scoreTotal = wordUsuarioC * 450;
    lb = new JLabel[wUser.length];
    barra.setMaximum(scoreTotal);
    speed = 700;
    correctWordsC = 0;
    
    }






  // generar numeros aleatorios para las burbujas
    
public int  generateRN(int min , int max){

   int range = max - min + 1;
   
   return (int)(Math.random() * range) + min;
}

// crear los lb
public void addlbToFrame(String word,int posx,int posy){
        

    ImageIcon icon = new ImageIcon(ModoClasico.class.getResource("/Img/meteoro128x128.png"));
    lb[nextWord] = new JLabel(icon);

    lb[nextWord].setText(word); 
    lb[nextWord].setHorizontalTextPosition(0); lb[nextWord].setVerticalTextPosition(3);
    lb[nextWord].setBounds(posx,posy,130,150);
    lb[nextWord].setVisible(true);
   //** System.out.println( lb[nextWord].getText());  
    fondo.add(lb[nextWord]);
    fondo.repaint();
}


// efecto de la caida de  las burbujas
public void falling(){

    
    // 1. setRandom Location and word 
    
 Thread tf = new Thread(new Runnable() {
    
@Override
public void run() {
    try{
      //  int speed = 600;
       while (status && nextWord<wUser.length) {   
           
          
            int randomW = generateRN(50 ,width);
            int randomH = generateRN(30,50);
            int randomWB=0;
            int randomHB=0;
        
            if(randomW !=randomWB && randomH != randomHB){

                randomWB = randomW;
                randomHB = randomH;
                addlbToFrame(wUser[nextWord],randomWB, randomH);
            }
            
           ArrayList<JLabel> lbdinamico = new ArrayList<>();
            
            lbdinamico.add(lb[nextWord]);   

            fallin_y(lbdinamico);
            Thread.sleep(8000);  
          

        if(nextWord<wordUsuarioC){
              nextWord++;
             
             
        }else     status = false;     
             
          
        }
                       
    }catch(Exception ae){
        System.out.println("error en falling() ");

    }
}
});
tf.start();         
    
      
}


void fallin_y( ArrayList <JLabel> lbJLabels){

 Thread tf = new Thread(new Runnable() {

@Override
public void run() {
    try{
       
     //  agregarMouseListener(lbJLabels); 
       while (status) {                 
          
          if(speed <200){
              speed = 700;
          }
          
           for (JLabel lbJLabels : lbJLabels) {
               
               
                if(lbJLabels.getLocation().y >= height){      
                     lbJLabels.setLocation(generateRN(50,width) ,50);
                     scoreTotal -=10;
                     scoreFill();
                }else
                   lbJLabels.setLocation((lbJLabels.getLocation().x),lbJLabels.getLocation().y+40);
                
          }           
             Thread.sleep(speed);
             speed -=2;
        }
                 
    }catch(Exception ae){
        ae.printStackTrace();
        System.out.println("error en caida vertical");

    }
}
});
tf.start();
}

/** No usamos Click
    // Método para agregar MouseListener a cada JLabel en el array
 public void agregarMouseListener(ArrayList <JLabel> labels) {
        
        for (JLabel label : labels) {
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Haz hecho clic en " + label.getText());
                    
                    scoreFill();
                    // Aquí puedes realizar cualquier acción que desees al hacer clic en el JLabel
                }
            });
        }
    }
*/


// puntaje Barra
    
public void scoreFill() {
   
    barra.setForeground(Color.black);
    barra.setString(scoreTotal+" puntos");
    barra.setValue(scoreTotal);   
   
}    
    

// validar si corresponde las palabra a la verdadera

  public boolean existWuser(String palabraBuscar) {
  
      // Recorrer el arreglo y verificar si la palabra está presente
        for (int i=0; i<wUser.length;i++) {
          //  System.out.print(palabra+" ");
            if (wUser[i].equals(palabraBuscar)) {
                return true; // Se encontró la palabra
            }
        }
        return false; // No se encontró la palabra
    }
  
  
  public String samevalue(String fword) {
  
      // Recorrer el arreglo y verificar si la palabra está presente
        for (int i=0; i<wUserSpanish.length;i++) {
          //  System.out.print(palabra+" ");
            if (wUserSpanish[i].equals(fword)) {
                return wUser[i]; // Se encontró la palabra
            }
        }
        return "hola"; // No se encontró la palabra
    }
  
  public boolean existWspanish(String fword){
      
      for(String x : wUserSpanish){
          if(x.equalsIgnoreCase(fword)) return true;
      }
      
      return false;
  }

 
 
 public void message_score(){
    
    int scoreProm = (450*wordUsuarioC)/2;
    String imgPath = scoreTotal > scoreProm ? "/img/MF_450x252.png" : "/Img/ME_450x251.png";
   
    
    JPanel panel = new JPanel(new BorderLayout());    
    ImageIcon icon = new ImageIcon(ModoClasico.class.getResource(imgPath));
    JLabel imageLabel = new JLabel(icon);
    panel.add(imageLabel, BorderLayout.CENTER);
    
    JLabel textLabel = new JLabel("puntaje Total : "+scoreTotal);
    textLabel.setHorizontalAlignment(SwingConstants.CENTER);
    
    panel.add(textLabel, BorderLayout.SOUTH);


   JOptionPane.showMessageDialog(null, panel, "Score Total :) ", JOptionPane.DEFAULT_OPTION);
 
   
}
 
public void openMenu(){
     
    this.dispose();
    MenuMain menucall = new MenuMain();
    menucall.setVisible(true);
 }
 

 public void play(){
     
    status = true;
     falling();
     scoreFill();
 }
 
    
public ArrayList<JLabel> getLbComponent(){
    
    ArrayList<JLabel> compJlb = new ArrayList<>();
    Component[] components = this.getContentPane().getComponents();
    
     // 1. get Jlabel first
    for (Component i : components) {
        
        try {
             JLabel label = new JLabel();
             label = (JLabel)i;      
             if(!label.getAccessibleContext().getAccessibleName().equals("")){
                 compJlb.add((JLabel) i);
             }
             
        } catch (Exception e) {
          //  e.printStackTrace();
        //    System.out.println("no es un JLabel "+i.toString());      
        }
    }
    return compJlb;
}

  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txf_escribir = new javax.swing.JTextField();
        MensajeError = new javax.swing.JLabel();
        btniniciar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        bgProgrsbar = new javax.swing.JPanel();
        JLcorazon = new javax.swing.JLabel();
        barra = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txf_escribir.setEditable(false);
        txf_escribir.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        txf_escribir.setPreferredSize(new java.awt.Dimension(465, 71));
        txf_escribir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txf_escribirKeyReleased(evt);
            }
        });

        btniniciar.setForeground(new java.awt.Color(46, 27, 91));
        btniniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/botonM_60x141.png"))); // NOI18N
        btniniciar.setText("INICIAR");
        btniniciar.setBorderPainted(false);
        btniniciar.setContentAreaFilled(false);
        btniniciar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btniniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btniniciarActionPerformed(evt);
            }
        });

        btnsalir.setForeground(new java.awt.Color(46, 27, 91));
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/botonS_60x142.png"))); // NOI18N
        btnsalir.setText("SALIR");
        btnsalir.setBorderPainted(false);
        btnsalir.setContentAreaFilled(false);
        btnsalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        bgProgrsbar.setOpaque(false);
        bgProgrsbar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JLcorazon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/corazon50x50.png"))); // NOI18N
        bgProgrsbar.add(JLcorazon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 60, 76));

        barra.setBackground(new java.awt.Color(255, 255, 255));
        barra.setForeground(new java.awt.Color(255, 255, 255));
        barra.setMaximum(80);
        barra.setValue(80);
        barra.setName(""); // NOI18N
        barra.setString("");
        barra.setStringPainted(true);
        barra.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                barraStateChanged(evt);
            }
        });
        bgProgrsbar.add(barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 401, 44));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bgProgrsbar, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(329, 329, 329)
                .addComponent(btniniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MensajeError, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txf_escribir, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bgProgrsbar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 347, Short.MAX_VALUE)
                .addComponent(txf_escribir, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btniniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MensajeError, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btniniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniniciarActionPerformed
 
       txf_escribir.setEditable(true);
       MusicPlayer.playMusic("/Music/SonidoBoton.wav");
               
       play(); 
       btniniciar.setVisible(false);
 
    }//GEN-LAST:event_btniniciarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:

      openMenu();

    }//GEN-LAST:event_btnsalirActionPerformed

    private void barraStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_barraStateChanged
    
        if(barra.getValue() <= 0){
            status = false;
            message_score();
            openMenu();
          
           
        }
   
    }//GEN-LAST:event_barraStateChanged

    
    private void txf_escribirKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txf_escribirKeyReleased
       
        
        if(evt.getKeyChar() == KeyEvent.VK_ENTER){
            
            MusicPlayer.playMusic("/Music/SonidoBoton.wav");
            int moreSpeed = 40;
            MensajeError.setText("");
            
            
         String wordtxf = txf_escribir.getText();
         boolean existeW = existWspanish(wordtxf);
         
         
        if(existeW){
             
            for ( JLabel lb : getLbComponent()) {
                 
                 boolean existlb = existWuser(lb.getText());
                 boolean samelbAndW = lb.getText().equals(samevalue(wordtxf));
                
                if(samelbAndW && existlb){
                   
                    fondo.remove(lb);
                    fondo.revalidate(); // Revalidar el JPanel
                    fondo.repaint(); // Repintar el JPanel
                    speed -= 25;
                    correctWordsC ++;
                }else{
                    MensajeError.setText("¡Oh , no! , esa no es  la palabra");
                    scoreTotal -=100;
                    speed -= moreSpeed;
                    }
            }
            
        }else{
             
            MensajeError.setText("¡Oh , no! , esa no es  la palabra");
            scoreTotal -=50;
            speed -= moreSpeed;
        }
 
        if(correctWordsC == wordUsuarioC){
            message_score();
            openMenu();
        }
        
        txf_escribir.setText("");
        speed -= moreSpeed;
        scoreFill();
                
    }// fin del evento
             
    }//GEN-LAST:event_txf_escribirKeyReleased

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
            java.util.logging.Logger.getLogger(ModoReto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModoReto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModoReto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModoReto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModoReto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLcorazon;
    private javax.swing.JLabel MensajeError;
    private javax.swing.JProgressBar barra;
    private javax.swing.JPanel bgProgrsbar;
    private javax.swing.JButton btniniciar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JTextField txf_escribir;
    // End of variables declaration//GEN-END:variables

    class FondoPanel extends JPanel{
        
        private Image imagen;
        
        public void paint (Graphics g){
            imagen = new ImageIcon(getClass().getResource("/Img/ModoReto1400x800.png")).getImage();
            g.drawImage(imagen, 0, 0, this.getWidth(), this.getHeight(), this);
            setOpaque(false);
            super.paint(g);
                        
        }
        


}

}
