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
public class DAOGastos {
    
    private SessionFactory fac;
    private Session ses;
    private Transaction tranza;
    
    public DAOGastos(){
        
        fac=HibernateUtilidades.getSessionFactory();
        ses=fac.openSession();
        tranza=ses.beginTransaction();
    }
    
    public void cerrarSesion(){
        tranza.commit();
        ses.close();
    }
    
    
    public void guardar(Gastos g)throws Exception{
        ses.save(g);
        cerrarSesion();
    }
    
    public void actualizar(Gastos g)throws Exception{
        ses.update(g);
        cerrarSesion();
    }
    
    public Gastos buscarPorId(Integer id)throws Exception{
        Gastos g = (Gastos) ses.createCriteria(Gastos.class).add(Restrictions.idEq(id)).uniqueResult();
        cerrarSesion();
        return g;
    } 
    
    
    public void eliminar(Integer id ) throws Exception{
        Gastos g = (Gastos) ses.createCriteria(Gastos.class).add(Restrictions.idEq(id)).uniqueResult();
        ses.delete(g);
        cerrarSesion();
        
    }
    
    
    public ArrayList<Gastos>buscarTodos()throws Exception{
        
        Criteria cri=ses.createCriteria(Gastos.class);
        ArrayList<Gastos>gastos=(ArrayList<Gastos>)cri.list();
        cerrarSesion();
        return gastos;
    
}
}
