package service.com.vendadecomputadores.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.com.vendadecomputadores.entity.Pessoa;
import service.com.vendadecomputadores.exception.BusinessException;
import service.com.vendadecomputadores.repository.PessoaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class PessoaService {
    @Autowired
    private final PessoaRepository repository;

    public Optional<Pessoa> buscaPorCpf(String cpf) {
        return repository.findByCpf(cpf);
    }

    public Pessoa salvar(Pessoa pessoa) {
        Optional<Pessoa> pessoaComCpfJaCadastrado = repository.findByCpf(pessoa.getCpf());
        boolean existeCpf = false;
        if (pessoaComCpfJaCadastrado.isPresent()) {
            if (!pessoaComCpfJaCadastrado.get().getId().equals(pessoa.getId())) {
                existeCpf = true;
            }
        }
        if (existeCpf) {
            throw new BusinessException("CPF já cadastrado");
        }
        return repository.save(pessoa);
    }

    public List<Pessoa> listarTodos() {
        return repository.findAll();
    }

    public Optional<Pessoa> buscaPorId(UUID id) {
        return repository.findById(id);
    }

    public void deletar(UUID id) {
        repository.deleteById(id);
    }


}
