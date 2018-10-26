/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc asus
 */
public class UserServiceTest {
    
    public UserServiceTest() {
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

    /**
     * Test of createUser method, of class UserService.
     */
//    @Test
//    public void testCreateUser() {
//        System.out.println("createUser");
//        String id = "User1";
//        String password = "User1";
//        UserService instance = new UserService();
//        User result = instance.createUser(id, password);
//        //assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        
//    }

    /**
     * Test of login method, of class UserService.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String id = "User1";
        String password = "User1";
        UserService instance = new UserService();
        int expResult = 1;
        int result = instance.login(id, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
