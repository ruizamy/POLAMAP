package com.fundamentosp.springboot.Fundamentos;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/persona")
public class RestControllerPrueba {

    @PostMapping(path = "/create")
    public Object guardarPersona(Object objeto){
        return  objeto;
    }

}
