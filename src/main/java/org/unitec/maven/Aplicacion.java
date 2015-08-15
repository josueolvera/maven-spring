
package org.unitec.maven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//configura todo el tomcat
//enableautoconfiguration:configura todo para que sea rapido, el tomcat, el contexto de spring(http://localhost:9000 es hasta el puerto
@EnableAutoConfiguration
@ComponentScan
//manda a llamar todos las componentes que tengan @Component

//https://github.com/curso-elementos/spring-boot/blob/master/src/main/java/hola/PersonalizarBeans.java
//http://projects.spring.io/spring-boot/#quick-start

public class Aplicacion {
    
    public static void main(String[] args) throws Exception{
        
        SpringApplication.run(Aplicacion.class, args);
        //debajo de esta linea se ponen los datos para objetos visuales ventanas
        /*
        System.out.println("Un mensaje desde Spring Boot");
        
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(ConfiguracionBasica.class);
     
        Leer servicioLeer= ctx.getBean(Leer.class);//bean Leer
        
        
        System.out.println(servicioLeer.leer());
        */
    }
      /*  
        //DEL PROBLEMA
        
        Leer objeto=new LectorDoc();
        System.out.println(objeto.leer());//leer es el metodo de la clase LectorDoc
    }
    */
    
    
    //UN CONTROLADOR ES UN SERVLET PERO MAS POTENTE
}
