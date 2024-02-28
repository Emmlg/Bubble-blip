/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControlReadF;
import Controlador.ControllEnglishVoice;
import Tipografias.Fuentes;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import jdk.nashorn.internal.ir.BreakNode;

/**
 *
 * @author yired
 */
public class ModoClasico extends javax.swing.JFrame {


    //fuentes
    Fuentes tipoFuente;
   
   //fondo frame
   FondoPanel fondo = new FondoPanel();
   
    ArrayList <Component> compJlb ;
    ControllEnglishVoice speak;
    StartAddWord wordStart;
    ControlReadF rdF;
    public static String[] wUser;
    boolean status;
    int nextWord;
    int width ; 
    int height;
    int score;
    int wordUsuarioC;
   
  
public ModoClasico() {
        
    //fondo frame
    this.setContentPane(fondo);
    initComponents();

    //Fuentes  diseño
    tipoFuente = new Fuentes();
    addFuentesComponent();

    width = this.getWidth()-200;
    height = this.getHeight()-400;
    status = true;
  //  wUser = new String[]{"speak","read","snow","car","believe"}; //palabras del usuario
    
    //wUser = wordStart.wEnglsih();
    for (String x : wUser) {
        System.out.println(x);
    }
    rdF = new ControlReadF();
    speak = new ControllEnglishVoice();
    nextWord =0;
    score =0;
    compJlb  = new ArrayList<>();
    wordUsuarioC = 0;
    wordUsuarioC = wUser.length;  

    getLbComponent();
       
    }
    
// metodos a usar
    
    public void addFuentesComponent(){

        btnsalir.setFont(tipoFuente.fuente(tipoFuente.NINE, 0, 40));
        btniniciar.setFont(tipoFuente.fuente(tipoFuente.NINE, 0, 40));
        //fuentes burbujas
        img1.setFont(tipoFuente.fuente(tipoFuente.CHERRY, 0, 18));
        img2.setFont(tipoFuente.fuente(tipoFuente.CHERRY, 0, 18));
        img3.setFont(tipoFuente.fuente(tipoFuente.CHERRY, 0, 18));
        img4.setFont(tipoFuente.fuente(tipoFuente.CHERRY, 0, 18));
        img5.setFont(tipoFuente.fuente(tipoFuente.CHERRY, 0, 18));
        img6.setFont(tipoFuente.fuente(tipoFuente.CHERRY, 0, 18));
    
    }
    
  // generar numeros aleatorios para las burbujas
    
public int  generateRN(int min , int max){

   int range = max - min + 1;
   
   return (int)(Math.random() * range) + min;
}

// obtener los componentes para extaert los lb

public void getLbComponent(){
    
    Component[] components = this.getContentPane().getComponents();
    
     // 1. get Jlabel first
    for (Component i : components) {
        
        try {
             JLabel label = new JLabel();
             label = (JLabel)i;      
             if(!label.getAccessibleContext().getAccessibleName().equals("")){
                 compJlb.add(i);
             }
             
        } catch (Exception e) {
          //  e.printStackTrace();
        //    System.out.println("no es un JLabel "+i.toString());
        }
    }
    
}

// mezclar las palbras y agregarlo a los lb

public void namelb(ArrayList ww){
     
// Shuffle the array
Collections.shuffle(Arrays.asList(ww));

 img1.setText((String) ww.get(0));
 img2.setText(ww.get(1).toString());
 img3.setText(ww.get(2).toString());
 img4.setText(ww.get(3).toString());
 img5.setText(ww.get(4).toString());
 img6.setText(ww.get(5).toString());
/*
 for (Object string : ww) {
     System.out.print("namelb :"+string.toString()+" ");
 }*/

}

// efecto de la caida de  las burbujas
public void falling(){

     // 2. setRandom Location first 
  
for (Component x : compJlb) {

        int randomW = generateRN(50 ,width);
        int randomH = generateRN(30,height);
        int randomWB=0;
        int randomHB=0;
          if(randomW !=randomWB && randomH != randomHB){
              
            randomWB = randomW;
            randomHB = randomH;
            x.setLocation(randomWB,randomH);
          }
}      
        
    // make falling effect in Y position 
             
    fallin_y(compJlb);// arreglo de lb
      
}


void fallin_y(ArrayList<Component> lbC ){

  Thread tf = new Thread(new Runnable() {
@Override
public void run() {
    try{
       while (status) {                 
           
           for (Component lb :lbC){

                if(lb.getLocation().y >= height){      
                     lb.setLocation(generateRN(50,width) ,90); 
                }else
                    lb.setLocation((lb.getLocation().x),lb.getLocation().y+40);
            }
             Thread.sleep(550);   
        }
                 
    }catch(Exception ae){
        System.out.println("error en caida vertical");

    }
}
});
tf.start();
}
  
    // puntaje Barra
   
    public void fill() {

Thread t = new Thread(new Runnable() {
@Override
public void run() {
         try{
            int counter = 453;// para iniciar con 450 al mostrar al usuario
            
            while(counter>=0 && status) {
                
                barra.setString(counter+" puntos");
                barra.setValue(counter);  
                counter -=3;
                Thread.sleep(50);
                 
            }
        }catch(Exception ae){
            
            ae.printStackTrace();
            System.out.println("error en progressBar");
        }
}
});
    t.start(); 		
}

    // score del juego
public int ScoreTotal(){
     
     score += barra.getValue();
     
     return  (int) score;
 }


// validar si corresponde las palabra a la verdadera

 public boolean isameWord(String s){
     
     return s.equals(wUser[nextWord]);
 }

 // inicio del juego , *modificar mejor implementacion para iniciar el juego
 
 public void play(){
     
    status = true;
     //1.- obtener las palabras 
     String w[] = wUser;
     ArrayList<String> wpartida= new ArrayList<String>();


     wpartida = rdF.similarW(w[nextWord],6);// obtener las palabras aleatorias
     namelb(wpartida); // agregarselo a los lb

     falling();
     fill();
     speak.sayWordKevin(w[nextWord]);

 }
 
 // continuar con la siguiente palabra ,* modificar el nombre
 
 public void playAgain(){
     
    status = false;
    System.out.println("puntaje "+nextWord+" :"+ScoreTotal());
    nextWord ++; 
    if(nextWord< wUser.length){
        play();
    } 
 }


public void message_sadHappy(){
    
    int scorre = barra.getValue();
    String imgPath = scorre >150 ? "/img/sonreir1.png" : "/Img/sad.png";
    String frase = scorre > 150 ? "¡vamos vamos!": "¡Si se puede!";
    
    JPanel panel = new JPanel(new BorderLayout());    
    ImageIcon icon = new ImageIcon(ModoClasico.class.getResource(imgPath));
    JLabel imageLabel = new JLabel(icon);
    panel.add(imageLabel, BorderLayout.CENTER);
    
    JLabel textLabel = new JLabel(frase+" puntaje : "+scorre);
    textLabel.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(textLabel, BorderLayout.SOUTH);

   JOptionPane.showMessageDialog(null, panel, "Score", JOptionPane.DEFAULT_OPTION);
   
}
public void message_score(){
    
    int scorre = score;
    String imgPath = scorre > 450 ? "/img/MF_450x252.png" : "/Img/ME_450x251.png";
   
    
    JPanel panel = new JPanel(new BorderLayout());    
    ImageIcon icon = new ImageIcon(ModoClasico.class.getResource(imgPath));
    JLabel imageLabel = new JLabel(icon);
    panel.add(imageLabel, BorderLayout.CENTER);
    
    JLabel textLabel = new JLabel("puntaje Total : "+scorre);
    textLabel.setHorizontalAlignment(SwingConstants.CENTER);
    
    panel.add(textLabel, BorderLayout.SOUTH);


   JOptionPane.showMessageDialog(null, panel, "Score :) ", JOptionPane.DEFAULT_OPTION);
 
   
}

 public void openMenu(){
     
    this.dispose();
    MenuMain menucall = new MenuMain();
    menucall.setVisible(true);
 }
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btniniciar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        btnsonido = new javax.swing.JButton();
        img1 = new javax.swing.JLabel();
        img2 = new javax.swing.JLabel();
        img3 = new javax.swing.JLabel();
        img4 = new javax.swing.JLabel();
        img5 = new javax.swing.JLabel();
        img6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        LCorazon = new javax.swing.JLabel();
        barra = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btniniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/botonMY_60x142.png"))); // NOI18N
        btniniciar.setText("INICIAR");
        btniniciar.setBorderPainted(false);
        btniniciar.setContentAreaFilled(false);
        btniniciar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btniniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btniniciarActionPerformed(evt);
            }
        });

        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/botonSalirY_60x142.png"))); // NOI18N
        btnsalir.setText("SALIR");
        btnsalir.setBorderPainted(false);
        btnsalir.setContentAreaFilled(false);
        btnsalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        btnsonido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/botonsonido2.png"))); // NOI18N
        btnsonido.setBorderPainted(false);
        btnsonido.setContentAreaFilled(false);
        btnsonido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsonidoMouseClicked(evt);
            }
        });

        img1.setForeground(new java.awt.Color(255, 255, 255));
        img1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Bubble1.png"))); // NOI18N
        img1.setText("Welcome!");
        img1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        img1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                img1MouseClicked(evt);
            }
        });

        img2.setBackground(new java.awt.Color(255, 255, 255));
        img2.setForeground(new java.awt.Color(255, 255, 255));
        img2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Bubble2.png"))); // NOI18N
        img2.setText("Are you ready?");
        img2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        img2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                img2MouseClicked(evt);
            }
        });

        img3.setForeground(new java.awt.Color(255, 255, 255));
        img3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Bubble1.png"))); // NOI18N
        img3.setText("Welcome!");
        img3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        img3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                img3MouseClicked(evt);
            }
        });

        img4.setForeground(new java.awt.Color(255, 255, 255));
        img4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Bubble2.png"))); // NOI18N
        img4.setText("Are you ready?");
        img4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        img4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                img4MouseClicked(evt);
            }
        });

        img5.setForeground(new java.awt.Color(255, 255, 255));
        img5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Bubble1.png"))); // NOI18N
        img5.setText("Welcome!");
        img5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        img5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                img5MouseClicked(evt);
            }
        });

        img6.setForeground(new java.awt.Color(255, 255, 255));
        img6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Bubble2.png"))); // NOI18N
        img6.setText("Are you ready?");
        img6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        img6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                img6MouseClicked(evt);
            }
        });

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LCorazon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/corazon50x50.png"))); // NOI18N
        jPanel1.add(LCorazon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 60));

        barra.setBackground(new java.awt.Color(102, 153, 255));
        barra.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        barra.setForeground(new java.awt.Color(255, 255, 255));
        barra.setMaximum(450);
        barra.setValue(450);
        barra.setString("450\n");
        barra.setStringPainted(true);
        barra.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                barraStateChanged(evt);
            }
        });
        jPanel1.add(barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 299, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(img3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(img4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addComponent(img5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(240, 240, 240)
                .addComponent(img1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200)
                .addComponent(img2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnsonido, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(50, 50, 50))
                            .addComponent(img6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(btniniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(580, 580, 580))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsonido, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(img4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(img5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(img1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(img2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(img6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btniniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btniniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniniciarActionPerformed

       MusicPlayer.playMusic("/Music/SonidoBoton.wav"); 
       play(); 
       btniniciar.setVisible(false);
       
    }//GEN-LAST:event_btniniciarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        
        MusicPlayer.playMusic("/Music/SonidoBoton.wav");
        openMenu();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void img3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img3MouseClicked
        
        MusicPlayer.playMusic("/Music/sonidoBurbuja.wav");
        boolean samew = isameWord(img3.getText());
        
        if(samew && nextWord < wordUsuarioC ){
          status =false;
          message_sadHappy();
          playAgain(); 
        }
        if( samew && nextWord == wordUsuarioC ){

            message_score();
            openMenu();
        }
        
    }//GEN-LAST:event_img3MouseClicked

    private void img4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img4MouseClicked
        
        MusicPlayer.playMusic("/Music/sonidoBurbuja.wav");
        boolean samew = isameWord(img4.getText()) ;
        if( samew && nextWord < wordUsuarioC ){
            
          status =false;
          message_sadHappy();
          playAgain(); 
        }
        if( samew && nextWord == wordUsuarioC ){

         message_score();
         openMenu();
        }
        
    }//GEN-LAST:event_img4MouseClicked

    private void img5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img5MouseClicked
       
        MusicPlayer.playMusic("/Music/sonidoBurbuja.wav");
        boolean samew = isameWord(img5.getText());
        if( samew && nextWord < wordUsuarioC){
            
          status =false;
          message_sadHappy();
          playAgain(); 
        }
        if( samew && nextWord == wordUsuarioC ){

             message_score();
             openMenu();
        }
        
    }//GEN-LAST:event_img5MouseClicked

    private void img1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img1MouseClicked
        
        MusicPlayer.playMusic("/Music/sonidoBurbuja.wav");
        boolean samew = isameWord(img1.getText());
        if( samew && nextWord < wordUsuarioC){
            
          status =false;
          message_sadHappy();
          playAgain(); 

        }
        if( samew && nextWord == wordUsuarioC ){

             message_score();
             openMenu();
        } 
    }//GEN-LAST:event_img1MouseClicked

    private void img2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img2MouseClicked
       
        MusicPlayer.playMusic("/Music/sonidoBurbuja.wav");
        boolean samew = isameWord(img2.getText());
        
        if(samew && nextWord < wordUsuarioC){
            
          status =false;
          message_sadHappy();
          playAgain();
        }
        if( samew && nextWord == wordUsuarioC ){

            message_score();
            openMenu();
        }    
    }//GEN-LAST:event_img2MouseClicked

    private void img6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img6MouseClicked

        MusicPlayer.playMusic("/Music/sonidoBurbuja.wav");
        boolean samew = isameWord(img6.getText());
        
        if(samew && nextWord < wordUsuarioC){
            
            status =false;
            message_sadHappy();
            playAgain(); 
        }
        if( samew && nextWord == wordUsuarioC ){
                   
            message_score();
            openMenu();
        }
    }//GEN-LAST:event_img6MouseClicked

    private void barraStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_barraStateChanged
        
       if(barra.getValue() <= 0){
            status = false;
            message_sadHappy();
            playAgain();  
           
        }
       if(barra.getValue() <=0 && nextWord==wordUsuarioC){
           
              message_score();
              openMenu();
       }
        
       
    }//GEN-LAST:event_barraStateChanged

    private void btnsonidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsonidoMouseClicked
   
     speak.sayWordKevin(wUser[nextWord]);
    }//GEN-LAST:event_btnsonidoMouseClicked

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
    private javax.swing.JLabel LCorazon;
    private javax.swing.JProgressBar barra;
    private javax.swing.JButton btniniciar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton btnsonido;
    private javax.swing.JLabel img1;
    private javax.swing.JLabel img2;
    private javax.swing.JLabel img3;
    private javax.swing.JLabel img4;
    private javax.swing.JLabel img5;
    private javax.swing.JLabel img6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    //fondo frame
    class FondoPanel extends JPanel{
        
        private Image imagen;
        
        public void paint (Graphics g){
            imagen = new ImageIcon(getClass().getResource("/Img/ModoClasico1400x1800.png")).getImage();
            g.drawImage(imagen, 0, 0, this.getWidth(), this.getHeight(), this);
            setOpaque(false);
            super.paint(g);
                        
        }
        
    }


}
