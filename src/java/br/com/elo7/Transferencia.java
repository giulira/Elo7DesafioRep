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
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Giu
 */
@Entity
public class Transferencia {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)  
    private long id;
    private Conta contaOrigem;
    private Conta contaDestino;
    private BigDecimal valorTransferencia;
    private String tipoOperacao;
    private Date dataTransferencia;
    private String status;

    public Conta getContaOrigem() {
        return contaOrigem;
    }

    
    public BigDecimal getValorTransferencia() {
        return valorTransferencia;
    }

    public void setValorTransferencia(BigDecimal valorTransferencia) {
        this.valorTransferencia = valorTransferencia;
    }

    public Date getDataTransferencia() {
        return dataTransferencia;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Conta getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(Conta contaDestino) {
        this.contaDestino = contaDestino;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public void setContaOrigem(Conta contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDataTransferencia(Date dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }
    
         
    
}
