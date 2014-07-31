/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.elo7.aplicaTaxa.operacoesTipoA;

import java.math.BigDecimal;

/**
 *
 * @author Giu
 */
public class AplicaTaxaTipoA {
    
     public BigDecimal aplicarTaxa(BigDecimal valor){
      BigDecimal result = new BigDecimal("0");
      try{
        result = valor.multiply(new BigDecimal(3)).divide(new BigDecimal(100));
        result = valor.add(new BigDecimal(2)).add(result);
      }catch(ArithmeticException e){
          throw new ArithmeticException(e.getMessage());
      }          
      return result;
    }
    
}
