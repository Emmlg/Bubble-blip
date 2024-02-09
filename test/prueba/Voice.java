/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import com.sun.speech.freetts.VoiceManager;

/**
 *
 * @author EMmanuel
 */
public class Voice {
    
    public static void main(String[] args) {
        

        System.setProperty("freetts.voices",
               "com.sun.speech.freetts.en.us.cmu_time_awb.AlanVoiceDirectory");
        
     //   System.setProperty("freetts.voices",
      //         "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
//        
    VoiceManager manager = VoiceManager.getInstance();
    
    com.sun.speech.freetts.Voice voice = manager.getVoice("alan");
   //    com.sun.speech.freetts.Voice voice = manager.getVoice("kevin16");

    com.sun.speech.freetts.Voice []voicelist = VoiceManager.getInstance().getVoices();
     
        for(int i=0;i<voicelist.length;i++){
        
            System.out.println("#voice "+voicelist[i].getName());
        }
     
        if(voice != null){
            
            voice.allocate();
            System.out.println("Voice Rate:  "+voice.getRate());
            System.out.println("Voice Pitch:  "+voice.getPitch());
            System.out.println("Voice Volume:  "+voice.getVolume());
           boolean status = voice.speak(
           "hello"
           );
            System.out.println("status : "+status);
            voice.deallocate(); 
            
        }else{
            System.out.println("error of getting voice");
        }
 
 
    
        }
    
}
