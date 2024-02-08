/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tipografias;

import java.awt.Font;
import java.io.InputStream;

/**
 *
 * @author abiga
 */
public class Fuentes {
    
    private Font font = null;

    public String CHERRY = "CherryBombOne-Regular.ttf";
    public String NINE = "nine0.ttf";
    public String CHAUR ="ChauPhilomeneOne-Regular.ttf";
    public String CHAUI ="ChauPhilomeneOne-Italic.ttf";

    /* Font.PLAIN = 0 , Font.BOLD = 1 , Font.ITALIC = 2
 * tamanio = float
 */
    
     public Font fuente( String fontName, int estilo, float tamaño)
    {
         try {
            //Se carga la fuente
            InputStream is =  getClass().getResourceAsStream(fontName);
            font = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (Exception ex) {
            //Si existe un error se carga fuente por defecto ARIAL
            System.err.println(fontName + " No se cargo la fuente");
            font = new Font("Arial", Font.PLAIN, 14);            
        }
        Font tfont = font.deriveFont(estilo, tamaño);
        return tfont;
    }
}
