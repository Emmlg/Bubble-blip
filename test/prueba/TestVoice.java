/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import Controlador.ControllEnglishVoice;

/**
 *
 * @author EMmanuel
 */
public class TestVoice {
    
    public static void main(String[] args) throws InterruptedException {
        
        ControllEnglishVoice testVoice =  new ControllEnglishVoice();
        
        System.out.println(testVoice.sayWordKevin("to talk"));
        System.out.println(testVoice.say2TimesKevin("to speak"));
        
        
    }
}
