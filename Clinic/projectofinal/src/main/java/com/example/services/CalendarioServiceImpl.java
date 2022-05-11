package com.example.services;

import com.example.entity.Calendario;
import com.example.entity.Consulta;
import com.example.entity.Medico;
import com.example.repositories.CalendarioRepository;
import com.example.repositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarioServiceImpl implements CalendarioService {

    @Autowired
    private CalendarioRepository calendarioRepository;

    @Override
    public List<Calendario> getCalendario() {
        return calendarioRepository.findAll();
    }

    @Override
    public void createCalendario(Calendario calendario) {
        this.calendarioRepository.save(calendario);
    }

    @Override
    public void updateCalendario(Calendario calendario) {
        calendarioRepository.save(calendario);
    }

    @Override
    public void deleteCalendario(Calendario calendario) {
        calendarioRepository.deleteById(calendario.getId());
    }

}
