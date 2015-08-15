/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.maven;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author T-107
 */

@Controller
@RequestMapping("/")
public class ControladorTarjeta {
    
    @RequestMapping(value="/tarjeta/{nombre}/{fechaCorte}",method = RequestMethod.POST, headers={"Accept=text/html"})
    
    @ResponseBody String guardarTarjeta(@PathVariable String nombre,@PathVariable Integer fechaCorte)throws Exception{
        Tarjeta t=new Tarjeta();
        t.setDiacorte(fechaCorte);
        t.setNombre(nombre);
        DAOTarjeta dao = new DAOTarjeta();
        dao.guardar(t);
        return "Tarjeta Guardada";
        
    }
    
    @RequestMapping(value="/tarjeta/{idTarjeta}/{nombre}/{fechaCorte}", method = RequestMethod.PUT, headers = {"Accept=text/html"})
    @ResponseBody String actuaizar(@PathVariable Integer idTarjeta,@PathVariable String nombre,@PathVariable Integer fechaCorte)throws Exception{
        
   DAOTarjeta dao=new DAOTarjeta();
   
       Tarjeta t=new Tarjeta();
    t.setIdTarjeta(idTarjeta);
    t.setNombre(nombre);
    t.setDiacorte(fechaCorte);
    
    
        dao.actualizar(t);
        
        return "La tarjeta se actualizo con exito";
}
    
    @RequestMapping(value="/tarjeta/{idTarjeta}", method = RequestMethod.DELETE, headers = {"Accept=text/html"})
    @ResponseBody String eliminar(@PathVariable Integer idTarjeta)throws Exception{
        
   DAOTarjeta dao=new DAOTarjeta();
        dao.eliminar(idTarjeta);
        
        return "La tarjeta se Elimino";
}
    
    @RequestMapping(value="/tarjeta", method = RequestMethod.GET, headers = {"Accept=application/json"})
    @ResponseBody ArrayList<Tarjeta> BuscarT()throws Exception{
        
   DAOTarjeta dao=new DAOTarjeta();
   ArrayList<Tarjeta> tarjetas = (ArrayList<Tarjeta>)dao.buscarTodos();
        
        return tarjetas;
}
    
    @RequestMapping(value="/tarjeta/{idTarjeta}", method = RequestMethod.GET, headers = {"Accept=application/json"})
    @ResponseBody Tarjeta buscarI(@PathVariable Integer idTarjeta)throws Exception{
        
   DAOTarjeta dao=new DAOTarjeta();
   
    Tarjeta t=(Tarjeta) dao.buscarPorId(idTarjeta);
        
        return t;
}
    
    
    
    
}
