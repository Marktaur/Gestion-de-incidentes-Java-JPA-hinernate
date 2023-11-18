package org.example.estados;

import org.example.IEstado;
import org.example.Incidente;

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
