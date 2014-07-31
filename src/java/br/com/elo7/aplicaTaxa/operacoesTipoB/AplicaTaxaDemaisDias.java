/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.elo7.aplicaTaxa.operacoesTipoB;

import java.math.BigDecimal;

/**
 *
 * @author Giu
 */
public class AplicaTaxaDemaisDias implements AplicaTaxaTipoB{

    @Override
    public BigDecimal aplicarTaxa(BigDecimal valor) {
        return valor.add(new BigDecimal("8"));
    }

    
    
}
