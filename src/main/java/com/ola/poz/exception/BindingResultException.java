package com.ola.poz.exception;

import lombok.Getter;
import org.springframework.validation.BindingResult;

public class BindingResultException extends RuntimeException {  //dlatego ze nie sa wymagane do lapania w aplikacji, nie musimy miec obslugi w kodzie, dlatego go rozszerzamy

    @Getter
    private BindingResult bindingResult;

    public BindingResultException(BindingResult bindingResult){
        super();  //super jest zawsze wymagane -> dobra praktyka
        this.bindingResult = bindingResult;
    }

}
