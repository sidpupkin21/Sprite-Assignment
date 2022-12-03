/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import cst8218.moha0901.entity.Sprite;
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
public class SpriteTestingUnit {
    
    public SpriteTestingUnit() {
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
    public void getId(){
        Sprite sprite = new Sprite();
        Long test = 1L;
        sprite.setId(test);
        Long test2 = sprite.getId();
        assertEquals(test, test2);
    }
    
    @Test
    public void setId(){
        Sprite sprite = new Sprite();
        Long test = 1L;
        sprite.setId(test);
        assertEquals(sprite.getId(), test);
    }
    
    /*panelWidth & panelHeight getter and setter testing cases*/
    @Test 
    public void getPanelWidth(){
        Sprite sprite = new Sprite();
        assertEquals(0, sprite.getPanelWidth());
    }
    
    @Test 
    public void setPanelWidth(){
        Sprite sprite = new Sprite();
        sprite.setPanelWidth(1);
        assertEquals(1,sprite.getPanelWidth());
    }
    @Test
    public void getPanelHeight(){
        Sprite sprite = new Sprite();
        assertEquals(0, sprite.getPanelHeight());
        
    }
    @Test
    public void setPanelHeight(){
        Sprite sprite = new Sprite();
        sprite.setPanelHeight(1);
        assertEquals(1, sprite.getPanelHeight());
    }
    
    /*GetX,SetX, GetY,SetY*/
    @Test
    public void getX(){
        Sprite sprite = new Sprite();
        assertEquals(0,sprite.getX());
    }
    
    @Test 
    public void setX(){
        Sprite sprite = new Sprite();
        sprite.setX(1);
        assertEquals(1, sprite.getX());
    }
    @Test
    public void getY(){
        Sprite sprite = new Sprite();
        assertEquals(0,sprite.getY());
    }
    
    @Test 
    public void setY(){
        Sprite sprite = new Sprite();
        sprite.setY(1);
        assertEquals(1, sprite.getY());
    }
    /*getDx setDx getDy setDy*/
    @Test
    public void getDx(){
        Sprite sprite = new Sprite();
        assertEquals(0,sprite.getDx());
    }
    @Test
    public void setDx(){
        Sprite sprite = new Sprite();
        sprite.setDx(1);
        assertEquals(1, sprite.getDx());
    }
    @Test
    public void getDy(){
        Sprite sprite = new Sprite();
        assertEquals(0, sprite.getDy());
    }
    @Test
    public void setDy(){
        Sprite sprite = new Sprite();
        sprite.setDy(1);
        assertEquals(1, sprite.getDy());
    }
   
}
