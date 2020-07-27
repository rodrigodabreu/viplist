package br.com.alura.vipList.repository;


import br.com.alura.vipList.model.Convidado;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ConvidadoRepository extends CrudRepository<Convidado, Long> {

}
