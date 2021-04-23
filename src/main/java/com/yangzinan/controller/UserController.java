package com.yangzinan.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/message")
    public String message(){
        String message = messageSource.getMessage("user.name", null, LocaleContextHolder.getLocale());
        return message;
    }

}
