package com.rocketseat.springboot.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//Informar o Spring que deve monitorar essa classe pois havera movimentações de informações
//Sera do tipo REST com metodos
@RestController

// Anotar a que é para essa rota que se deve responder a solicitacao - Por meio de anotações
@RequestMapping("/primeiroController")
public class PrimeiroController {


    @GetMapping("/primeiroMetodo/{id}")
    public String primeiroMetodo(@PathVariable String id){
        return "O parametro passado é: " + id;
    }

    //http://localhost:8080/primeiroController/metodoComQueryParams?id=189
    @GetMapping("/metodoComQueryParams")
    public String metodoComQueryParams(@RequestParam String id){ //Informa que dentro da requisição tem os parametros para consulta
        return "O parametro com metodoComQueryParams é: " + id;
    }

    //http://localhost:8080/primeiroController/metodoComQueryParams2?id=189&nome=Vinicius&idade=22
    @GetMapping("/metodoComQueryParams2")
    public String metodoComQueryParams2(@RequestParam Map<String, String> allParams){
        return "O parametro com metodoComQueryParams2 é: " + allParams.entrySet(); //retorna um array - O parametro com metodoComQueryParams2 é: [id=189, nome=Vinicius, idade=22]
    }

    @PostMapping("/metodoComBodyParams")
    public String metodoComBodyParams(@RequestBody Usuario usuario){
        return "metodoComBodyParams: " + usuario.username;
    }

    @PostMapping("/metodoComHeaders")
    public String metodoComHeaders(@RequestHeader("name") String name){
        return "metodoComHeaders: " + name;
    }

    @PostMapping("/metodoComListHeaders")
    public String metodoComListHeaders(@RequestHeader Map<String, String> headers){
        return "metodoComListHeaders: " + headers.entrySet();
    }

    @GetMapping("/metodoResponseEntity")
    public ResponseEntity<Object> metodoResponseEntity(@RequestParam Long id){
        var usuario = new Usuario("Vinicius");

        if(id > 5) {
            return ResponseEntity.status(HttpStatus.OK).body(usuario);
        }
        return ResponseEntity.badRequest().body("Numero menor que 5");
    }

    record Usuario(String username){}
}
