package com.rocketseat.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocketseat.springboot.ioc_di.MeuComponente;

@RestController
@RequestMapping("/componente")
public class MeuControllerComponente {

    //Toda vez que falamos de injeção de dependencia no spring deve usar uma anotação que é responsavel por instanciar nossa classe
    @Autowired //significa que tudo que esta abaixo é gerenciado pelo spring - Todo o clico de vida - nao precisa do new Componente...
    MeuComponente meuComponente; //preciso de um BIN para ser gerenciado pelo conteiner IOC - como um componente ou objeto gerenciado

    @GetMapping("/")
    public String chamandoComponente(){
        //var meuComponente = new MeuComponente();
        var resultado = meuComponente.chamarMeuComponente();
        return resultado;
    }
}
