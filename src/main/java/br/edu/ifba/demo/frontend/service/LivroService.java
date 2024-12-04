package br.edu.ifba.demo.frontend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import br.edu.ifba.demo.frontend.dto.LivroDTO;
import reactor.core.publisher.Mono;

@Service
public class LivroService {

    private final String BASE_URL = "http://localhost:8081/livro";
    private final RestTemplate Temp = new RestTemplate();

    public List<LivroDTO> listAll() {
        return List.of(Temp.getForObject(BASE_URL + "/listall", LivroDTO.class));
    }

    public LivroDTO getById(Long id) {
        return Temp.getForObject(BASE_URL + "/buscarporid/{id}/" + id, LivroDTO.class);
    }

    public LivroDTO getByIsbn(String isbn) {
        return Temp.getForObject(BASE_URL + "/buscarporisbn/{isbn}/" + isbn, LivroDTO.class);
    }

    public LivroDTO getByTitulo(String titulo) {
        return Temp.getForObject(BASE_URL + "/buscarportitulo/{titulo}/" + titulo, LivroDTO.class);
    }

    public LivroDTO save(LivroDTO livro) {
        return Temp.postForObject(BASE_URL, livro, LivroDTO.class);
    }

    public void delete(Long id) {
        Temp.delete(BASE_URL + "/deletelivro/{id}/" + id);
    }
    
}
