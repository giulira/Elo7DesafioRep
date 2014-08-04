/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.elo7.aplicaTaxa.operacoesTipoC;

import java.math.BigDecimal;

/**
 *
 * @author Giu
 */
public class AplicaTaxaMaiorQueTrintaDias implements AplicaTaxaTipoC{

    @Override
    public BigDecimal aplicarTaxa(BigDecimal valor) {
        BigDecimal resultado = BigDecimal.ZERO;
        resultado = valor.multiply(new BigDecimal("1.2")).divide(new BigDecimal("100"));
        return resultado.add(valor);                
    }

   
    
}
