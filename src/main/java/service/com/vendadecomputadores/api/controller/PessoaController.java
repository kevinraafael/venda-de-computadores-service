package service.com.vendadecomputadores.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.com.vendadecomputadores.entity.Pessoa;
import service.com.vendadecomputadores.service.PessoaService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService service;

    @PostMapping
    public ResponseEntity<Pessoa> salvar(@RequestBody Pessoa pessoa){
         Pessoa pessoaSalva= service.salvar(pessoa);
         return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listaTodos(){
        List<Pessoa> pessoas = service.listarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(pessoas);
    }

}