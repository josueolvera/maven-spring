/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.maven;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

/**
 *
 * @author T-107
 */
public class DAOProducto {
    
    private SessionFactory fac;
    private Session ses;
    private Transaction tranza;
    
    public DAOProducto(){
        
        fac=HibernateUtilidades.getSessionFactory();
        ses=fac.openSession();
        tranza=ses.beginTransaction();
    }
    
    public void cerrarSesion(){
        tranza.commit();
        ses.close();
    }
    
    
    public void guardar(Producto g)throws Exception{
        ses.save(g);
        cerrarSesion();
    }
    
    public void actualizar(Producto g)throws Exception{
        ses.save(g);
        cerrarSesion();
    }
    
    
    public ArrayList<Producto>buscarTodos()throws Exception{
        
        Criteria cri=ses.createCriteria(Producto.class);
        ArrayList<Producto>producto=(ArrayList<Producto>)cri.list();
        cerrarSesion();
        return producto;
    }
    //Tendroamos que crear algo parecido a lo del parcial
   /* public Producto buscarPorId(Integer ID)throws Exception{
        
        
    */
    
    
    
    
    
     
     
}
