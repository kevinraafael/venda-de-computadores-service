package service.com.vendadecomputadores.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.com.vendadecomputadores.entity.Pessoa;
import service.com.vendadecomputadores.service.PessoaService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscaPorId(@PathVariable UUID id){
        //Verifica se a pessoa existe
        Optional<Pessoa> optionalPessoa = service.buscaPorId(id);
        if(optionalPessoa.isEmpty()){
            return  ResponseEntity.notFound().build();
        }
        Pessoa pessoaEncontrada = optionalPessoa.get();
        return  ResponseEntity.status(HttpStatus.OK).body(pessoaEncontrada);
    }
    @PutMapping("/{id}")
   // ajustar o id no postman
    public ResponseEntity<Pessoa> alterar(@PathVariable UUID id,@RequestBody Pessoa pessoa){
        Pessoa pessoaSalva = service.salvar(pessoa);
        return  ResponseEntity.status(HttpStatus.OK).body(pessoaSalva);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Pessoa> deletar(@PathVariable UUID id){
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}