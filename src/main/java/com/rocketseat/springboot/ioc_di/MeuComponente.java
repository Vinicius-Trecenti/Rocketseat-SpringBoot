package com.rocketseat.springboot.ioc_di;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component //anotação mais simples para o spring entender que e um componente
@Service // MAIS ESPECIFICO
public class MeuComponente {
    public String chamarMeuComponente(){
        return "Chamando meu componente";
    }
}
