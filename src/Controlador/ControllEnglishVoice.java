/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.EnglishVoice;

/**
 *
 * @author EMmanuel
 */
public class ControllEnglishVoice {
    public EnglishVoice g;
   
    
    public void sdf(String word) throws InterruptedException{
        g.say2Times(word);
    }
    
    
 
    
    
    public static void main(String[] args) throws InterruptedException {
        
         EnglishVoice gh = new EnglishVoice();
         
         gh.sayword("hola");
         gh.say2Times("hola");
         
      
        
    }
    
     
    
}
