/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import cst8218.moha0901.service.SpriteColorConverter;
import java.awt.Color;
import javax.faces.component.UIColumn;
import javax.faces.context.FacesContextWrapper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sid
 */
public class ColorTestingUnit {
    
    public ColorTestingUnit() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
        
    @Test
    public void testColorConverterObject(){
        SpriteColorConverter converter = new SpriteColorConverter();
        Color refColors = new Color(1,2,3);
        Color colors = (Color) converter.getAsObject(new FacesContextWrapper() {}, new UIColumn(), "010203");
        assertEquals(refColors,colors);
    }
    
    @Test
    public void testColorConverterString(){
        SpriteColorConverter converter = new SpriteColorConverter();
        Color refColors = new  Color(1,2,3);
        String colObj;
        colObj = converter.getAsString(new FacesContextWrapper() {}, new UIColumn(),refColors);
        assertEquals(colObj, "010203");
    }
   
}
