



package org.unitec.maven;

//hacen dos cosas !: mostrar pag web   2: liberar servicios

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//Un contralador se ocupa para presentar paginas web o para liberar servicios, son como servlets, pero mas potentes
//Ademas hace liberar servicios a cualkier clientes
//Libetarlos es conocerlo a cualkier plataforma

@Controller   //Es una anotacion estereotipo para hacer una clase controler
@RequestMapping("/")  // Y SE LE DICE CONTEXTO A LA DIAGONAL Mapeo pedido o solicitado, mapeo generar del servicio ://localhost:9000/<-- esta es la raiz de los servicios
public class ControladorLeer {
    
    //aqui irian todos los "servlets o servicios"
    
    //ESTE ES EL MODEL
    @RequestMapping(value="/leer",method = RequestMethod.GET,headers ={"Accept=text/html"})
@ResponseBody String leer() throws Exception{

//ESTA ES LA VISTA
return "aqui vamos a mostrar el servicio leer que hicimos  ya";
    
    
}
}

//TAREA
//SPRING MVC
//CONTROLLER

/*
@RequestMapping(value="/leer",method = RequestMethod.GET,headers ={"Accept=text/html"})
@ResponseBody String leer() throws Exception{

//ESTA ES LA VISTA
return "aqui vamos a mostrar el servicio leer que hicimos  ya";
    
    
}
}
*/


/*
Pdf
 @RequestMapping(value="/leer",method = RequestMethod.GET,headers ={"Accept=application/pdf"})
@ResponseBody String leer() throws Exception{

//ESTA ES LA VISTA
return "aqui vamos a mostrar el servicio leer que hicimos  ya";
    
    
}
}
*/