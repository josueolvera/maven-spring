/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.maven;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/")

public class ControladorProducto {
    
    @RequestMapping(value="/producto/{nombre}/{costo}/{unidades}",
            method = RequestMethod.POST, headers = {"Accept=text/html"})
    @ResponseBody String guardar(@PathVariable Integer Id, @PathVariable String nombre,@PathVariable Float costo,@PathVariable Integer unidades)throws Exception{
   
    DAOProducto dao=new DAOProducto();
    Producto p=new Producto();
    p.setIdProducto(Id);
    p.setCosto(costo);
    p.setNombre(nombre);
    p.setUnidades(unidades);
    
        dao.guardar(p);
        
        return "Tu producto se guardo con exito";
}
    
   
    
     
    @RequestMapping(value="/producto/{id_producto}/{nombre}/{costo}/{unidades}",
            method = RequestMethod.PUT, headers = {"Accept=text/html"})
    @ResponseBody String actuaizar(@PathVariable Integer id_producto,@PathVariable String nombre,@PathVariable Float costo,@PathVariable Integer 
            unidades)throws Exception{
        
   DAOProducto dao=new DAOProducto();
   
       Producto p=new Producto();
    p.setIdProducto(id_producto);
    p.setCosto(costo);
    p.setNombre(nombre);
    p.setUnidades(unidades);
    
        dao.actualizar(p);
        
        return "Tu producto se actualizo con exito";
}
    
    
    
    
    
    
    
    
}
