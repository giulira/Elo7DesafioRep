/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.elo7.aplicaTaxa.operacoesTipoC;

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
public class AplicaTaxaAteQuinzeDiasTest {
    
    public AplicaTaxaAteQuinzeDiasTest() {
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
     * Test of aplicarTaxa method, of class AplicaTaxaAteQuinzeDias.
     */
    @Test
    public void testAplicarTaxa() {
        System.out.println("aplicarTaxa");
        BigDecimal valor = new BigDecimal("30");
        AplicaTaxaAteQuinzeDias instance = new AplicaTaxaAteQuinzeDias();
        BigDecimal expResult = new BigDecimal("32.01");
        BigDecimal result = instance.aplicarTaxa(valor);
        assertEquals(expResult, result);
        
    }
    
}
