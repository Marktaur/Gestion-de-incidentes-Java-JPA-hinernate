package org.example.state;

import org.example.state.IEstado;
import org.example.entety.Incidente;

public class Resuelto implements IEstado {
    @Override
    public void estadoAbierto(Incidente incidente) {

    }

    @Override
    public void estadoEnReparacion(Incidente incidente) {

    }

    @Override
    public void estadoResuelto(Incidente incidente) {

    }
}
