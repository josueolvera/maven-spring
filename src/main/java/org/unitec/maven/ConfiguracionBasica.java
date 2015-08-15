/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.maven;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author T-107
 */
@Configuration
public class ConfiguracionBasica {
    //bean maestro
    /*
    
    @Bean
    Leer servicioLeer(){
    
        LectorDoc leer=new LectorDoc();
        return leer;
    }
    */
    
    
    
    /*
    //CON MYSQL Y BEAN MYSQL
    @Bean
    Leer servicioLeer(){
    
        Leer leer=new LectorDoc();
        return leer;
    }
    
    */
    
    
    @Bean
    Leer servicioLeer(){
    
        Leer leer=new LeerMysql();
        return leer;
    }
}

