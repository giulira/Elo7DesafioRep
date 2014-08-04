/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.elo7.dao;

import br.com.elo7.Conta;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Giu 
 */
public class ContaDAO {
        
    
    public Conta buscarConta(long agencia, long numeroConta){
       DAOFactory factory = new DAOFactory();
        Session session = factory.openSession();
        Query query = session.createQuery("from Conta where agencia = "+ agencia+" and numeroConta = "+numeroConta);
        Object obj = query.uniqueResult();
        Conta conta =(Conta) obj;
        session.close();
        return conta;
        
    }
    
}
