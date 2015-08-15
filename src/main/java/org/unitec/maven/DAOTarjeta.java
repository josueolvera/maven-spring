/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.maven;

import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author T-107
 */
public class DAOTarjeta {
    
    private SessionFactory fac;
    private Session ses;
    private Transaction tranza;
    
    public DAOTarjeta(){
        
        fac=HibernateUtilidades.getSessionFactory();
        ses=fac.openSession();
        tranza=ses.beginTransaction();
    }
    
    public void cerrarSesion(){
        tranza.commit();
        ses.close();
    }
    
    
    public void guardar(Tarjeta t)throws Exception{
        ses.save(t);
        cerrarSesion();
    }
    
    public void actualizar(Tarjeta t)throws Exception{
        ses.update(t);
        cerrarSesion();
    }
    
    public Tarjeta buscarPorId(Integer id)throws Exception{
        Tarjeta t = (Tarjeta) ses.createCriteria(Tarjeta.class).add(Restrictions.idEq(id)).uniqueResult();
        cerrarSesion();
        return t;
    } 
    
    
    public void eliminar(Integer id ) throws Exception{
        Tarjeta t = (Tarjeta) ses.createCriteria(Tarjeta.class).add(Restrictions.idEq(id)).uniqueResult();
        ses.delete(t);
        cerrarSesion();
        
    }
    
    
    public ArrayList<Tarjeta>buscarTodos()throws Exception{
        
        Criteria cri=ses.createCriteria(Tarjeta.class);
        ArrayList<Tarjeta>tarjetas=(ArrayList<Tarjeta>)cri.list();
        cerrarSesion();
        return tarjetas;
    
}
}
