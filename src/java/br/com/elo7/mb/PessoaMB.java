/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.elo7.mb;

import br.com.elo7.Conta;
import br.com.elo7.Pessoa;
import br.com.elo7.dao.PessoaDAO;
import java.math.BigDecimal;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Giu
 */
@ManagedBean(name="pessoaMB")
@RequestScoped
public class PessoaMB {
    public String nome;
    public String endereco;
    public String documento;
    public String tipoDoc;    
    public String agencia;
    public String conta;    
    public String saldo;
    public String login;
    public String senha;
    
    public String cadastrarPessoa(){
        try{
            long agLong = Long.parseLong(agencia);
            long numeroLong = Long.parseLong(conta);
            Pessoa pessoa = new Pessoa();        
            Conta conta = new Conta();
            conta.setAgencia(agLong);
            conta.setNumeroConta(numeroLong);
            conta.setSaldo(BigDecimal.ZERO);        
            pessoa.setNome(nome);
            pessoa.setEndereco(endereco);
            pessoa.setTipoDoc(tipoDoc);
            pessoa.setDocumento(documento);
            pessoa.setLogin(login.trim());
            pessoa.setSenha(senha.trim());
            pessoa.setConta(conta);
            
            PessoaDAO dao = new PessoaDAO();
            dao.cadastrarPessoa(pessoa);
                    
        }catch(Exception e){
            FacesMessage mensagem = new FacesMessage("Não foi possivel realizar cadastro: "+e.getMessage());  
            FacesContext.getCurrentInstance().addMessage(null,  mensagem );
            return "/pages/cadastroConta" ;
            
        }
              
        return "/pages/cadastroConta";
    }

    public String loginUser(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        PessoaDAO dao = new PessoaDAO();
        Pessoa pessoa = new Pessoa();
        try{
        pessoa = dao.login(login.trim(), senha.trim());
        session.setAttribute("agencia", pessoa.getConta().getAgencia());
        session.setAttribute("conta", pessoa.getConta().getNumeroConta());
        }catch(Exception e){
            FacesMessage mensagem = new FacesMessage("Usuário / senha não confere.");  
            FacesContext.getCurrentInstance().addMessage(null,  mensagem );
            return "/pages/login" ;
        }
        
        return "/pages/agenda" ;
    }
    
    public String irCadastro(){
        return "/pages/cadastroConta";
    }
    
    public String sair(){
        return "/pages/login";
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
       
}
