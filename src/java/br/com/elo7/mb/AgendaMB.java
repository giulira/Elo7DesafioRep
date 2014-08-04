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
import br.com.elo7.dao.ContaDAO;
import br.com.elo7.dao.TransferenciaDAO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

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
    public List listaAgenda = new ArrayList();
    
      
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
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        Long agOrLong = (Long) session.getAttribute("agencia");
        Long ctOrLong = (Long) session.getAttribute("conta");
                
        Transferencia transf = new Transferencia(); 
        long agDest = Long.parseLong(agenciaDestino);
        long contaDest = Long.parseLong(contaDestino);                
        long agOrg = agOrLong.longValue();
        long contaOrg = ctOrLong.longValue();
        BigDecimal valorFinal = BigDecimal.ZERO;
       
        transf.setValorTransferencia(new BigDecimal(valor));
        transf.setTipoOperacao(tipo);
        transf.setAgDestino(agDest);
        transf.setContaDestino(contaDest);
        transf.setAgOrigem(agOrg);
        transf.setContaOrigem(contaOrg);        
        transf.setDataTransferencia(data);
        transf.setStatus("NOK");
        try{
            if(tipo.equals("A")){
                CalculaTaxaOperacoesTipoA calc = new CalculaTaxaOperacoesTipoA();
                valorFinal = calc.calculaTaxa(transf);
            }        
            if(tipo.equals("B")){
                CalculaTaxaOperacoesTipoB calc = new CalculaTaxaOperacoesTipoB();
                valorFinal = calc.calculaTaxa(transf);
            }        
            if(tipo.equals("C")){
                CalculaTaxaOperacoesTipoC calc = new CalculaTaxaOperacoesTipoC();
                valorFinal = calc.calculaTaxa(transf);
            }        
            if(tipo.equals("D")){
                CalculaTaxaOperacoesTipoD calc = new CalculaTaxaOperacoesTipoD();
                valorFinal = calc.calculaTaxa(transf);           
            }
                        
            Conta conta =  buscarContaOrigem(agOrg, contaOrg);            
            
            if(valorFinal.doubleValue() > conta.getSaldo().doubleValue()){                
                FacesMessage mensagem = new FacesMessage( "Não há saldo o sufiente na conta para a realização da transferência." );  
                FacesContext.getCurrentInstance().addMessage(null, mensagem );
                throw new IllegalArgumentException();
            }else{
                transf.setValorTransferencia(valorFinal);
                realizarAgendamento(transf);
                listaAgenda = listarAgendamento(agOrg, contaOrg);
            }
        }catch(Exception e){
            FacesMessage mensagem = new FacesMessage("Não foi possivel realizar o agendamento: "+e.getMessage());  
            FacesContext.getCurrentInstance().addMessage(null,  mensagem );
            return "/pages/agenda" ;
            
        }                
        
        return "/pages/listaAgendamento";
    }
    
    private void realizarAgendamento(Transferencia transferencia){
        TransferenciaDAO dao = new TransferenciaDAO();
         dao.agendarTransferencia(transferencia);
    }
    
    private Conta buscarContaOrigem(long agencia, long numeroConta){
        
        ContaDAO dao = new ContaDAO();
        Conta conta = dao.buscarConta(agencia, numeroConta);
        return conta;
    }
    
    
    
    /**
     * Retorna uma lista das agendas da transferência.
     * @return 
     */
    
    public List<Transferencia> listarAgendamento(long agencia, long conta){
        TransferenciaDAO dao = new TransferenciaDAO();
        return dao.listaAgendamento(agencia, conta);        
    }
        
    public String voltar(){
        return "/pages/agenda" ;
    }
            
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAgenciaDestino() {
        return agenciaDestino;
    }

    public void setAgenciaDestino(String agenciaDestino) {
        this.agenciaDestino = agenciaDestino;
    }

    public String getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(String contaDestino) {
        this.contaDestino = contaDestino;
    }

    public String getAgenciaOrigem() {
        return agenciaOrigem;
    }

    public void setAgenciaOrigem(String agenciaOrigem) {
        this.agenciaOrigem = agenciaOrigem;
    }

    public String getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(String contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public Date getDataMax() {
        return dataMax;
    }

    public void setDataMax(Date dataMax) {
        this.dataMax = dataMax;
    }

    public Date getDataMin() {
        return dataMin;
    }

    public void setDataMin(Date dataMin) {
        this.dataMin = dataMin;
    }

    public List getListaAgenda() {
        return listaAgenda;
    }

    public void setListaAgenda(List listaAgenda) {
        this.listaAgenda = listaAgenda;
    }

    
}
