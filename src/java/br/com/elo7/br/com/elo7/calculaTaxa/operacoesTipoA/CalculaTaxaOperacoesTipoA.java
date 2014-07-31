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
    public Transferencia calculaTaxa(Transferencia transferencia){
        BigDecimal taxa = new BigDecimal("0");
        AplicaTaxaTipoA tipoA = new AplicaTaxaTipoA();
        try{
                        
            taxa = tipoA.aplicarTaxa(transferencia.getValorTransferencia());            
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
