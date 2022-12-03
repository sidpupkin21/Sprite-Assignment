/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import app.Appuser;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sid
 */
public class UserTestingUnit {
    
    public UserTestingUnit() {
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
    public void tempTest(){
        assertEquals(1,1);
    }
    @Test
    public void getId(){
        Appuser appuser = new Appuser();
        Long id = 1L;
        appuser.setId(1L);
        Long getTest = appuser.getId();
        assertEquals(id, getTest);
    }
    
    @Test 
    public void setId(){
        Appuser appuser = new Appuser();
        Long id = 1L;
        appuser.setId(id);
        assertEquals(id, appuser.getId());
    }
    
    @Test
    public void getUsername(){
        Appuser appuser = new Appuser();
        appuser.setUsername("user1");
        String getTest = appuser.getUsername();
        assertEquals("user1", getTest);
    }
    @Test
    public void setUsername(){
        Appuser appuser = new Appuser();
        appuser.setUsername("user1");
        assertEquals("user1", appuser.getUsername());
    }
    
    @Test 
    public void getGroupname(){
        Appuser appuser = new Appuser();
        appuser.setGroupname("group1");
        String getTest = appuser.getGroupname();
        assertEquals("group1", getTest);
    }
    @Test 
    public void setGroupname(){
        Appuser appuser = new Appuser();
        appuser.setGroupname("group1");
        assertEquals("group1", appuser.getGroupname());
    }
}