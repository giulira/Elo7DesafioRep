/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.elo7.mb;

import br.com.elo7.Conta;
import br.com.elo7.Transferencia;
import br.com.elo7.br.com.elo7.calculaTaxa.operacoesTipoA.CalculaTaxaOperacoesTipoA;
import br.com.elo7.br.com.elo7.calculaTaxa.operacoesTipoB.CalculaTaxaOperacoesTipoB;
import br.com.elo7.br.com.elo7.calculaTaxa.operacoesTipoC.CalculaTaxaOperacoesTipoC;
import br.com.elo7.br.com.elo7.calculaTaxa.operacoesTipoD.CalculaTaxaOperacoesTipoD;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Giu
 */
@ManagedBean(name="agendaMB")
@RequestScoped
public class AgendaMB {
    public Date data;
    public Date dataMax = new Date();
    public Date dataMin = new Date(); 
    public String valor = "";
    public String tipo;
    public String agenciaDestino = "";
    public String contaDestino = "";
    public String agenciaOrigem = "";
    public String contaOrigem = "";
    
    
      
    /**
     * Creates a new instance of AgendaMB
     */
    public AgendaMB() {
        GregorianCalendar dtMax = new GregorianCalendar();        
        Date dt = new Date();
        dtMax.setTime(dt);     
        GregorianCalendar dtMin = new GregorianCalendar(); 
        dtMin.setTime(dt);
        dtMin.add(Calendar.DAY_OF_MONTH, 1);
        dtMax.add(Calendar.DAY_OF_MONTH, 40);
        dataMax = dtMax.getTime();
        dataMin = dtMin.getTime();   
    }
    
    public String criarAgendamento(){               
        Transferencia transf = new Transferencia(); 
        long agDest = Long.parseLong(agenciaDestino);
        long contaDest = Long.parseLong(contaDestino);
                
        long agOrg = Long.parseLong(agenciaDestino);
        long contaOrg = Long.parseLong(contaDestino);
        
        Conta origem = new Conta();  
        origem.setAgencia(agOrg);
        origem.setNumeroConta(contaOrg);        
        Conta destino = new Conta(); 
        destino.setAgencia(agDest);
        destino.setNumeroConta(contaDest);
        transf.setValorTransferencia(new BigDecimal(valor));
        transf.setTipoOperacao(tipo);
        transf.setContaDestino(destino);
        transf.setContaOrigem(origem);
        transf.setDataTransferencia(data);
        try{
        if(tipo.equals("A")){
            CalculaTaxaOperacoesTipoA calc = new CalculaTaxaOperacoesTipoA();
            transf = calc.calculaTaxa(transf);
        }        
        if(tipo.equals("B")){
            CalculaTaxaOperacoesTipoB calc = new CalculaTaxaOperacoesTipoB();
            transf = calc.calculaTaxa(transf);
        }        
        if(tipo.equals("C")){
            CalculaTaxaOperacoesTipoC calc = new CalculaTaxaOperacoesTipoC();
            transf = calc.calculaTaxa(transf);
        }        
        if(tipo.equals("D")){
            CalculaTaxaOperacoesTipoD calc = new CalculaTaxaOperacoesTipoD();
            transf = calc.calculaTaxa(transf);
            System.out.println("Valor final da transferencia "+transf.getValorTransferencia());
        }
        }catch(Exception e){
            throw new e.getMessage("Não foi possivel realizar o agendamento.");
        }
                
        
        /**
         * Chamar o método de busca a agendas das transações não realizadas.
         */
        //buscarAgendamento(agOrg, contaOrg);
        
        return "pages/agenda";
    }
    
    /**
     * Método responsável por realizar a autenticação do usuário no sistema.
     * @return 
     */
    public String login(){
        //Autenticar o usuário no sistema e retornar as informações da conta de origem.
        return null;
    }
    
    /**
     * Retorna uma lista das agendas da transferência.
     * @return 
     */
    
    public List<Transferencia> buscarAgendamento(long agencia, long conta){
        return null;
    }
    
    /**
     * Método responável por realizar o cadastro do usuário.
     * @return 
     */    
    public String cadastrarUsuario(){
        return null;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getDataMax() {
        return dataMax;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Date getDataMin() {
        return dataMin;
    }

    public void setDataMin(Date dataMin) {
        this.dataMin = dataMin;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(String contaDestino) {
        this.contaDestino = contaDestino;
    }

    public String getAgenciaDestino() {
        return agenciaDestino;
    }

    public void setAgenciaDestino(String agenciaDestino) {
        this.agenciaDestino = agenciaDestino;
    }

     
}
