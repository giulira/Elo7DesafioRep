/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.elo7.br.com.elo7.calculaTaxa.operacoesTipoA;

import br.com.elo7.Transferencia;
import br.com.elo7.aplicaTaxa.operacoesTipoA.AplicaTaxaTipoA;
import java.math.BigDecimal;

/**
 *
 * @author Giu
 */
public class CalculaTaxaOperacoesTipoA {
    
    public BigDecimal calculaTaxa(Transferencia transferencia){
        BigDecimal taxa = BigDecimal.ZERO;
        AplicaTaxaTipoA tipoA = new AplicaTaxaTipoA();                               
        taxa = tipoA.aplicarTaxa(transferencia.getValorTransferencia());  
        return taxa;
    }
         
}
