/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DatamuseQuery;
import Modelo.JSONParse;

/**
 *
 * @author EMmanuel
 */



/** @see 
 
    * probablemente ocurra erro de IndexOutOfBoundsException
     se debe a que no se inicializa correctamente la variable, corregir

    * Cosas por mejorar , por el tiempo
   mejorar los numeros aleatorios para evitar repetirse
   que el cantwUser < tamano de la listaw

 */

public class ControllDataAPI {
    
    DatamuseQuery requestWord;
    JSONParse jsonparse ;  
    private int max ;
    private int min = 1;     
    private int range ;
    
    
    
    public ControllDataAPI() {
        
        requestWord = new DatamuseQuery();
        jsonparse = new JSONParse();
    }
    
    public String[] APIprefixHintSuggestions(String wordF,int cantwUser){
   
       String[] lsw = jsonparse.parseWords(requestWord.prefixHintSuggestions(wordF));
       String[] lsword = new String[cantwUser];
       max = lsw.length; // la cantidad de la lista de palabras
       range = max - min + 1; // inicia en 1 porque la palbra original esta en 0
        
        int randomNum;
        lsword[0] =lsw[0];
         
        for (int i=1 ; i<cantwUser; i++) {
            randomNum = (int)(Math.random() * range) + min;
            lsword[i] =lsw[randomNum];
        }
  
    return lsword;
    }
    
    public String[] APIsoundsSimilar(String wordF,int cantwUser){

    String[] lsw = jsonparse.parseWords(requestWord.soundsSimilar(wordF));
       String[] lsword = new String[cantwUser];
       max = lsw.length; // la cantidad de la lista de palabras
       range = max - min + 1; // inicia en 1 porque la palbra original esta en 0
        
        int randomNum;
        lsword[0] =lsw[0];
         
        for (int i=1 ; i<cantwUser; i++) {
            randomNum = (int)(Math.random() * range)+ min ;
            lsword[i] =lsw[randomNum];
        }

    return lsword;
    
    }
    
    public String[] APIspeltSimilar(String wordF){

    return jsonparse.parseWords(requestWord.speltSimilar(wordF));
    }
    
    public String[] APIfindSimilar(String wordF,int cantwUser){
        
       String[] lsw = jsonparse.parseWords(requestWord.findSimilar(wordF));
       String[] lsword = new String[cantwUser];
       max = lsw.length; // la cantidad de la lista de palabras
       range = max - min + 1; // inicia en 1 porque la palbra original esta en 0
        
        int randomNum;
        lsword[0] =lsw[0];
         
        for (int i=1 ; i<cantwUser; i++) {
            randomNum = (int)(Math.random() * range) + min;
            lsword[i] =lsw[randomNum];
        }

    return lsword;
    }
    
    
    
}
