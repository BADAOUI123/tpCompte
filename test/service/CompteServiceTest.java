/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Compte;
import java.util.ArrayList;
import java.util.List;
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
public class CompteServiceTest {
    
//    CompteService instance = new CompteService();
//    List<Compte> comptes = new ArrayList();
// 
    public CompteServiceTest() {
        
//        comptes.add(instance.ouvrirCompte("EE1", 100));
//        comptes.add(instance.ouvrirCompte("EE2", 200));
//        comptes.add(instance.ouvrirCompte("EE3", 800));
//        comptes.add(instance.ouvrirCompte("EE4", 400));
//        comptes.add(instance.ouvrirCompte("EE5", 5000));

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
     * Test of ouvrirCompte method, of class CompteService.
     */
//    @Test
//    public void testOuvrirCompte() {
//        System.out.println("ouvrirCompte");
//        CompteService instance = new CompteService();
//        instance.ouvrirCompte("EE1", 100);
//        instance.ouvrirCompte("EE2", 200);
//        instance.ouvrirCompte("EE3", 300);
//
//    }
////    /**
////     * Test of fermerCompte method, of class CompteService.
////     */
    @Test
    public void testFermerCompte() {
        System.out.println("fermerCompte");
        String rib = "EE2";
        CompteService instance = new CompteService();
        int expResult = -1;
        int result = instance.fermerCompte(rib);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of crediter method, of class CompteService.
     */
    @Test
    public void testCrediter() {
        System.out.println("crediter");
        String rib = "EE1";
        double montantCredit = 80.0;
        CompteService instance = new CompteService();
        int expResult = 1;
        int result = instance.crediter(rib, montantCredit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of debiter method, of class CompteService.
     */
    @Test
    public void testDebiter() {
        System.out.println("debiter");
        String rib = "EE3";
        double montantDebit = 200.0;
        CompteService instance = new CompteService();
        int expResult = -3;
        int result = instance.debiter(rib, montantDebit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }
    
//     @Test
//    public void testTransferer() {
//        System.out.println("transferer");
//        Compte compteSource = comptes.get(4);
//        Compte compteDestination = comptes.get(2);
//        double montant = 500.0;
//        int expResult = 1;
//        int result = instance.transferer(compteSource, compteDestination, montant);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//
//    }

}
