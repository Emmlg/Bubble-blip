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
public class ControllDataAPI {
    
    DatamuseQuery requestWord;
    JSONParse jsonparse ;  
     
        
    public ControllDataAPI() {
        
        requestWord = new DatamuseQuery();
        jsonparse = new JSONParse();
    }
    
    public String[] APIprefixHintSuggestions(String wordF){
   
    return jsonparse.parseWords(requestWord.prefixHintSuggestions(wordF));
    }
    
    public String[] APIsoundsSimilar(String wordF){

  
    return jsonparse.parseWords(requestWord.soundsSimilar(wordF));
    }
    
    public String[] APIspeltSimilar(String wordF){

    return jsonparse.parseWords(requestWord.speltSimilar(wordF));
    }
    
    public String[] APIfindSimilar(String wordF){
  
    return jsonparse.parseWords(requestWord.findSimilar(wordF));
    }
    
    
    
}
