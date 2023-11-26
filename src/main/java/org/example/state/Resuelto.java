package org.example.state;

import org.example.state.IEstado;
import org.example.entety.Incidente;

public class Resuelto implements IEstado {
    @Override
    public void estadoAbierto(Incidente incidente) {
        System.out.println("Incidente Resuelto , no puede ser abierto");
    }

    @Override
    public void estadoEnReparacion(Incidente incidente) {
        System.out.println("Incidente Resuelto , no puede asignarse el tecnico");
    }

    @Override
    public void estadoResuelto(Incidente incidente) {
        System.out.println("Incidente en estado Resuelto");
    }
}
