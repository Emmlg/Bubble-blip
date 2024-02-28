/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import Controlador.ControlReadF;
import Modelo.ReadFiles;
import java.util.ArrayList;

/**
 *
 * @author EMmanuel
 */
public class TestReadFile {
    public static void main(String[] args) {
     
        ControlReadF testRF = new ControlReadF();
        
         ArrayList<String> ls= new ArrayList<>();
     
      /*  for (String l : ls) {
            System.out.println(l);
        }*/
        
       for(int i=0;i <50;i++){
           
        ls = testRF.similarW("read",5);
        
            for (String string : ls) {
                 System.out.print(string+" ");
             }
           System.out.println("");
        }
        
        

    }    
}
