package org.huerg.warehouse.controller;

import org.huerg.warehouse.exception.NotEnoughProductException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(NotEnoughProductException.class)
    public ModelAndView handle() {
        var vier = new ModelAndView();
        vier.setViewName("notenough");
        return vier;
    }
}
