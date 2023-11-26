package org.example.state;


import org.example.state.IEstado;
import org.example.entety.Incidente;

public class EnReparacion implements IEstado {
    @Override
    public void estadoAbierto(Incidente incidente) {
        System.out.println("Incidente En reparacion no puede ser Abierto");
    }

    @Override
    public void estadoEnReparacion(Incidente incidente) {
        System.out.println("Incidente En reparacion con Tecnico Asignado");
    }

    @Override
    public void estadoResuelto(Incidente incidente) {
        if ( incidente.getSolucion()!=1)
            incidente.setEstado(new Resuelto());
        System.out.println("Cambiando de estado a Resuelto");
    }
}
