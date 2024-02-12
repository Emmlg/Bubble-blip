/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import Controlador.ControllDataAPI;
import Modelo.DatamuseQuery;
import Modelo.JSONParse;

/**
 *
 * @author EMmanuel
 */
public class TestSimilarWords {
    
    public static void main(String[] args) {
     
     ControllDataAPI testSuggestW = new ControllDataAPI();
        
        String w = "car";
        String listw[] = testSuggestW.APIsoundsSimilar(w,5);
        String listw1[] = testSuggestW.APIspeltSimilar(w);
        String listw2[] = testSuggestW.APIfindSimilar(w,5);
        String listw3[] = testSuggestW.APIprefixHintSuggestions(w,4);
        
        for (String string : listw) {
            System.out.println(string);
        }
        
        
        
        
    }  
    
}
