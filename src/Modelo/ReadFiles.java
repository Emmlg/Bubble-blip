/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author EMmanuel
 */
public class ReadFiles {
    
    private final String fileName = "Librerias/ListWords/wordlist_20200727.txt";
    String line;

public ArrayList<String> lstSimilarW(String fineWord){

    ArrayList <String> listW = new ArrayList<String>();
    
   try (
        BufferedReader reader = new BufferedReader(new FileReader(fileName))
        ) {    
       
      while ((line = reader.readLine()) != null ) {
        boolean status =line.startsWith(fineWord);
              
          if(status){
            listW.add(line);
       
          }
        
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
return listW;
}
    
}
