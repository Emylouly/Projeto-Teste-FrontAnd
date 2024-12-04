package br.edu.ifba.demo.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifba.demo.frontend.service.LivroService;

@Controller
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/livro/listall")
    public ModelAndView livro() {
        ModelAndView model = new ModelAndView();
        model.addObject("listaLivro", livroService.listAll());
        model.setViewName("livro");
        return model;
    }
    
    
}
