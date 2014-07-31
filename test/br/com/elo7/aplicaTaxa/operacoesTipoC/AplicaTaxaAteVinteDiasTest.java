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
public class AplicaTaxaAteVinteDiasTest {
    
    public AplicaTaxaAteVinteDiasTest() {
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
     * Test of aplicarTaxa method, of class AplicaTaxaAteVinteDias.
     */
    @Test
    public void testAplicarTaxa() {
        System.out.println("aplicarTaxa");
        BigDecimal valor = new BigDecimal("30");
        AplicaTaxaAteVinteDias instance = new AplicaTaxaAteVinteDias();
        BigDecimal expResult = new BigDecimal("31.62");
        BigDecimal result = instance.aplicarTaxa(valor);
        assertEquals(expResult, result);
        
    }
    
}
