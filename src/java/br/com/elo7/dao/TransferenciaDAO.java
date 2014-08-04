/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.elo7.dao;

import br.com.elo7.Conta;
import br.com.elo7.Transferencia;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Giu
 */
public class TransferenciaDAO {
    
    public void agendarTransferencia(Transferencia transferencia){
        DAOFactory factory = new DAOFactory();
        Session session = factory.openSession();        
        Transaction tx = session.beginTransaction();
        try{
            session.save(transferencia);
            tx.commit();        
        session.close();
        }catch(Exception e){
            tx.rollback();
            session.close();
            throw e;
        }
    }
    
    public List listaAgendamento(long agencia, long conta){
        DAOFactory factory = new DAOFactory();
        Session session = factory.openSession();
        Query query = session.createQuery("from Transferencia where agOrigem = "+ agencia+" and contaOrigem = "+conta+" and status = 'NOK'");
        List lista = (List) query.list();
        session.close();
        return lista;
    }
    
}
