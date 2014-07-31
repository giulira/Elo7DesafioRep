/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.elo7.aplicaTaxa.operacoesTipoD;

import br.com.elo7.Transferencia;
import br.com.elo7.aplicaTaxa.operacoesTipoA.AplicaTaxaTipoA;
import java.math.BigDecimal;

/**
 *
 * @author Giu
 */
public class AplicaTaxaRegra1 implements AplicaTaxaTipoD{

    @Override
    public BigDecimal aplicarTaxa(Transferencia transferencia) {
        AplicaTaxaTipoA taxa = new AplicaTaxaTipoA();
        return taxa.aplicarTaxa(transferencia.getValorTransferencia());
    }
    
}
