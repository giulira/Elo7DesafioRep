/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.elo7.aplicaTaxa.operacoesTipoB;

import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Giu
 */
public class AplicaTaxaDemaisDiasTest {
    
    public AplicaTaxaDemaisDiasTest() {
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
     * Test of aplicarTaxa method, of class AplicaTaxaDemaisDias.
     */
    @Test
    public void testAplicarTaxa() {
        System.out.println("aplicarTaxa");
        BigDecimal valor = new BigDecimal("30");
        AplicaTaxaDemaisDias instance = new AplicaTaxaDemaisDias();
        BigDecimal expResult = new BigDecimal("38");
        BigDecimal result = instance.aplicarTaxa(valor);
        assertEquals(expResult, result);
        
    }
    
}
