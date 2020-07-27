package br.com.alura.vipList.service;

import br.com.alura.vipList.model.Convidado;
import br.com.alura.vipList.repository.ConvidadoRepository;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConvidadoService {

    @Autowired
    private ConvidadoRepository convidadoRepository;

    public Iterable<Convidado> listarConvidados(){
        return convidadoRepository.findAll();
    }

    public void salvar(Convidado convidado){
        convidadoRepository.save(convidado);
    }

    public void removerConvidado(Long idConvidado) {
        convidadoRepository.deleteById(idConvidado);
    }
}
