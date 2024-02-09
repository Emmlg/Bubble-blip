/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author EMmanuel
 */
public class VoiceClass {
    
  private final String DirAlanVoice = "com.sun.speech.freetts.en.us.cmu_time_awb.AlanVoiceDirectory";
  private final String vzNmeAlan =  "alan" ;
  
  private final String DirKevinVz = "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory";
  private final String vzNmeKevin =  "kevin16" ;
  
          
    public VoiceClass() {
               
    }
    

 private void sleepTime(int timeS){
     
    try {
        
       Thread.sleep(timeS); // 2 seconds * 1000 milliseconds

    } catch (InterruptedException e) {
        // Handle interruption exception if needed
        e.printStackTrace();
    } 
     
 }
    
    
public boolean speakW(String word){

    System.setProperty("freetts.voices",DirKevinVz);        
    VoiceManager manager =  VoiceManager.getInstance();
    Voice  voice = manager.getVoice(vzNmeKevin);

    voice.allocate();
 boolean status = voice.speak(word);
    voice.deallocate();
    
return status;
}



public  boolean  say2Times(String word) throws InterruptedException{
        
    System.setProperty("freetts.voices",DirKevinVz);        
    VoiceManager manager = VoiceManager.getInstance();
    Voice voice = manager.getVoice(vzNmeKevin);
    voice.allocate();
     
 boolean status = voice.speak(word);
    sleepTime(65);
    status = voice.speak(word);  
     
     voice.deallocate();
    return status;
    }






    
}
