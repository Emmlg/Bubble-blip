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
    
        ArrayList<String> lsw = new ArrayList<String>();
        lsw = rf.lstSimilarW(fineWord);
        ArrayList<String> lsw1 = new ArrayList<String>(); 
        
       /*for (String string : lsw) {
            System.out.println("ls "+string);
        }*/
        
        int max = lsw.size() - 1; // la cantidad de la lista de palabras
        int min = 1; // inicia en 1 porque la palbra original esta en 0
        int range = max - min + 1;
        int randomNum;

        lsw1.add(lsw.get(0));
        for(int i = 1; i <cantW;i++){ // agragamos la cantidad que pida el usuario
            
            randomNum = (int)(Math.random() * range) + min;
            //   System.out.println("random "+randomNum);
            lsw1.add( lsw.get(randomNum) ); 
        }
 
     return lsw1 ;
    }
    
    
    
    
    
}
