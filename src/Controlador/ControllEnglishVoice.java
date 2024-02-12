/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.VoiceClass;




/**
 *
 * @author EMmanuel
 */
public class ControllEnglishVoice {

    VoiceClass voice ;
    
    public ControllEnglishVoice() {
        voice  = new VoiceClass();
        
    }
    
    public boolean sayWordKevin(String word) {
        
        
     return voice.speakWKevin(word);
        
    }
    public boolean say2TimesKevin(String word) throws InterruptedException {
        
     return voice.say2TimesKevin(word);
        
    }

    
     
    
}
