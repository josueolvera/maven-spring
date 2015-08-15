/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.maven;

/**
 *
 * @author T-107
 */
public class LeerMysql implements Leer{
//inyeccion con beans a la clase main de aplicacion
    @Override
    public String leer() throws Exception {
    //aki va lo de hibernate
        String mensajito="conectado a mysql";
        return mensajito;
    }
    
    
}
