/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.elo7.br.com.elo7.calculaTaxa.operacoesTipoD;

import br.com.elo7.Transferencia;
import br.com.elo7.aplicaTaxa.operacoesTipoD.AplicaTaxaRegra1;
import br.com.elo7.aplicaTaxa.operacoesTipoD.AplicaTaxaRegra2;
import br.com.elo7.aplicaTaxa.operacoesTipoD.AplicaTaxaRegra3;
import br.com.elo7.aplicaTaxa.operacoesTipoD.AplicaTaxaTipoD;
import java.math.BigDecimal;

/**
 *
 * @author Giu
 */
public class CalculaTaxaOperacoesTipoD {
    
    public Transferencia calculaTaxa(Transferencia transferencia){
        BigDecimal taxa = new BigDecimal("0");
        
        try{
            if(transferencia.getValorTransferencia().doubleValue() <= 25000.d){
                AplicaTaxaTipoD taxaD = new AplicaTaxaRegra1();
                taxa = taxaD.aplicarTaxa(transferencia);
            }

             if((transferencia.getValorTransferencia().doubleValue() >= 25001.d) && (transferencia.getValorTransferencia().doubleValue() < 120000.d) ){
                AplicaTaxaTipoD taxaD = new AplicaTaxaRegra2();
                taxa = taxaD.aplicarTaxa(transferencia);
            }

             if(transferencia.getValorTransferencia().doubleValue() <= 25000.d){
                AplicaTaxaTipoD taxaD = new AplicaTaxaRegra3();
                taxa = taxaD.aplicarTaxa(transferencia);
            }
            
            if(taxa.doubleValue() > transferencia.getContaOrigem().getValorConta().doubleValue()){
                throw new ArithmeticException("Não há saldo o sufiente na conta para a realização da transferência.");
            }
        transferencia.setValorTransferencia(taxa);
        }catch(ArithmeticException e){
           throw new ArithmeticException(e.getMessage());
        }
        return transferencia;
    }
    
}
