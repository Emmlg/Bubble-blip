/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ReadFiles;
import java.util.ArrayList;

/**
 *
 * @author EMmanuel
 */
public class ControlReadF {
    
    ReadFiles rf;

    public ControlReadF() {
    
    rf = new ReadFiles();
    
    }
    
    
    
    public ArrayList<String> similarW(String fineWord,int cantW){
    
        int randomNum;
        ArrayList<String> lsw =rf.lstSimilarW(fineWord);
        ArrayList<String> lsw1 = null ;
        
        for(int i = 1; i <cantW;i++){
            System.out.println(randomNum = (int)Math.random()*cantW);  
            
           // String f = lsw.get(0);
      //      System.out.println(f);
         //  lsw1.add(f);
          
            
        }
       
        
        
     return lsw ;
    }
    
    
    
    
}
