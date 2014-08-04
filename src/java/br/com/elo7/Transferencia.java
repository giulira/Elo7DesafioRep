/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.elo7;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Giu
 */
@Entity
public class Transferencia {
    
    @Id
    @GeneratedValue
    private long id;    
    private long agOrigem;
    private long contaOrigem;  
    private long agDestino;
    private long contaDestino;
    private BigDecimal valorTransferencia;
    private String tipoOperacao;    
    private Date dataTransferencia;
    private String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAgOrigem() {
        return agOrigem;
    }

    public void setAgOrigem(long agOrigem) {
        this.agOrigem = agOrigem;
    }

    public long getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(long contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public long getAgDestino() {
        return agDestino;
    }

    public void setAgDestino(long agDestino) {
        this.agDestino = agDestino;
    }

    public long getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(long contaDestino) {
        this.contaDestino = contaDestino;
    }

    public BigDecimal getValorTransferencia() {
        return valorTransferencia;
    }

    public void setValorTransferencia(BigDecimal valorTransferencia) {
        this.valorTransferencia = valorTransferencia;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public Date getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(Date dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
      
      
}
