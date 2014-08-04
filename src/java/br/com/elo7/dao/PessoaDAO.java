/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.elo7.dao;

import br.com.elo7.Pessoa;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Giu
 */
public class PessoaDAO {
    
    
    public void cadastrarPessoa(Pessoa pessoa){
        DAOFactory dao = new DAOFactory();
        Session session = dao.openSession();
        Transaction tx = session.beginTransaction();
        try{
            session.save(pessoa.getConta());
            session.save(pessoa);
            tx.commit();
            session.close();
        }catch(Exception e){
            tx.rollback();
            session.close();
            throw e;
        }
        
    }
 
    public Pessoa login(String login, String senha){
        DAOFactory factory = new DAOFactory();
        Session session = factory.openSession();
        Query query = session.createQuery("from Pessoa where login = '"+ login+"' and senha = '"+senha+"'");
        Object obj = query.uniqueResult();
        Pessoa pessoa = (Pessoa) obj;
        session.close();        
        return pessoa;
    }
}
