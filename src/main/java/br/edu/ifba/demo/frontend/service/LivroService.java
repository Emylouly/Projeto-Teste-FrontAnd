package br.edu.ifba.demo.frontend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.edu.ifba.demo.frontend.dto.LivroDTO;
import reactor.core.publisher.Mono;

@Service
public class LivroService {

    @Autowired
    
    private WebClient webClient;

    public List<LivroDTO> listAllLivro(){
        Mono<List<LivroDTO>> livroList = this.webClient
            .method(HttpMethod.GET)
            .uri("livro/listall")
            .retrieve()
            .bodyToFlux(LivroDTO.class)
            .collectList();
        
        List<LivroDTO> list = livroList.block();
        return list;
    }

    public boolean addLivro(LivroDTO livroDTO) {
        Mono<LivroDTO> response = this.webClient
            .method(HttpMethod.POST)
            .uri("livro/add")
            .bodyValue(livroDTO)
            .retrieve()
            .bodyToMono(LivroDTO.class);

        return response.block() != null;
    }

    public boolean delete(int id_livro){
        Mono<LivroDTO> livroList = this.webClient
            .method(HttpMethod.DELETE)  
            .uri("livro/{id}", id_livro)
            .retrieve()
            .bodyToMono(LivroDTO.class);
        
            LivroDTO livro = livroList.block();
        if (livro!=null) {
            return true;
        }
        return false;

    }
    
}
