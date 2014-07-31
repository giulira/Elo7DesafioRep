/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.elo7.aplicaTaxa.operacoesTipoD;

import br.com.elo7.Transferencia;
import java.math.BigDecimal;

/**
 *
 * @author Giu
 */
public interface AplicaTaxaTipoD {
    public BigDecimal aplicarTaxa(Transferencia transferencia);    
}
