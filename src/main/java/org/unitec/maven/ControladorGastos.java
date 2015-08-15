/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.maven;

import java.util.ArrayList;
import java.util.Date;
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
public class ControladorGastos {
    
    @RequestMapping(value="/gastos/{fecha}/{concepto}/{cantidad}/{idTarjeta}",method = RequestMethod.POST, headers={"Accept=text/html"})
    
    @ResponseBody String guardarGastos(@PathVariable Date fecha,@PathVariable String concepto,@PathVariable Float cantidad,@PathVariable Integer idTarjeta)throws Exception{
        Gastos g=new Gastos();
       g.setFecha(fecha);
       g.setConcepto(concepto);
       g.setCantidad(cantidad);
       Tarjeta t=new Tarjeta (idTarjeta);
       g.setIdTarjeta(t);
        DAOGastos dao = new DAOGastos();
        dao.guardar(g);
        return "Gastos Guardados";
        
    }
    
    @RequestMapping(value="/gastos/{idGastos}/{fecha}/{concepto}/{cantidad}/{idTarjeta}", method = RequestMethod.PUT, headers = {"Accept=text/html"})
    @ResponseBody String actuaizar(@PathVariable Integer idGastos,@PathVariable Date fecha,@PathVariable String concepto,@PathVariable Float cantidad,@PathVariable Integer idTarjeta)throws Exception{
        
   DAOGastos dao=new DAOGastos();
   
       Gastos g=new Gastos();
       g.setIdGastos(idGastos);
       g.setFecha(fecha);
       g.setConcepto(concepto);
       g.setCantidad(cantidad);
        Tarjeta t=new Tarjeta (idTarjeta);
       g.setIdTarjeta(t);
    
    
        dao.actualizar(g);
        
        return "Los gastos se actualizaron con exito";
}
    
    @RequestMapping(value="/gastos/{idGastos}", method = RequestMethod.DELETE, headers = {"Accept=text/html"})
    @ResponseBody String eliminar(@PathVariable Integer idGastos)throws Exception{
        
   DAOGastos dao=new DAOGastos();
        dao.eliminar(idGastos);
        
        return "La gastos se eliminaron";
}
    
    @RequestMapping(value="/gastos", method = RequestMethod.GET, headers = {"Accept=application/json"})
    @ResponseBody ArrayList<Gastos> BuscarT()throws Exception{
        
   DAOGastos dao=new DAOGastos();
   ArrayList<Gastos> gastos = (ArrayList<Gastos>)dao.buscarTodos();
        
        return gastos;
}
    
    @RequestMapping(value="/gastos/{idGastos}", method = RequestMethod.GET, headers = {"Accept=application/json"})
    @ResponseBody Gastos buscarI(@PathVariable Integer idGastos)throws Exception{
        
   DAOGastos dao=new DAOGastos();
   
    Gastos g=(Gastos) dao.buscarPorId(idGastos);
        
        return g;
}
    
    
    
    
}
