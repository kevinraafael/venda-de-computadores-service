package service.com.vendadecomputadores.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.com.vendadecomputadores.entity.Pessoa;
import service.com.vendadecomputadores.repository.PessoaRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PessoaService {
    @Autowired
    private final PessoaRepository repository;

    public Optional<Pessoa> buscaPorCpf(String cpf){
        return  repository.findByCpf(cpf);
    }
    public Pessoa salvar(Pessoa pessoa){
        return  repository.save(pessoa);
    }
    public List<Pessoa> listarTodos(){
        return  repository.findAll();
    }



}
