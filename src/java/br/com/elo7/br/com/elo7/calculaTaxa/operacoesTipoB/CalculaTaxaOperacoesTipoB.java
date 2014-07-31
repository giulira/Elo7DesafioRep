/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.elo7.br.com.elo7.calculaTaxa.operacoesTipoB;

import br.com.elo7.Transferencia;
import br.com.elo7.aplicaTaxa.operacoesTipoB.AplicaTaxaAteTrintaDias;
import br.com.elo7.aplicaTaxa.operacoesTipoB.AplicaTaxaDemaisDias;
import br.com.elo7.aplicaTaxa.operacoesTipoB.AplicaTaxaTipoB;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Giu
 */
public class CalculaTaxaOperacoesTipoB {
    
    public Transferencia calculaTaxa(Transferencia transferencia){
        BigDecimal taxa = new BigDecimal("0");
        Date dt = transferencia.getDataTransferencia();      
        int dias = calculaPrazo(dt);
        
        if(dias <= 30){
            AplicaTaxaTipoB tipoB = new AplicaTaxaAteTrintaDias();
            try{
                taxa = tipoB.aplicarTaxa(transferencia.getValorTransferencia());            
                if(taxa.doubleValue() > transferencia.getContaOrigem().getValorConta().doubleValue()){
                    throw new ArithmeticException("Não há saldo o sufiente na conta para a realização da transferência.");
                }
                transferencia.setValorTransferencia(taxa);
            }catch(ArithmeticException e){
               throw new ArithmeticException(e.getMessage());
            }
        }else{
            AplicaTaxaTipoB tipoB = new AplicaTaxaDemaisDias();
            try{
                taxa = tipoB.aplicarTaxa(transferencia.getValorTransferencia());            
                if(taxa.doubleValue() > transferencia.getContaOrigem().getValorConta().doubleValue()){
                    throw new ArithmeticException("Não há saldo o sufiente na conta para a realização da transferência.");
                }
                transferencia.setValorTransferencia(taxa);
            }catch(ArithmeticException e){
               throw new ArithmeticException(e.getMessage());
            }
        }    
        return transferencia;
    }
    
    public int calculaPrazo(Date dataTrasferencia){  
        
       int qtdeDias = 0;  
       GregorianCalendar dtAtual = new GregorianCalendar();
       int diaAtual = dtAtual.get(Calendar.DAY_OF_MONTH);
       int mesAtual = dtAtual.get(Calendar.MONTH)+1;
             
       GregorianCalendar dtFutura = new GregorianCalendar();
       dtFutura.setTime(dataTrasferencia);               
       int diaFuturo = dtFutura.get(Calendar.DAY_OF_MONTH);
       int mesFuturo = dtFutura.get(Calendar.MONTH)+1;             
       if((mesAtual == mesFuturo)){          
            qtdeDias = diaFuturo - diaAtual;  
       }else{
        int qtdeDiaMes = dtAtual.getActualMaximum(Calendar.DAY_OF_MONTH);
        qtdeDias = qtdeDiaMes - diaAtual;  
        int qtdeDiasProxMes = dtFutura.getActualMaximum(Calendar.DAY_OF_MONTH);         
        if(diaFuturo == qtdeDiasProxMes){
             qtdeDias =qtdeDias + qtdeDiasProxMes;
         }else{
               if(diaFuturo < qtdeDiasProxMes){
                qtdeDias = qtdeDias + diaFuturo;
               }
         }              
       }
       return qtdeDias;        
    }
    
}
