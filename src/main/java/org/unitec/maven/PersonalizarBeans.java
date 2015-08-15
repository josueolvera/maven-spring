/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.maven;
//un bean es una clase pojo osea una tabla como de mysql
import org.springframework.boot.context.embedded.*;
import org.springframework.stereotype.Component;
//COMPONENTE DE SOFTWARE VA ESCANEAR TODAS LAS QUE TENGAN @COMPONENT
@Component
public class PersonalizarBeans implements EmbeddedServletContainerCustomizer {

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(9000);
    }

}