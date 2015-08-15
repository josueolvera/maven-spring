/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.maven;

import java.io.Serializable;

import java.io.*;

public class LectorDoc implements Leer{
    @Override
    public String leer() throws Exception{
        File file=new File("D:\\Android\\dato.txt");
        
        FileInputStream fis=new FileInputStream(file);
        StringBuilder sb=new StringBuilder();  //string normal que junta caracter como los va leyendo, cada palabra la junta al leerlo, en cada vuelta se agrega una letra
        //fis=fileinputstream
        int ch=0;
        while((ch=fis.read())!=-1){//el while lee el primer caracter y lo asigna a ch k lo hace entero y compara si es diferente a  -1, el final de un archivo lo ponen como -1 es el fin de archivo de http
    
        sb.append((char)ch); //el casting fue xk solo se leen enteros, pork son numeros  codigo ascii y los paso a letras
        
        }
        return sb.toString();
        }
    //to string xk no se puede trasformar un stringbuilder ya que es un constructor de string, (es un buffer se acomulan los datos) con string normal solo se veria la ultima letra

    }
