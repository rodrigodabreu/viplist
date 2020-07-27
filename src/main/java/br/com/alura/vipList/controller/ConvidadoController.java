package br.com.alura.vipList.controller;


import br.com.alura.vipList.model.Convidado;
import br.com.alura.vipList.repository.ConvidadoRepository;
import br.com.alura.vipList.service.ConvidadoService;
import br.com.alura.vipList.service.EmailService;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvidadoController {

    @Autowired
    private ConvidadoRepository convidadoRepository;

    @Autowired
    private ConvidadoService convidadoService;

    @Autowired
    private EmailService emailService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "listaconvidados", method = RequestMethod.GET)
    public String listaConvidados(Model model) {


        Iterable<Convidado> convidados = convidadoService.listarConvidados();

        model.addAttribute("convidados", convidados);

        return "listaconvidados";
    }

    @RequestMapping(value = "salvar", method = RequestMethod.POST)
    public String salvar(@RequestParam("nome") String nome,
                         @RequestParam("email") String email,
                         @RequestParam("telefone") String telefone,
                         Model model) {

        Convidado convidado = new Convidado(nome, email, telefone);
        convidadoService.salvar(convidado);
        emailService.enviar(nome, email);
        Iterable<Convidado> convidados = convidadoService.listarConvidados();
        model.addAttribute("convidados", convidados);

        return "listaconvidados";

    }
    @RequestMapping(value = "deletar", method = RequestMethod.DELETE)
    public String deletar(@RequestParam("idConvidado") Long idConvidado,
                          Model model) {
        convidadoService.removerConvidado(idConvidado);
        Iterable<Convidado> convidados = convidadoService.listarConvidados();
        model.addAttribute("convidados", convidados);
        return "listaconvidados";
    }

}
