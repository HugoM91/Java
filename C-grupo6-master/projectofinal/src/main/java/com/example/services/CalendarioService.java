package com.example.services;

import com.example.entity.Calendario;

import java.util.List;

public interface CalendarioService {

    List<Calendario> getCalendario();

    void createCalendario(Calendario calendario);

    void updateCalendario(Calendario calendario);

    void deleteCalendario(Calendario calendario);

}
