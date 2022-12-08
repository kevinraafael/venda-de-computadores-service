package service.com.vendadecomputadores.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import service.com.vendadecomputadores.entity.Pessoa;


import java.util.Optional;
import java.util.UUID;

// Essa anotação eu informo ao spring que ele é um bean e dessa forma será gerenciado pelo spring
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,UUID> {

    Optional<Pessoa> findByCpf(String cpf);

}
