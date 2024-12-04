package br.edu.ifba.demo.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifba.demo.frontend.dto.LivroDTO;
import br.edu.ifba.demo.frontend.service.LivroService;
import br.edu.ifba.demo.frontend.service.LivroService;

@Controller
public class LivroController {

    @Autowired
    private LivroService livroService;

        @GetMapping("/livro/listall")
        public ModelAndView livro(){

            List<LivroDTO> livro = livroService.listAll();
            ModelAndView model = new ModelAndView();
            model.addObject("listaLivro", livro);
            model.setViewName("livro");
            return model;

        }
    
}
