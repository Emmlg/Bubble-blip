/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

/**
 *
 * @author EMmanuel
 */
public class ConnectionVoice {
    
  private  String packVoiceDirectory ;
  private String voicename;
  private VoiceManager manager;
  private Voice voice; 
          
          
          
    public ConnectionVoice() {
               
    }
    
    public ConnectionVoice(String voiceName,String PackVoiceD) {
        
        this.voicename = voiceName; 
        this.packVoiceDirectory = PackVoiceD;
        
        System.setProperty("freetts.voices",PackVoiceD);        
        manager = VoiceManager.getInstance();
        Voice voice = manager.getVoice(voiceName);
        
        
        
    }
    
    
  
  
  
  
public boolean validateSpeak(String word){

return voice.speak(word);

}
    
    
}
