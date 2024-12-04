package br.edu.ifba.demo.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/livro/buscar/{id}")
public ModelAndView buscarLivroPorId(@PathVariable("id") Long id) {
    ModelAndView model = new ModelAndView();
    try {
        // Chama o serviço para buscar o livro pelo ID
        model.addObject("livro", livroService.getById(id));
        model.setViewName("detalhesLivro"); // Nome da página de detalhes do livro
    } catch (Exception e) {
        model.addObject("erro", "Livro não encontrado para o ID: " + id);
        model.setViewName("erro");
    }
    return model;
}

    
    
}
