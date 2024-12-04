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
        public ModelAndView livro() {

        List<LivroDTO> livro = livroService.listAll();

        ModelAndView model = new ModelAndView();

        model.addObject("listaLivro", livro);
        model.setViewName("livro");
        return model;
    }

       @GetMapping("/buscarporid/{id}")
       public ModelAndView getById(@RequestParam("id") Long id) {

           LivroDTO livro = livroService.getById(id);

           ModelAndView model = new ModelAndView();

           if (livro != null) {

               model.addObject("listaLivros", List.of(livro)); 

           } 
           
           else {

               model.addObject("errorMessage", "Livro não encontrado!");
           }

           model.setViewName("livros");
           return model;
       }
 

        @GetMapping("/livro/buscarporisbn/{isbn}")
        public ModelAndView getByIsbn(@RequestParam("isbn") String isbn) {

            LivroDTO livro = livroService.getByIsbn(isbn);

            ModelAndView model = new ModelAndView();

            model.addObject("livro.isbn", livro);
            model.setViewName("livros");
            return model;
        }
    
        @GetMapping("/livro/buscarportitulo/{titulo}")
        public ModelAndView getByTitulo(@PathVariable("titulo") String titulo) {

        LivroDTO livro = livroService.getByTitulo(titulo);

        ModelAndView model = new ModelAndView();

        if (livro != null) {

            model.addObject("listaLivros", List.of(livro));

        } 
        
        else {

            model.addObject("errorMessage", "Livro não encontrado!");
        }

        model.setViewName("livros");
        return model;

        }

        @GetMapping("livro/deletelivro/{id}")
        public String delete(@RequestParam("id") Long id) {

            livroService.delete(id);
            return "redirect:/livros/listAll";
        }
    
}
