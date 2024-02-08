
package Modelo;

import com.sun.speech.freetts.Voice;
import java.util.concurrent.TimeUnit;
import jdk.nashorn.internal.parser.TokenType;

/**
 *
 * @author EMmanuel
 */
public class EnglishVoice {
    
//    private String []wordlist;
 //   private String word;
    private final String voicename = "alan";
    private final String packDirectory = "com.sun.speech.freetts.en.us.cmu_time_awb.AlanVoiceDirectory";
    private ConnectionVoice talk;
    Voice voice;

    
    
  /*  public EnglishVoice(String word) {
    
        this.word = word;
    
    }

    public EnglishVoice(String word,String []wordlist) {
    
        this.word = word;
        this.wordlist = wordlist;
    
    }*/

    public EnglishVoice() {
        
    }
    
  
    public  void  say2Times(String word) throws InterruptedException{
        
     talk = new ConnectionVoice(voicename,packDirectory);
     voice.allocate();
     
     talk.validateSpeak(word);
     TimeUnit.MINUTES.sleep(2);
     talk.validateSpeak(word);  
     
     voice.deallocate();
                
    }
    public void  sayword(String word) throws InterruptedException{
        
     talk = new ConnectionVoice(voicename,packDirectory);
     voice.allocate();
     
     talk.validateSpeak(word);  
     
     voice.deallocate();
                
    }
    
}
