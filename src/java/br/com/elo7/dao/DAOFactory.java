/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.elo7.dao;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Giu
 */
public class DAOFactory {
         
    public Session openSession(){
        AnnotationConfiguration configuration = new AnnotationConfiguration();
        configuration.configure();

        org.hibernate.SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();
        return session;
    }
    
    
    public void closeSession(Session session){        
        session.close();
    }
}
