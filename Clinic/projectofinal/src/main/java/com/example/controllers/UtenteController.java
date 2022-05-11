package com.example.controllers;

import com.example.entity.Consulta;
import com.example.entity.Utente;
import com.example.entity.Vaga;
import com.example.faturacao.FaturacaoService;
import com.example.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@SessionAttributes("username")
@Controller
public class UtenteController {

    @Autowired
    private ConsultasService consultasService;

    @Autowired
    private VagaService vagaService;

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private DisponibilidadeService disponibilidadeService;

    @Autowired
    private FaturacaoService faturacaoService;

    @GetMapping(value = "/ute_consulta")
    public String showRegistoMedico2972(ModelMap map) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        map.put("utente", utenteService.getAllUtentes());//mapear a base de dados para o site
        map.put("consulta", consultasService.getConsultasByEstadoAndUtente("Marcada", username));
        return "ute_consulta";
    }

    @GetMapping(value = "/ute_consulta_details/{id}")
    public String showUteConsultaDetails(@PathVariable Long id, ModelMap map) {
        map.put("consulta", consultasService.getConsultaById(id));

        return "ute_consulta_details";
    }

    // --------------------------------

    @GetMapping(value = "/ute_contactos")
    public String showRegistoMedico2971() {
        return "ute_contactos";
    }

    // --------------------------------

    @GetMapping(value = "/ute_home")
    public String showRegistoMedico2970(ModelMap map) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        map.put("username", username);
        map.put("totalConsultas", consultasService.countAllConsultaByNomeUtente(username));
        map.put("consultasMarcadas", consultasService.countAllConsultasByEstadoAndUtente("Marcada", username));
        return "ute_home";
    }

    // --------------------------------
    @GetMapping(value = "/ute_medicos")
    public String showRegistoMedico2979(ModelMap map) {
        map.put("medicos", medicoService.getAllMedicos());
        return "ute_medicos";
    }

    @GetMapping(value = "ute_medico_perfil/{id}")
    public String showPerfilMedico(@PathVariable Long id, ModelMap map) {
        map.put("medico", medicoService.getMedicoById(id));
        map.put("disponibilidadeList", disponibilidadeService.getAllDisponibilidadeByMedico(id));

        return "ute_medico_perfil";
    }

    // --------------------------------

    @GetMapping(value = "/ute_perfil")
    public String showRegistoMedico29788(ModelMap map/*, Utente utente */) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        map.put("utente", utenteService.getAllUtentes());//mapear a base de dados para o site
        map.put("consulta", consultasService.getConsultasByEstadoAndUtente("Realizada", username));
        return "ute_perfil";
    }

    // --------------------------------


    @GetMapping(value = "/ute_editar_perfil")
    public String showRegistoMedico297889(ModelMap map) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        map.put("utente", utenteService.getUtenteByNome(username));//mapear a base de dados para o site

        return "ute_editar_perfil";
    }

    @PostMapping(value = "/ute_editar_perfil")
    public String showRegistoMedico2978899(@RequestParam(name = "idUtente") Long idUtente, Utente utente, ModelMap map) {

        Utente utenteDB = utenteService.getUtenteById(idUtente);
        utenteDB.setTelefone(utente.getTelefone());
        utenteDB.setTelemovel(utente.getTelemovel());
        utenteDB.setMorada(utente.getMorada());
        utenteDB.setCodigoPostal(utente.getCodigoPostal());
        utenteDB.setLocalidade(utente.getLocalidade());
        utenteDB.setObservacoes(utente.getObservacoes());
        utenteService.updateUtente(idUtente, utenteDB);
        return "redirect:/ute_perfil";
    }

    // --------------------------------

    @GetMapping(value = "/ute_info_gerais")
    public String showRegistoMedico297887() {
        return "ute_info_gerais";
    }

    // --------------------------------

    @GetMapping(value = "/ute-nova-consulta/{id}")
    public String showNovaConsultaModal(@PathVariable Long id, ModelMap map) {
        Consulta consulta = new Consulta();
        map.put("consulta", consulta);
        map.put("vaga", vagaService.getVagaById(id));
        return "ute_nova_consulta_modal";
    }

    @PostMapping(value = "/ute_registar_consulta/{id}")
    public String registar_consulta(@PathVariable Long id, Vaga vaga, @ModelAttribute Consulta consulta) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        Vaga vagaDB = vagaService.getVagaById(id);
        vagaDB.setDisponivel(false);
        consulta.setEstado("Marcada");
        consulta.setVaga(vagaDB);
        consulta.setIdUtente(utenteService.getUtenteByNome(username));
        consultasService.createConsulta(consulta);
        vagaService.updateVaga(id, vagaDB);
        return "redirect:/ute_consulta";
    }

    // --------------------------------

}
