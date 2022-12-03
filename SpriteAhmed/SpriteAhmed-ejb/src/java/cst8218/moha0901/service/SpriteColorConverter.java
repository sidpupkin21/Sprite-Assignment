/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*************************************************************************************
* CST 8218_302
* Professor: Yamen Nasrallah 
* Author: Ahmed Mohamed
* ID: 041019389
* Last Edited 13/11/2022
* Description: This class is a custom converter for user input RGB values (R=0;G=0;B=255)
*              returns integer value  in format[0,0,255]
* Class: SpriteColorConverter{}
* Method: getAsObject(), getAsString()
* Reference: https://docs.oracle.com/javaee/7/tutorial/jsf-custom010.htm
*************************************************************************************/
package cst8218.moha0901.service;

import java.awt.Color;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author sid
 */
@FacesConverter("converts")
public class SpriteColorConverter  implements Converter {

    @Override
    public Object getAsObject(FacesContext facecontext, UIComponent uicomp, String string) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.]               
        Color colvalue= Color.decode("#"+string); 
        return colvalue;       
// return Color.decode("#"+string); 
        //return colvalue;
        
    }

    @Override
    public String getAsString(FacesContext facecontext, UIComponent uicomp, Object colorObject) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Color c =  (Color) colorObject;
        String converter = Integer.toHexString(c.getRGB()).substring(2);//tostring();
        //String.valueOf(color.getRGB());
        return converter;
    }
}
