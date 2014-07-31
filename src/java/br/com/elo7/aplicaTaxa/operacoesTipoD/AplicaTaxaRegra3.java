/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.elo7.aplicaTaxa.operacoesTipoD;

import br.com.elo7.Transferencia;
import br.com.elo7.aplicaTaxa.operacoesTipoC.AplicaTaxaAteCincoDias;
import br.com.elo7.aplicaTaxa.operacoesTipoC.AplicaTaxaAteDezDias;
import br.com.elo7.aplicaTaxa.operacoesTipoC.AplicaTaxaAteQuinzeDias;
import br.com.elo7.aplicaTaxa.operacoesTipoC.AplicaTaxaAteTrintaDias;
import br.com.elo7.aplicaTaxa.operacoesTipoC.AplicaTaxaAteVinteCincoDias;
import br.com.elo7.aplicaTaxa.operacoesTipoC.AplicaTaxaAteVinteDias;
import br.com.elo7.aplicaTaxa.operacoesTipoC.AplicaTaxaMaiorQueTrintaDias;
import br.com.elo7.aplicaTaxa.operacoesTipoC.AplicaTaxaTipoC;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Giu
 */
public class AplicaTaxaRegra3 implements AplicaTaxaTipoD{

    @Override
    public BigDecimal aplicarTaxa(Transferencia transferencia) {
        BigDecimal taxa = new BigDecimal("0");
        Date dt = transferencia.getDataTransferencia();      
        int dias = calculaPrazo(dt);
        
         //maior que 30 dias da data de cadastro - 1.2%
         if(dias > 30){
             AplicaTaxaTipoC taxaC = new AplicaTaxaMaiorQueTrintaDias();
             taxa = taxaC.aplicarTaxa(transferencia.getValorTransferencia());
         }
         
         //até 30 dias da data de cadastro - 2.1%
         if(dias <= 30){
             AplicaTaxaTipoC taxaC = new AplicaTaxaAteTrintaDias();
             taxa = taxaC.aplicarTaxa(transferencia.getValorTransferencia());
         }
            
         //até 25 dias da data de cadastro - 4.3%
         if(dias <= 25){
             AplicaTaxaTipoC taxaC = new AplicaTaxaAteVinteCincoDias();
             taxa = taxaC.aplicarTaxa(transferencia.getValorTransferencia());             
         }
            
         //até 20 dias da data de cadastro - 5.4%
         if(dias <= 20){
             AplicaTaxaTipoC taxaC = new AplicaTaxaAteVinteDias();
             taxa = taxaC.aplicarTaxa(transferencia.getValorTransferencia());
             
         }
            
         //até 15 dias da data de cadastro - 6.7%
         if(dias <= 15){
             AplicaTaxaTipoC taxaC = new AplicaTaxaAteQuinzeDias();
             taxa = taxaC.aplicarTaxa(transferencia.getValorTransferencia());
         }
          
         //até 10 dias da data de cadastro - 7.4%
         if(dias <= 10){
             AplicaTaxaTipoC taxaC = new AplicaTaxaAteDezDias();
             taxa = taxaC.aplicarTaxa(transferencia.getValorTransferencia());
             
         }
            
         //até  5 dias da data de cadastro - 8.3%
         if(dias <= 5){
             AplicaTaxaTipoC taxaC = new AplicaTaxaAteCincoDias();
             taxa = taxaC.aplicarTaxa(transferencia.getValorTransferencia());
         }
         
         return taxa;
    }
    
     public int calculaPrazo(Date dataTrasferencia){  
        /*Não esquescer que para calcular o mes de um Date mes - 1.
        Limitar mes seguinte no calendario.
        */
        
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
