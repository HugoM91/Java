package com.example.controllers;

import com.example.entity.*;
import com.example.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.time.LocalDate;

@SessionAttributes()
@Controller
public class CalendarioController {

    @Autowired
    CalendarioService calendarioService;

    @Autowired
    EspecialidadeService especialidadeService;

    @Autowired
    DisponibilidadeService disponibilidadeService;

    @Autowired
    MedicoService medicoService;

    @Autowired
    UtenteService utenteService;

    @Autowired
    VagaService vagaService;

    // --------------------------------

    @GetMapping(value = "/ute_calendario")
    public String f_calendarioPage8(ModelMap map) {
        //mapear a base de dados para o site
        map.put("medicosList", medicoService.getAllMedicos());
        map.put("especialidadeList", especialidadeService.getAllEspecialidade());


        return "/ute_calendario";
    }

    @PostMapping(value = {"/ute_calendario"})
    public String loginClicked1111(ModelMap map, @RequestParam(name = "data") String data, @RequestParam(name = "idMedico", required = false) Long idMedico, @RequestParam(name = "especialidade", required = false) Long idEspecialidade) {

        if (idEspecialidade == null) {
            map.put("vagaList", vagaService.getAllByDisponivelTrueAndDataAndDisponibilidade_Medico_IdMedico(LocalDate.parse(data), idMedico));
        } else if (idMedico == null) {
            map.put("vagaList", vagaService.getAllByDisponivelTrueAndDataAndDisponibilidade_Medico_Especialidade_IdEspecialidade(LocalDate.parse(data), idEspecialidade));
        }
        map.put("medicosList", medicoService.getAllMedicos());
        map.put("especialidadeList", especialidadeService.getAllEspecialidade());
        map.put("utenteList", utenteService.getAllUtentes());

        return "/ute_calendario";
    }

    // -------------------------------- @ModelAttribute("/med_calendario") Calendario calendario,

    @GetMapping(value = "/med_calendario")
    public String f_calendarioPage2(ModelMap map) {
        map.put("disponibilidade", new Disponibilidade());


        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        map.put("medicosList", medicoService.getMedicoByNome(username));
        map.put("vagasList", vagaService.getAllVagasByUsername(username));
        return "/med_calendario";
    }


    @PostMapping(value = {"/med_calendario"})
    public String loginClicked33333(@ModelAttribute Disponibilidade disponibilidade, ModelMap map) {

        disponibilidadeService.createDisponibilidade(disponibilidade);
        //map.put("procurar", calendario);
        System.out.println(disponibilidade.getInicioTurno());
        if (disponibilidade.getInicioTurno() != null) {
            vagaService.generateVagas(disponibilidade, LocalDate.now());
        }


        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        map.put("medicosList", medicoService.getMedicoByNome(username));
        map.put("vagasList", vagaService.getAllVagasByUsername(username));

        return "/med_calendario";
    }

    // --------------------------------

    @GetMapping(value = "/fun_calendario")
    public String f_calendarioPage22(ModelMap map) {
        //mapear a base de dados para o site
        map.put("medicosList", medicoService.getAllMedicos());
        map.put("especialidadeList", especialidadeService.getAllEspecialidade());
        return "/fun_calendario";
    }


    @PostMapping(value = {"/fun_calendario"})
    public String loginClicked44444(ModelMap map, @RequestParam(name = "data") String data, @RequestParam(name = "idMedico", required = false) Long idMedico, @RequestParam(name = "especialidade", required = false) Long idEspecialidade) {

        if (idEspecialidade == null) {
            map.put("vagaList", vagaService.getAllByDisponivelTrueAndDataAndDisponibilidade_Medico_IdMedico(LocalDate.parse(data), idMedico));
        } else if (idMedico == null) {
            map.put("vagaList", vagaService.getAllByDisponivelTrueAndDataAndDisponibilidade_Medico_Especialidade_IdEspecialidade(LocalDate.parse(data), idEspecialidade));
        }
        map.put("medicosList", medicoService.getAllMedicos());
        map.put("especialidadeList", especialidadeService.getAllEspecialidade());
        map.put("utenteList", utenteService.getAllUtentes());

        return "/fun_calendario";
    }

}
